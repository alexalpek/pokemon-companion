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

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registerAccount(@RequestBody UserRegistrationEntity data) {
        return registrationService.registerAccount(data);
    }

}
