package ru.job4j.servlets;

import ru.job4j.Post;
import ru.job4j.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", PsqlStore.instOf().findAllPosts());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("/post/posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().savePost(
                new Post(
                        0,
                        req.getParameter("Имя"),
                        req.getParameter("Описание")
                )
        );
        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }

}
