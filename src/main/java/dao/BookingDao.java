package dao;

import model.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class BookingDao implements Dao<Booking> {
    @Override
    public void save(Booking value) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
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

    }

    @Override
    public Booking get(int id) {
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return null;
    }
}
