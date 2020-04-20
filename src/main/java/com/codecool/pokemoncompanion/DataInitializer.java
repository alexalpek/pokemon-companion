package com.codecool.pokemoncompanion;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@AllArgsConstructor
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .email("user@cc.com")
                .name("user")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"))
                .roles(Collections.singletonList("ROLE_USER"))
                .myPokemonsList(new ArrayList<>())
                .favouritePokemonsList(new ArrayList<>())
                .myPokemonWishList(new ArrayList<>())
                .banned(false)
                .build();
        userRepository.save(user);
        User user2 = User.builder()
                .email("user2@cc.com")
                .name("user2")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"))
                .roles(Collections.singletonList("ROLE_USER"))
                .myPokemonsList(new ArrayList<>())
                .favouritePokemonsList(new ArrayList<>())
                .myPokemonWishList(new ArrayList<>())
                .build();
        userRepository.save(user2);
        User user3 = User.builder()
                .email("user3@cc.com")
                .name("user3")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"))
                .roles(Collections.singletonList("ROLE_USER"))
                .myPokemonsList(new ArrayList<>())
                .favouritePokemonsList(new ArrayList<>())
                .myPokemonWishList(new ArrayList<>())
                .build();
        userRepository.save(user3);

        for (int i = 5; i < 20; i++) {
            userRepository.save(User.builder()
                    .email("manyuser" + i + "@cc.com")
                    .name("user" + i)
                    .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"))
                    .roles(Collections.singletonList("ROLE_USER"))
                    .myPokemonsList(new ArrayList<>())
                    .favouritePokemonsList(new ArrayList<>())
                    .myPokemonWishList(new ArrayList<>())
                    .banned(false)
                    .build());
        }

        User admin = User.builder()
                .email("admin@cc.com")
                .name("admin")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"))
                .roles(Collections.singletonList("ROLE_ADMIN"))
                .myPokemonsList(new ArrayList<>())
                .favouritePokemonsList(new ArrayList<>())
                .myPokemonWishList(new ArrayList<>())
                .banned(false)
                .build();
        admin.setFriends(Stream.of(user, user2).collect(Collectors.toSet()));
        admin.setFriendRequests(Stream.of(user3).collect(Collectors.toSet()));
        userRepository.save(admin);
    }
}
