package ru.pcs.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.models.User;
import ru.pcs.web.services.UsersService;

import java.util.List;

@Controller
public class UsersControllers {

    private final UsersService userService;

    @Autowired
    public UsersControllers(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model,
                           @ModelAttribute("add_user") User user) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("add_user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("user/{id}/delete-user")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("user/{id}/update-user")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        System.out.println("Button EDIT IS WORK: - " + user);
        model.addAttribute("add_user, user");
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }
}
