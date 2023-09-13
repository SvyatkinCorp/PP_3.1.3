package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")

public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> showAllUsers() {
        List<User> allUsers = userService.getAllUser();
        return allUsers;
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        return user;

    }
    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.addPerson(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping()
    public User update(@RequestBody User user) {
        userService.updateUser(user.getId(), user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "User " + id + " deleted";
    }
}