package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.RoleDAO;
import web.DAO.RoleDAOImpl;
import web.DAO.UserDAO;
import web.DAO.UserDAOImpl;
import web.models.Role;
import web.models.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        //user.getRoles().add(new Role("dgdg"));
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userDAO.getById(id);
    }
}
