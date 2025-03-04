package main.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import main.DAOimplement.UserDAOImpl;
import main.clientDAO.UserDAO;
import main.service.BankService;
import main.model.User;
import main.serviceImpl.BankServiceImpl;

public class DepositServlet extends HttpServlet {
    private BankService bankService;

    public DepositServlet() {
        // Initialize the BankService dependency
        UserDAO userDAO = new UserDAOImpl(); // Initialize DAO
        this.bankService = new BankServiceImpl(userDAO); // Initialize Service
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

        if (amount > 0) {
            user.setBalance(user.getBalance() + amount);
            bankService.updateBalance(user.getUserId(), user.getBalance());
            bankService.recordTransaction(user.getUserId(), "Deposit", amount);
            session.setAttribute("user", user);
            session.setAttribute("balance", user.getBalance());
            response.sendRedirect("dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "Amount must be greater than zero.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("deposit.jsp");
            dispatcher.forward(request, response);
        }
    }
}