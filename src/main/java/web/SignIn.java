package web;

import dao.UserDao;
import model.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "signin", value = "/signin")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/signin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        if (userDao.userIsExist(username, password)) {
            UserRole role = userDao.getRoleByLoginPassword(username, password);
            setSessionAttributes(req, resp, username, password, userDao, role);
            resp.sendRedirect("/home.jsp");
        } else {
            resp.sendRedirect("/signin.jsp");
        }
    }

    static void setSessionAttributes(HttpServletRequest req, HttpServletResponse resp, String username, String password,
                                     UserDao userDao, UserRole role) throws IOException {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("username", username);
        httpSession.setAttribute("role", role);
        httpSession.setAttribute("password", password);
        httpSession.setAttribute("user_id", userDao.getUserByLoginPassword(username, password).getId());
    }
}
