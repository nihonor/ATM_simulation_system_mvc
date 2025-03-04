package main.service;

import main.model.Transaction;
import main.model.User;

import java.util.List;

public interface BankService {
    User validateUser(String username, String password);
    void updateBalance(int userId, double newBalance);
    void recordTransaction(int userId, String type, double amount);
    List<Transaction> getTransactionHistory(int userId);
}