package web;

import dao.RoomDao;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "add-booking", value = "/add-booking")
public class AddBooking extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
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
