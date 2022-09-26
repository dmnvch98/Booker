package web;

import dao.BookingDao;
import dao.RoomDao;
import dao.UserDao;
import model.Booking;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@WebServlet(name = "add-booking", value = "/add-booking")
public class AddBooking extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Booking booking = new Booking();
        UserDao userDao = new UserDao();
        BookingDao bookingDao = new BookingDao();

        Integer userId = (Integer) req.getSession().getAttribute("user_id");
        String startDate = req.getParameter("start_date");
        String endDate = req.getParameter("end_date");
        Room room = (Room) req.getSession().getAttribute("room");

        booking.setUser(userDao.get(userId));
        booking.setStartDate(LocalDate.parse(startDate));
        booking.setEndDate(LocalDate.parse(endDate));
        booking.setRoom(room);
        bookingDao.save(booking);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomDao roomDao = new RoomDao();
        List<Room> roomList = roomDao.getAll();
        req.setAttribute("rooms", roomList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addBooking.jsp");
        dispatcher.forward(req, resp);
    }
}
