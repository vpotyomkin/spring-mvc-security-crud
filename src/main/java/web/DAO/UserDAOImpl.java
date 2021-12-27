package web.DAO;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String username) {
        Query query = entityManager.createQuery("SELECT id FROM User WHERE name = :username");
        query.setParameter("username", username);
        Long id = (Long) query.getResultList().get(0);
        return entityManager.find(User.class, id);
    }

    @Override
    public void edit(User editedUser) {
        entityManager.merge(editedUser);
    }
}
