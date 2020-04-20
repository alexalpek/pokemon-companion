package com.codecool.pokemoncompanion.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationEntity {
    private String name;
    private String password;
    private String email;
}
