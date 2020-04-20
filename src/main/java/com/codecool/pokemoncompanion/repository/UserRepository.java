package com.codecool.pokemoncompanion.repository;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByOrderByEmailAsc();

    User findByName(String name);


    User findUserById(Long id);

    @Query(value = "select u.friends from User u where u.id = :id")
    Set<User> findFriends(@Param("id") Long id);

    @Query(value = "select u.friends from User u where u.name = :name")
    Set<User> findFriendsByName(@Param("name") String name);

    @Query(value = "select u.friendRequests from User u where u.id = :id")
    Set<User> findPendingFriends(@Param("id") Long id);

    @Query(value = "select u.friendRequests from User u where u.name = :name")
    Set<User> findPendingFriendsByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.banned = true WHERE u.id = ?1")
    void banUserByUserId(Long id);


    @Query("SELECT u FROM User u WHERE 'ROLE_USER' MEMBER OF u.roles")
    List<User> getNonAdminUsers();


    @Query("SELECT u.favouritePokemonsList FROM User u WHERE u.id = ?1")
    List<PokemonEntity> getFavouritePokemonByUserId(Long userId);

    @Query("SELECT u.myPokemonsList FROM User u WHERE u.id = ?1")
    List<PokemonEntity> getUserPokemonByUserId(Long userId);

    @Query("SELECT u.myPokemonWishList FROM User u WHERE u.id = ?1")
    List<PokemonEntity> getWishListByUserId(Long userId);
}
