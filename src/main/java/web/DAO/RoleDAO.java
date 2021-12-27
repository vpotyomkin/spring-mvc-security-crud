package web.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import web.models.Role;
import web.models.User;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    List<Role> allRoles();
    void add(Role role);
    void delete(long id);
    void edit(Role role);
    Role getById(long id);
}
