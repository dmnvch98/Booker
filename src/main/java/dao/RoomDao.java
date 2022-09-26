package dao;

import model.Room;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class RoomDao implements Dao<Room> {
    List<Room> listOfRooms;
    @Override
    public void save(Room value) {

    }

    @Override
    public void update(Room value) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Room get(int id) {
        return null;
    }

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
