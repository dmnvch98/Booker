package web;

import repository.BookingDao;
import repository.RoomDao;
import repository.UserRepository;
import model.Booking;
import model.Room;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "add-booking", value = "/add-booking")
public class AddBooking extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Now in add booking");
        Booking booking = new Booking();
        UserRepository userDao = new UserRepository(null);
        BookingDao bookingDao = new BookingDao();
        RoomDao roomDao = new RoomDao();

        Integer userId = (Integer) req.getSession().getAttribute("user_id");
        String startDate = (String) req.getSession().getAttribute("start_date");
        String endDate = (String) req.getSession().getAttribute("end_date");
        String roomId = req.getParameter("id");
        Room room = roomDao.get(Integer.parseInt(roomId));

        booking.setUser(userDao.get(userId));
        booking.setStartDate(LocalDate.parse(startDate));
        booking.setEndDate(LocalDate.parse(endDate));
        booking.setRoom(room);
        bookingDao.save(booking);
        req.getSession().setAttribute("bookingAdded", true);
        resp.sendRedirect("/myapp/view/user-bookings");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }
}
