package web.Service;

import org.springframework.stereotype.Service;
import web.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> getAll();
    //void add(Role role);
    void delete(long id);
    //void edit(Role role);
    Role getById(long id);
}
