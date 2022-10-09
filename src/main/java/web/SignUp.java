package web;
import model.UserRole;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUp extends AbstractUserServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/new-view/sign-up.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserRole userRole = UserRole.valueOf(req.getParameter("role"));
        if (!(username.isEmpty() && password.isEmpty() && userRole.toString().isEmpty())) {
            getUserService().signUp(username, password, userRole);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("role", userRole);
            resp.sendRedirect("/view/home.jsp");
        } else {
            resp.sendRedirect("/new-view/sign-up.jsp");
        }
    }

}

