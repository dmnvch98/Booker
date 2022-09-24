package dao;

import model.User;
import org.hibernate.Session;
import utils.HibernateUtil;

import org.hibernate.Transaction;
import java.util.List;

public class UserDao implements Dao<User> {
    @Override
    public void save(User value) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(value);
            transaction.commit();
        }
    }

    @Override
    public void update(User value) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return new User();
    }

    @SuppressWarnings("unchecked")
    public List <User> getAll() {

        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from User").getResultList();
            System.out.println(listOfUser);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
}
