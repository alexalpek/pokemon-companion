package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService {

    private UserRepository userRepository;

    public boolean isUsernameAvailable(String username) {
        return userRepository.findByName(username) == null;

    }

    public void registerUser(String username, String password, String email) {
        userRepository.save(User.builder()
                .name(username)
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password))
                .banned(false)
                .email(email)
                .build());
    }
}
