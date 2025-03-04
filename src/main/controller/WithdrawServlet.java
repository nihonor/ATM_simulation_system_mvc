package main.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import main.DAOimplement.UserDAOImpl;
import main.clientDAO.UserDAO;
import main.service.BankService;
import main.model.User;
import main.serviceImpl.BankServiceImpl;

public class WithdrawServlet extends HttpServlet {
    private BankService bankService;

    public WithdrawServlet() {
        UserDAO userDAO = new UserDAOImpl(); // Initialize DAO
        this.bankService = new BankServiceImpl(userDAO); // Initialize BankService
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        double amount = Double.parseDouble(request.getParameter("amount"));
        User user = (User) session.getAttribute("user");

        if (amount > 0 && amount <= user.getBalance()) {
            user.setBalance(user.getBalance() - amount);
            bankService.updateBalance(user.getUserId(), user.getBalance());
            bankService.recordTransaction(user.getUserId(), "Withdrawal", amount);
            session.setAttribute("user", user);
            session.setAttribute("balance", user.getBalance());
            response.sendRedirect("dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid amount or insufficient funds.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("withdraw.jsp");
            dispatcher.forward(request, response);
        }
    }
}