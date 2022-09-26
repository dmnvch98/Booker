package web;

import dao.BookingDao;
import dao.UserDao;
import model.Booking;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "user-bookings", value = "/user-bookings")
public class UserBookings extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookingDao bookingDao = new BookingDao();
        Integer userId = (Integer) req.getSession().getAttribute("user_id");
        User user = new UserDao().get(userId);
        List<Booking> userBookings = bookingDao.getUserBookings(user);
        req.setAttribute("userBookings",userBookings);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user-bookings.jsp");
        requestDispatcher.include(req, resp);
    }
}
