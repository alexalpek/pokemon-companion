package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.User;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.repository.PokemonEntityRepository;
import com.codecool.pokemoncompanion.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeSaveService {

    @Autowired
    private PokemonCreator pokemonCreator;

    @Autowired
    private PokeAPIService pokeAPIService;

    @Autowired
    Util util;

    @Autowired
    PokemonEntityRepository pokemonEntityRepository;


    public void addToMyPokemonList(int pokemonId) throws Exception {
        User currentUser = util.getCurrentUser();
        PokemonEntity pokemon = createPokemonForOrm(pokemonId);
        pokemon.getUserPokemons().add(currentUser);
        pokemonEntityRepository.saveAndFlush(pokemon);

    }

    public void addToMyWishList(int pokemonId) throws Exception {
        User currentUser = util.getCurrentUser();
        PokemonEntity pokemon = createPokemonForOrm(pokemonId);
        pokemon.getUserWishListPokemons().add(currentUser);
        pokemonEntityRepository.saveAndFlush(pokemon);
    }

    public void addToMyFavouriteList(int pokemonId) throws Exception {
        User currentUser = util.getCurrentUser();
        PokemonEntity pokemon = createPokemonForOrm(pokemonId);
        pokemon.getUserFavPokemons().add(currentUser);
        pokemonEntityRepository.saveAndFlush(pokemon);
    }

    private PokemonEntity createPokemonForOrm(int pokemonId) {
        PokemonEntity pokemon = getMyPokemonById(pokemonId);
        pokemon.getAbilities().forEach(ability -> ability.getPokemonEntity().add(pokemon));
        pokemon.getTypes().forEach(type -> type.getPokemonEntity().add(pokemon));
        pokemon.getUserWishListPokemons().forEach(user -> user.getMyPokemonWishList().add(pokemon));
        pokemon.getUserFavPokemons().forEach(user -> user.getFavouritePokemonsList().add(pokemon));
        pokemon.getUserPokemons().forEach(user -> user.getMyPokemonsList().add(pokemon));
        return pokemon;
    }

    private PokemonEntity getMyPokemonById(int id) {
        Pokemon pokemon = pokeAPIService.getPokemonByID(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
