package com.codecool.pokemoncompanion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Builder
public class PokemonEntity {

    @Id
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TypeWithIdAndPokemonEntity> types = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    private Set<User> userPokemons = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    private Set<User> userWishListPokemons = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    private Set<User> userFavPokemons = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<AbilityWithIdAndPokemonEntity> abilities = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    private int height;         //decimetres
    private int weight;        //hectograms

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonEntity that = (PokemonEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    public PokemonEntity(Long id, String name, Set<TypeWithIdAndPokemonEntity> types,
                         Set<AbilityWithIdAndPokemonEntity> abilities, int height, int weight) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PokemonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
