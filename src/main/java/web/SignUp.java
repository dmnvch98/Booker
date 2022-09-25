package web;
import dao.Dao;
import dao.UserDao;
import model.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUp extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        if(username.isEmpty() || name.isEmpty() ||
                password.isEmpty() || phone.isEmpty())
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
            requestDispatcher.include(req, resp);
        }
        else
        {
            User user = userService.registerUser(username, password, name, phone);
            Dao<User> userDao = new UserDao();
            userDao.save(user);
            req.setAttribute("user", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcome.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

}

