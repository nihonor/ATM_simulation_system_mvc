package main.DAOimplement;

import main.model.Transaction;
import main.model.User;
import main.utility.Dboperation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements main.clientDAO.UserDAO {
    private Dboperation dbOperation;

    public UserDAOImpl() {
        this.dbOperation = new Dboperation();
    }

    @Override
    public User validateUser(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            ResultSet resultSet = dbOperation.get(query, username, password);
            if (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                double balance = resultSet.getDouble("balance");
                return new User(userId, username, password, balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBalance(int userId, double newBalance) {
        try {
            String query = "UPDATE users SET balance = ? WHERE userId = ?";
            dbOperation.put(query, newBalance, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recordTransaction(int userId, String type, double amount) {
        try {
            String query = "INSERT INTO transactions (userId, type, amount) VALUES (?, ?, ?)";
            dbOperation.insert(query, userId, type, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(int userId) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            String query = "SELECT type, amount, timestamp FROM transactions WHERE userId = ?";
            ResultSet resultSet = dbOperation.get(query, userId);
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                double amount = resultSet.getDouble("amount");
                String timestamp = resultSet.getString("timestamp");
                transactions.add(new Transaction(type, amount, timestamp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}