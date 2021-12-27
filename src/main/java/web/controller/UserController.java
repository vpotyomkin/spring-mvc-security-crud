package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.RoleService;
import web.Service.UserService;
import web.models.Role;
import web.models.User;

import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("userInfo",new User());
        return "users";}

    @PostMapping(path = "/users")
    public String add(@ModelAttribute("userInfo") User user){
        userService.add(user);
        return "redirect:/users";
    }

    @DeleteMapping(path = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";}

    @GetMapping(path = "/users/edit/{id}")
    public String getUser(Model model, @PathVariable("id") long id) {
        User oldUser = userService.getById(id);
        model.addAttribute("userInfo", oldUser);
        return "edit";}

    @PatchMapping(path = "/users/edit/{id}")
    public String editUser(@ModelAttribute User user, @PathVariable("id") long id) {
        userService.edit(user);
        return "redirect:/users";}
}