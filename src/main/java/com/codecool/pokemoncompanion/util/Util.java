package com.codecool.pokemoncompanion.util;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Util {

    @Autowired
    UserRepository userRepository;

    public static long getIdFromUrl(String url){
        String[] array = url.split("/");
        return Long.parseLong(array[array.length-1]);
    }

    public User getCurrentUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw new Exception();
        String username = authentication.getName();
        User user = userRepository.findByName(username);
        return user;
    }

}
