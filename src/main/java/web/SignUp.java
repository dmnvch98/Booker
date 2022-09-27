package web;
import dao.Dao;
import dao.UserDao;
import model.User;
import model.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserRole role = UserRole.valueOf(req.getParameter("role"));

        if(username.isEmpty() || password.isEmpty())
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
            requestDispatcher.include(req, resp);
        }
        else
        {
            UserDao userDao = new UserDao();
            User user = new User(username, password, role);
            userDao.save(user);
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("role", role);
            httpSession.setAttribute("password", password);
            httpSession.setAttribute("user_id", userDao.getUserByLoginPassword(username, password).getId());
            resp.sendRedirect("/home.jsp");
        }
    }

}

