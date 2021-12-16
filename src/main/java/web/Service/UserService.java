package web.Service;

import web.models.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
}
