package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "welcome", value = "/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Now in welcome page");
        if (req.getSession().getAttribute("name") != null) {
            resp.sendRedirect("/home.jsp");
        } else {
            resp.sendRedirect("/signin.jsp");
        }
    }
}