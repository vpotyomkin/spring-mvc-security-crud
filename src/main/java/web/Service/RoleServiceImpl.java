package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.RoleDAO;
import web.models.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDAO roleDAO;

    @Override
    public List<Role> allRoles() {
        return roleDAO.allRoles();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    public void delete(long id) {
        roleDAO.delete(id);
    }

    @Override
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Override
    public Role getById(long id) {
        return roleDAO.getById(id);
    }
}
