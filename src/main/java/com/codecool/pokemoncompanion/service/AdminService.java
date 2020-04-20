package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    UserRepository userRepository;

    public void banUserByUserId(Long userId) {
        userRepository.banUserByUserId(userId);
    }

    public List<User> getNonAdminUsers() {
        return userRepository.getNonAdminUsers();
    }
}
