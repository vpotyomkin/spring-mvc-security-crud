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

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public List allUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> results = entityManager.createQuery("from User", User.class).getResultList();
        entityManager.close();
        return results;
    }

    @Override
    public void add(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        entityManager.persist(newUser);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User user = entityManager.find(User.class, String.valueOf(id));
        entityManager.remove(user);
        entityTransaction.commit();
        entityManager.close();

    }

    @Override
    public User getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User user = entityManager.find(User.class, String.valueOf(id));
        entityManager.close();
        return user;
    }

    @Override
    public void edit(User editedUser, Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User oldUser = entityManager.find(User.class, String.valueOf(id));
        oldUser.setName(editedUser.getName());
        oldUser.setSurname(editedUser.getSurname());
        oldUser.setEmail(editedUser.getEmail());
        entityTransaction.commit();
        entityManager.close();
    }
}
