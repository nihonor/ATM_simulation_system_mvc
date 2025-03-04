<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="main.model.User" %>
<%
    // Prevent caching of this page
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
       response.setHeader("Pragma", "no-cache"); // HTTP 1.0
       response.setHeader("Expires", "0"); // Proxies

       // Prevent unauthorized access
       User user = (User) session.getAttribute("user");
       if (user == null) {
           response.sendRedirect("index.jsp");
           return;
       }

    // Get the username and balance from the session
    String username = (String) session.getAttribute("username");
    Double balance = (Double) session.getAttribute("balance");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            padding: 20px;
        }
        .welcome-message {
            font-size: 24px;
            color: #333;
        }
        .action-buttons {
            margin-top: 20px;
        }
        .action-buttons a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #6c63ff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .action-buttons a:hover {
            background-color: #5750c4;
        }
    </style>
</head>
<body>

<div class="welcome-message">
    Welcome, <%= username %>!
</div>
<div class="balance-message">
    Your current balance: <%= balance != null ? balance : "Not available" %>
</div>

<div class="action-buttons">
    <a href="withDrawPage">Withdraw</a>
    <a href="depositPage">Deposit</a>
    <a href="logout">Logout</a>
</div>
</body>
</html>