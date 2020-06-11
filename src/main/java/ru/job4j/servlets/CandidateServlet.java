package ru.job4j.servlets;

import ru.job4j.Candidate;
import ru.job4j.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.setAttribute("candidatesPhotos", PsqlStore.instOf().findAllCandidatePhoto());
        req.setAttribute("cities", PsqlStore.instOf().findAllCities());
        req.getRequestDispatcher("/candidate/candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().saveCandidate(
                new Candidate(
                        req.getParameter("Имя"),
                        Integer.parseInt(req.getParameter("cityId"))));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
