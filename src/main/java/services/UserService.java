package services;

import model.User;

import javax.persistence.*;

public class UserService {
    public User registerUser(String username, String password, String name, String phone) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        return user;
    }

    public void addUserToDB(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
