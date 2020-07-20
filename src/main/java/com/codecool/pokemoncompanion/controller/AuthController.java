package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.UserCredentials;
import com.codecool.pokemoncompanion.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserCredentials data) {
        Map<Object, Object> response = authService.signin(data);
        return ResponseEntity.ok(response);
    }
}
