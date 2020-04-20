package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.UserRegistrationEntity;
import com.codecool.pokemoncompanion.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<String> registerAccount(@RequestBody UserRegistrationEntity data) {
        try {
            String username = data.getName();
            String password = data.getPassword();
            String email = data.getEmail();
            if (registrationService.isUsernameAvailable(username)) {
                registrationService.registerUser(username, password, email);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
