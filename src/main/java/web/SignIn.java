package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "signin", value = "/signin")
public class SignIn extends AbstractUserServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/new-view/sign-in.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (getUserService().userIsExist(username, password)) {
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("role", getUserService().getUserRole(username, password));
            resp.sendRedirect("/view/home.jsp");
        } else {
            resp.sendRedirect("/new-view/sign-in.jsp");
        }
    }
}
