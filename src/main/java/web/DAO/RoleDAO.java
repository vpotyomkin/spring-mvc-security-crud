package web.DAO;

import web.models.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> allRoles();
    void add(Role role);
    void delete(long id);
    void edit(Role role);
    Role getById(long id);
}
