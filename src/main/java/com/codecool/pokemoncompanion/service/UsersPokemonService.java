package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersPokemonService {

    @Autowired
    UserRepository userRepository;

    public List<PokemonEntity> getFavouritePokemonsOfUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByName(username);
        return userRepository.getFavouritePokemonByUserId(user.getId());
    }

    public List<PokemonEntity> getMyPokemonsOfUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByName(username);
        return userRepository.getUserPokemonByUserId(user.getId());
    }

    public List<PokemonEntity> getWishListPokemonsOfUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByName(username);
        return userRepository.getWishListByUserId(user.getId());
    }
}
