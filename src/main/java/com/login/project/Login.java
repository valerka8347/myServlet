package com.login.project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> optionalUser= Validate.checkUser(login, password);

        if(optionalUser.isPresent())
        {
            HttpSession session = req.getSession();
            session.setAttribute("user", optionalUser.get());
            resp.getWriter().write("<span style=\"color: red\">Hello " + optionalUser.get().getName()+"<\\span>");
        }
        else
        {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = req.getRequestDispatcher("index.html");
            rs.include(req, resp);
        }
    }
}
