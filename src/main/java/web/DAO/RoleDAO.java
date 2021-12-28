package web.DAO;

import web.models.Role;

import java.util.Set;

public interface RoleDAO {
    Set<Role> getAll();
    void delete(long id);
    Role getById(long id);
}
