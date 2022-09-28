package dao;

import model.Booking;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class BookingDao implements Dao<Booking> {
    List<Booking> bookingList;

    public BookingDao() {
        this.bookingList = getAll();
        System.out.println();
    }

    @Override
    public void save(Booking value) {
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(value);
            transaction.commit();
        }
    }

    @Override
    public void update(Booking value) {

    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Booking booking = session.get(Booking.class, id);
            if (booking != null) {
                session.delete(booking);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Integer> getBookingsByDate(long bookingStartDate, long bookingEndDate) {
        List<Integer> foundRoomsForSpecifiedDates = new ArrayList<>();
        for (Booking booking : bookingList) {
            if ((bookingStartDate <= booking.getEndDate().toEpochDay()) &&
                            (booking.getStartDate().toEpochDay() <= bookingEndDate)) {
                foundRoomsForSpecifiedDates.add(booking.getRoom().getId());
            }
        }
        return foundRoomsForSpecifiedDates;
    }

    @Override
    public Booking get(int id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getAll() {
        Transaction transaction = null;
        List<Booking> bookingList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            bookingList = session.createQuery("from Booking").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookingList;
    }

    public List<Booking> getUserBookings(User user) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getUser().getId() == user.getId()) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }
}
