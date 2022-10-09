package repository;

import model.User;
import model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import org.hibernate.Transaction;

import java.util.List;

public class UserRepository implements UserDao {
    private final List<User> listOfUser;
    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        listOfUser = getAll();
    }

    @Override
    public void save(final String username, final String password, final UserRole userRole) {
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = new User(username, password, userRole);
            session.save(user);
            transaction.commit();
        }
    }

    @Override
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
        for (User user : listOfUser) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean userIsExist(final String username, final String password) {
        for (User user : listOfUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
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

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Transaction transaction = null;
        List<User> listOfUser = null;
        try (Session session = sessionFactory.openSession()) {
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
