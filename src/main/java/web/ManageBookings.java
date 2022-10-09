package web;

import dao.BookingDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "manage-bookings", value = "/manage-bookings")
public class ManageBookings extends HttpServlet {
    BookingDao bookingDao = new BookingDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("booking-id") != null) {
            delete(req, resp);
        } else {
            redirectToManageBookings(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectToManageBookings(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookingIdToDelete = Integer.parseInt(req.getParameter("booking-id"));
        bookingDao.delete(bookingIdToDelete);
        redirectToManageBookings(req, resp);
    }

    public void redirectToManageBookings(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookings", bookingDao.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/manage-bookings.jsp");
        requestDispatcher.include(req, resp);
    }
}
