package dao;

import model.Room;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoomDao implements Dao<Room> {
    public RoomDao() {
        this.listOfRooms = getAll();
    }

    List<Room> listOfRooms;

    @Override
    public void save(Room value) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(value);
            transaction.commit();
        }
    }

    @Override
    public void update(Room value) {

    }

    @Override
    public void delete(int id) {

    }

    @SuppressWarnings("unchecked")
    public List<Room> filterRoomsByDates(String startDate, String endDate) {
        long bookingStartDate = LocalDate.parse(startDate).toEpochDay();
        long bookingEndDate = LocalDate.parse(endDate).toEpochDay();
        List<Integer> busyRooms = new BookingDao().getBookingsByDate(bookingStartDate, bookingEndDate);
        List<Room> availableRooms = listOfRooms.stream()
                .filter(r -> busyRooms.stream().noneMatch(br -> br == r.getId()))
                .collect(Collectors.toList());
        return availableRooms;
//Получаю список букингов на введенную дату, достаю из них рум айди, а затем фильтрую румы исключая найденные адишки
//        List<Room> availableRooms = new ArrayList<>();
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // get an user object
//
//            availableRooms = session
//                    .createNamedQuery("selectBooksByDates")
//                    .setParameter("startDate", startDate)
//                    .setParameter("endDate", endDate)
//                            .getResultList();
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
////            if (transaction != null) {
////                transaction.rollback();
////            }
//            e.printStackTrace();
//        }
//        return availableRooms;
    }

    @Override
    public Room get(int id) {
        for (Room room : listOfRooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfRooms = session.createQuery("from Room").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
        return listOfRooms;
    }
}
