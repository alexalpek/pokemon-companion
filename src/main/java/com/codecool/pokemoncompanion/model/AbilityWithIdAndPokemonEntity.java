package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Ability;
import com.codecool.pokemoncompanion.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AbilityWithIdAndPokemonEntity extends Ability {

    @Id
    private long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "abilities")
/*            @ToString.Exclude
            @EqualsAndHashCode.Exclude*/
    Set<PokemonEntity> pokemonEntity = new HashSet<>();

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbilityWithIdAndPokemonEntity that = (AbilityWithIdAndPokemonEntity) o;
        return pokemonEntity.equals(that.pokemonEntity) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pokemonEntity, name);
    }

    public AbilityWithIdAndPokemonEntity(Ability ability){
        this.setName(ability.getName());
        this.setUrl(ability.getUrl());
        this.id = Util.getIdFromUrl(ability.getUrl());
    }
}
