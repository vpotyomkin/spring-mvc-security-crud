package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(new User(user.getName(), user.getSurname(), user.getEmail()));
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(getById(id));

    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, String.valueOf(id));
    }

    @Override
    public void edit(User editedUser, Integer id) {
        getById(id).setValues(editedUser.getName(), editedUser.getSurname(), editedUser.getEmail());
    }
}
