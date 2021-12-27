package web.Service;

import org.springframework.stereotype.Service;
import web.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRoles();
    void add(Role role);
    void delete(long id);
    void edit(Role role);
    Role getById(long id);
}
