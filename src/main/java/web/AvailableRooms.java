package web;

import repository.RoomDao;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "available-rooms", value = "/available-rooms")
public class AvailableRooms extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Now in available rooms");
        String startDate = req.getParameter("start_date");
        String endDate = req.getParameter("end_date");
        req.getSession().setAttribute("start_date", startDate);
        req.getSession().setAttribute("end_date", endDate);

        RoomDao roomDao = new RoomDao();
        List<Room> availableRooms = roomDao.filterRoomsByDates(startDate, endDate);
        req.setAttribute("rooms", availableRooms);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/select-room.jsp");
        dispatcher.forward(req, resp);
    }
}
