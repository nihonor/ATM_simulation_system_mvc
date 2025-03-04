    <%@ page contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Deposit</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f3f4f6;
                padding: 20px;
            }
            .deposit-container {
                background-color: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 300px;
                margin: 0 auto;
                text-align: center;
            }
            input, button {
                margin: 10px 0;
                width: 100%;
                padding: 10px;
                border-radius: 5px;
                border: 1px solid #ddd;
            }
            button {
                background-color: #6c63ff;
                color: white;
                border: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="deposit-container">
            <h2>Deposit Funds</h2>
            <h1></h1>
            <form action="deposit" method="post">
                <label for="amount">Amount:</label>
                <input type="number" name="amount" id="amount" placeholder="Enter amount" required>
                <button type="submit">Deposit</button>
            </form>
            <a href="dashboard">Back to Dashboard</a>
        </div>
    </body>
    </html>