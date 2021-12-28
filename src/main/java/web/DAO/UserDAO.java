package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void add(User user);
    void delete(long id);
    void edit(User user);
    User getById(long id);
    User getByUsername(String username);
}
