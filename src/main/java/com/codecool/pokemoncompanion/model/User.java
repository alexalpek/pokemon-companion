package com.codecool.pokemoncompanion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;
    private String email;

    @JsonBackReference
    @ManyToMany
    public Set<User> friends = new HashSet<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
    private boolean banned;

    @ManyToMany(mappedBy = "userPokemons")
    private List<PokemonEntity> myPokemonsList;

    @ManyToMany(mappedBy = "userFavPokemons")
    private List<PokemonEntity> favouritePokemonsList;

    @ManyToMany(mappedBy = "userWishListPokemons")
    private List<PokemonEntity> myPokemonWishList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @JsonBackReference
    @OneToMany
    public Set<User> friendRequests = new HashSet<>();
    @JsonIgnore
    @NotNull
    private String password;

    public void requestFriendship(User user) {
        user.friendRequests.add(this);
    }

    public void confirmFriends(User user) {
        this.friendRequests.remove(user);
        user.friends.add(this);
        this.friends.add(user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", banned=" + banned +
                '}';
    }
}
