package ru.job4j.servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetingServletJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/JSON");
        resp.setCharacterEncoding("UTF-8");
        String inputText = req.getParameter("inputText");
        JSONObject jsonObject = new JSONObject(inputText);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println(jsonObject);
        writer.flush();
    }
}
