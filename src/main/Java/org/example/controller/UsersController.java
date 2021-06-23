package org.example.controller;

import org.example.service.UserService;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping()//полный список
    public String list(Model model) {
        model.addAttribute("users", userService.usersList());
        return "users/list";
    }

    @GetMapping("/new") //форма для нового юзера
    public String newUser(Model model) {           //@ModelAttribute
        model.addAttribute("user", new User());

        return "users/new";
    }

    @PostMapping//перенаправление на страницу всех юзеров
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        userService.deleteUser(id);
        return "redirect:/users";
    }

}
