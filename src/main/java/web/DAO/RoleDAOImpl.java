package web.DAO;

import org.springframework.stereotype.Repository;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Set<Role> getAll() {
        return new HashSet<>(entityManager.createQuery("from Role", Role.class).getResultList());
    }

    /*
    public void add(Role role) {
        entityManager.persist(role);
    }*/

    @Override
    public void delete(long id) {
        entityManager.remove(getById(id));
    }

    /*@Override
    public void edit(Role roleEdited) {
        entityManager.merge(roleEdited);
    }*/

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }
}
