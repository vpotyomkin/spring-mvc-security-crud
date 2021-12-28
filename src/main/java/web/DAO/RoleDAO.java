package web.DAO;

import web.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    Set<Role> getAll();
    //void add(Role role);
    void delete(long id);
    //void edit(Role role);
    Role getById(long id);
}
