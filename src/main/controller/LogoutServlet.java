package main.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate session to log out
            System.out.println("Session invalidated for user."); // Debug message
        }
        response.sendRedirect("loginPage"); // Redirect to login page
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the login page
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("loginPage");
    }
}