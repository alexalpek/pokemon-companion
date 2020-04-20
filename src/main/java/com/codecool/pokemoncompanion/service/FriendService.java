package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FriendService {

    @Autowired
    UserRepository userRepository;

    public void requestFriendshipByUserID(Long userid, Long friendId) {
        User user = userRepository.findUserById(userid);
        User requestedFriend = userRepository.findUserById(friendId);
        user.requestFriendship(requestedFriend);
        userRepository.save(requestedFriend);
    }

    public void acceptFriendship(Long userid, Long friendId) {
        User requested = userRepository.findUserById(userid);
        User requesting = userRepository.findUserById(friendId);
        requested.confirmFriends(requesting);
        userRepository.saveAll(Arrays.asList(requested, requesting));
    }
}