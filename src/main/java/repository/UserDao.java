package repository;

import model.User;
import model.UserRole;

import java.util.List;

public interface UserDao {
    void save(String username, String password, UserRole userRole);
    void update(User user);
    void delete(int id);
    User get(int id);
    List<User> getAll();
    UserRole getRoleByLoginPassword(String username, String password);

    boolean userIsExist(String username, String password);
    User getUserByLoginPassword(String username, String password);
}