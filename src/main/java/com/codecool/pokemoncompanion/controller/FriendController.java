package com.codecool.pokemoncompanion.controller;


import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.repository.UserRepository;
import com.codecool.pokemoncompanion.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class FriendController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendService friendService;

    @PutMapping("/{userId}/request-friend/{friendId}")
    public void requestFriendship(@PathVariable("userId") Long userid, @PathVariable("friendId") Long friendId) {
        friendService.requestFriendshipByUserID(userid, friendId);
    }

    @PutMapping("/{userId}/accept-friend/{friendId}")
    public void acceptFriendship(@PathVariable("userId") Long userid, @PathVariable("friendId") Long friendId) {
        friendService.acceptFriendship(userid, friendId);
    }

    @GetMapping("/id/{id}/friends")
    public Set<User> getFriends(@PathVariable("id") Long userid) {
        return userRepository.findFriends(userid);
    }

    @GetMapping("/id/{id}/requests")
    public Set<User> getPendingFriends(@PathVariable("id") Long userId) {
        return userRepository.findPendingFriends(userId);
    }

    @GetMapping("/name/{name}/friends")
    public Set<User> getFriendsByName(@PathVariable("name") String userName) {
        return userRepository.findFriendsByName(userName);
    }

    @GetMapping("/name/{name}/requests")
    public Set<User> getPendingFriends(@PathVariable("name") String userName) {
        return userRepository.findPendingFriendsByName(userName);
    }
}