<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // Set default language if not already set
    if (request.getAttribute("title") == null) {
        request.getRequestDispatcher("changeLanguage?lang=en").forward(request, response);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        select, input, button {
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

    <!-- Language Selector -->
    <form action="changeLanguage" method="get">
        <label for="language">Change Language:</label>
        <select name="lang" id="language" onchange="this.form.submit()">
            <option value="en" ${empty lang || lang == 'en' ? 'selected' : ''}>English</option>
                <option value="fr" ${lang == 'fr' ? 'selected' : ''}>  Français</option>
            <option value="es" ${lang == 'es' ? 'selected' : ''}>Español</option>
            <option value="de" ${lang == 'de' ? 'selected' : ''}>Deutsch</option>
        </select>
    </form>

    <!-- Login Form -->
    <div class="login-container">
        <h2>${title}</h2>
        <form action="login" method="post">
            <label for="cardNumber">${cardLabel}</label>
            <input type="text" name="username" id="cardNumber" placeholder="${cardPlaceholder}" required>

            <label for="pin">${pinLabel}</label>
            <input type="password" name="password" id="pin" placeholder="${pinPlaceholder}" required>

            <button type="submit">${loginButton}</button>
        </form>
    </div>

</body>
</html>