package ru.job4j.servlets;

import ru.job4j.PsqlStore;
import ru.job4j.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().saveUser(
                new User(
                        req.getParameter("name"),
                        req.getParameter("email"),
                        req.getParameter("password")));
        req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
    }
}
