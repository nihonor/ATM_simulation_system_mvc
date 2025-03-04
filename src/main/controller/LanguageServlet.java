package main.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LanguageServlet extends HttpServlet {
    private static final Map<String, Map<String, String>> LANGUAGE_MAP = new HashMap<>();

    static {
        // English
        Map<String, String> en = new HashMap<>();
        en.put("title", "Login");
        en.put("cardLabel", "Card Number");
        en.put("cardPlaceholder", "Enter your card number");
        en.put("pinLabel", "PIN");
        en.put("pinPlaceholder", "Enter your PIN");
        en.put("loginButton", "Login");
        LANGUAGE_MAP.put("en", en);

        // French
        Map<String, String> fr = new HashMap<>();
        fr.put("title", "Connexion");
        fr.put("cardLabel", "Numéro de carte");
        fr.put("cardPlaceholder", "Entrez votre numéro de carte");
        fr.put("pinLabel", "PIN");
        fr.put("pinPlaceholder", "Entrez votre PIN");
        fr.put("loginButton", "Connexion");
        LANGUAGE_MAP.put("fr", fr);

        // Spanish
        Map<String, String> es = new HashMap<>();
        es.put("title", "Iniciar Sesión");
        es.put("cardLabel", "Número de tarjeta");
        es.put("cardPlaceholder", "Ingrese su número de tarjeta");
        es.put("pinLabel", "PIN");
        es.put("pinPlaceholder", "Ingrese su PIN");
        es.put("loginButton", "Iniciar Sesión");
        LANGUAGE_MAP.put("es", es);

        // German
        Map<String, String> de = new HashMap<>();
        de.put("title", "Anmeldung");
        de.put("cardLabel", "Kartennummer");
        de.put("cardPlaceholder", "Geben Sie Ihre Kartennummer ein");
        de.put("pinLabel", "PIN");
        de.put("pinPlaceholder", "Geben Sie Ihre PIN ein");
        de.put("loginButton", "Anmelden");
        LANGUAGE_MAP.put("de", de);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lang = request.getParameter("lang");
        if (lang == null || !LANGUAGE_MAP.containsKey(lang)) {
            lang = "en"; // Default to English
        }

        // Set language attributes in the request scope
        request.setAttribute("title", LANGUAGE_MAP.get(lang).get("title"));
        request.setAttribute("cardLabel", LANGUAGE_MAP.get(lang).get("cardLabel"));
        request.setAttribute("cardPlaceholder", LANGUAGE_MAP.get(lang).get("cardPlaceholder"));
        request.setAttribute("pinLabel", LANGUAGE_MAP.get(lang).get("pinLabel"));
        request.setAttribute("pinPlaceholder", LANGUAGE_MAP.get(lang).get("pinPlaceholder"));
        request.setAttribute("loginButton", LANGUAGE_MAP.get(lang).get("loginButton"));

        // Forward to the login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}