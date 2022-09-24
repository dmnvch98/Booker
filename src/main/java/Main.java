import dao.Dao;
import dao.UserDao;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Sashka");
        user.setPassword("1234");
        user.setPhone("23984234");
        user.setUsername("kakashka");
        Dao<User> userDao = new UserDao();
        userDao.save(user);
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin();
//            User user = new User();
//            user.setName("Sashka");
//            user.setPassword("1234");
//            user.setPhone("23984234");
//            user.setUsername("kakashka");
//            entityManager.persist(user);
//            transaction.commit();
//        } finally {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            entityManager.close();
//            entityManagerFactory.close();
//        }
    }
}
