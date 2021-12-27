package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void edit(Role roleEdited) {
        entityManager.merge(roleEdited);
    }

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }
}
