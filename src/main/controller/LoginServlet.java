package main.controller;

import main.DAOimplement.UserDAOImpl;
import main.clientDAO.UserDAO;
import main.model.User;
import main.service.BankService;
import main.utility.DatabaseConnection;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.serviceImpl.BankServiceImpl;

public class LoginServlet extends HttpServlet {
    private BankService bankService;


    public LoginServlet() {
        // Initialize the BankService dependency
        UserDAO userDAO = new UserDAOImpl(); // Initialize DAO
        this.bankService = new BankServiceImpl(userDAO); // Initialize Service
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = bankService.validateUser(username, password);
        if (authenticateUser(username, password)) {
            // On successful login, create a session and redirect to the dashboard
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("user", user);
            session.setAttribute("balance", user.getBalance());
            System.out.println("Session created for user: " + username); // Debug message
            response.sendRedirect("dashboard");
        } else {
            // On failure, redirect back to login with an error message
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Redirect GET requests to the login page
//        response.sendRedirect("index.jsp");
//    }

    private boolean authenticateUser(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;
                    System.out.println("User authenticated: " + username); // Debug message
                } else {
                    System.out.println("Invalid credentials for user: " + username); // Debug message
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}