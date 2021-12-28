package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.RoleService;
import web.Service.UserService;
import web.models.Role;
import web.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "redirect:/users";
    }

    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(path = "/admin/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userInfo",new User());
        model.addAttribute("allRoles", roleService.getAll());
        return "/admin/users";}

    @PostMapping(path = "/admin/users")
    public String add(@ModelAttribute("userInfo") User user, @ModelAttribute("rolesSelected") Set<Long> roles){
        Set<Role> roleSet = new HashSet<>();
        for (Long s : roles) {
            roleSet.add(roleService.getById(s));
        }
        /*newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(roleSet);*/
        User newUser = new User(user.getUsername(), user.getFirstName(), user.getLastName(),user.getPassword(),roleSet);
        userService.add(newUser);
        return "redirect:/admin/users";
    }

    @DeleteMapping(path = "/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin/users";}

    @GetMapping("/user")
    public String login (@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "/user";
    }

    @GetMapping("/{id}")
    public String showUser (@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "/user";
    }

    @GetMapping(path = "/admin/users/edit/{id}")
    public String getUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("allRoles", roleService.getAll());
        model.addAttribute("userToEdit", userService.getById(id));
        return "admin/edit";}

    @PatchMapping(path = "/admin/users/edit/{id}")
    public String editUser(@ModelAttribute User user, @PathVariable("id") long id, @ModelAttribute("rolesSelected") Set<Long> roles) {
        Set<Role> roleSet = new HashSet<>();
        for (Long s : roles) {
            roleSet.add(roleService.getById(s));
        }
        user.setUsername(user.getUsername());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPassword(user.getPassword());
        user.setRoles(roleSet);
        userService.edit(user);
        return "redirect:/admin/users";}
}