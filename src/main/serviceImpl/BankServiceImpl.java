package main.serviceImpl;

import main.model.User;
import main.model.Transaction;
import main.clientDAO.UserDAO;
import java.util.List;

public class BankServiceImpl implements main.service.BankService {
    private UserDAO userDAO;

    public BankServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User validateUser(String username, String password) {
        return userDAO.validateUser(username, password);
    }

    @Override
    public void updateBalance(int userId, double newBalance) {
        userDAO.updateBalance(userId, newBalance);
    }

    @Override
    public void recordTransaction(int userId, String type, double amount) {
        userDAO.recordTransaction(userId, type, amount); // This will now work
    }

    @Override
    public List<Transaction> getTransactionHistory(int userId) {
        return userDAO.getTransactionHistory(userId);
    }
}