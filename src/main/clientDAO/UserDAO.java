package main.clientDAO;

import main.model.Transaction;
import main.model.User;

import java.util.List;

public interface UserDAO {
    User validateUser(String username, String password);
    void updateBalance(int userId, double newBalance);
    void recordTransaction(int userId, String type, double amount); // Add this method
    List<Transaction> getTransactionHistory(int userId);
}