<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Withdraw</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            padding: 20px;
        }
        .withdraw-container {
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
    <div class="withdraw-container">
        <h2>Withdraw Funds</h2>
        <form action="withdraw" method="post">
            <label for="amount">Amount:</label>
            <input type="number" name="amount" id="amount" placeholder="Enter amount" required>
            <button type="submit">Withdraw</button>
        </form>
        <a href="dashboard">Back to Dashboard</a>
    </div>
</body>
</html>