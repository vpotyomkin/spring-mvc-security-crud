package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(Integer id);
    void edit(User user, Integer id);
    User getById(Integer id);
}
