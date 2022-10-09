package services;

import model.User;
import model.UserRole;
import repository.UserDao;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean userIsExist(final String username, final String password) {
        return userDao.userIsExist(username, password);
    }

    public void signUp(final String username, final String password, final UserRole userRole) {
        userDao.save(username, password, userRole);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public UserRole getUserRole(final String username, final String password) {
        return userDao.getRoleByLoginPassword(username, password);
    }

}
