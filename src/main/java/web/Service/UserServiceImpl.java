package web.Service;

import org.springframework.stereotype.Component;
import web.DAO.UserDAO;
import web.DAO.UserDAOImpl;
import web.models.User;

import java.util.List;


@Component
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }
}
