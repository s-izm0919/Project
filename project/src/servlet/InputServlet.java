package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

public class InputServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException{
        req.setCharacterEncoding("sjis");

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        UserBean bean = new UserBean();
        bean.setName(name);
        bean.setPass(pass);

        req.setAttribute("user",bean);

        RequestDispatcher dis = req.getRequestDispatcher("result.jsp");

        dis.forward(req,res);

    }
}