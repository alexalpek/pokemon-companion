package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.UserRegistrationEntity;
import com.codecool.pokemoncompanion.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService {

    private final UserRepository userRepository;

    public ResponseEntity<HttpStatus> registerAccount(UserRegistrationEntity data) {
        try {
            String username = data.getName();
            String password = data.getPassword();
            String email = data.getEmail();
            if (isUsernameAvailable(username)) {
                registerUser(username, password, email);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isUsernameAvailable(String username) {
        return userRepository.findByName(username) == null;

    }

    private void registerUser(String username, String password, String email) {
        userRepository.save(User.builder()
                .name(username)
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password))
                .banned(false)
                .email(email)
                .build());
    }
}
