package dao;

import model.User;
import model.UserRole;
import org.hibernate.Session;
import utils.HibernateUtil;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    List <User> listOfUser;

    public UserDao() {
        this.listOfUser = getAll();
    }

    @Override
    public void save(User value) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(value);
            transaction.commit();
        }
    }

    public UserRole getRoleByLoginPassword(final String username, final String password) {
        for (User user : listOfUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getRole();
            }
        }
        return null;
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
    public boolean userIsExist(final String username, final String password) {
        for (User user : listOfUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public User getUserByLoginPassword(final String username, final String password) {
        User result = new User();
        result.setId(-1);

        for (User user : listOfUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                result = user;
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List <User> getAll() {
        Transaction transaction = null;
        List <User> listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from User").getResultList();

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
