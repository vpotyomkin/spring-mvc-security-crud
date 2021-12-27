package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(long id);
    void edit(User user);
    User getById(long id);
    User getUserByName(String username);
}
