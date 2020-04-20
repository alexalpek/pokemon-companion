package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    AdminService adminService;

    @PutMapping("/ban/{id}")
    public void banUser(@PathVariable("id") Long userId) {
        adminService.banUserByUserId(userId);
    }

    @GetMapping("/users")
    public List<User> getNonAdminUsers() {
        return adminService.getNonAdminUsers();
    }
}
