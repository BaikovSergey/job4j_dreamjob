package ru.job4j.servlets;

import org.json.JSONObject;
import ru.job4j.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CitiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Map<Integer, String> cities = PsqlStore.instOf().findAllCities();
        JSONObject jsonObject = new JSONObject(cities);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(resp.getOutputStream(),
                StandardCharsets.UTF_8), true);
        writer.println(jsonObject);
        writer.flush();
    }
}
