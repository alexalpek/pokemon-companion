package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.wrapper.ResultItemWithId;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokeSaveService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import com.codecool.pokemoncompanion.service.UsersPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/pokemon")
@RestController
public class PokeListController {

    private PokemonCreator pokemonCreator;
    private PokeAPIService pokeAPIService;
    private PokeSaveService pokeSaveService;
    private UsersPokemonService usersPokemonService;

    @Autowired
    public PokeListController(PokemonCreator pokemonCreator, PokeAPIService pokeAPIService, PokeSaveService pokeSaveService, UsersPokemonService usersPokemonService) {
        this.pokemonCreator = pokemonCreator;
        this.pokeAPIService = pokeAPIService;
        this.pokeSaveService = pokeSaveService;
        this.usersPokemonService = usersPokemonService;
    }

    @GetMapping("/")
    public List<ResultItemWithId> pokes() {
        return pokeAPIService.getPokemons(900, 0);
    }


    @GetMapping("/name/{name}")
    public PokemonEntity pokemonByName(@PathVariable("name") String name) {
        name = name.toLowerCase();
        Pokemon pokemon = pokeAPIService.getPokemonByName(name);
        return pokemonCreator.createPokemon(pokemon);
    }

    @PutMapping("/mypokemon/add/{id}")
    public void pokemonToMyPokemonList(@PathVariable("id") int pokemonId) throws Exception {
        pokeSaveService.addToMyPokemonList(pokemonId);
    }

    @PutMapping("/favourites/add/{id}")
    public void pokemonToMyPokemonFavorite(@PathVariable("id") int pokemonId) throws Exception {
        pokeSaveService.addToMyFavouriteList(pokemonId);
    }

    @PutMapping("/wishlist/add/{id}")
    public void pokemonToMyPokemonWishList(@PathVariable("id") int pokemonId) throws Exception {
        pokeSaveService.addToMyWishList(pokemonId);
    }

    @GetMapping("/mypokemon/")
    public List<PokemonEntity> getMyMyPokemons() {
        return usersPokemonService.getMyPokemonsOfUser();
    }

    @GetMapping("/favourites/")
    public List<PokemonEntity> getMyFavourites() {
        return usersPokemonService.getFavouritePokemonsOfUser();
    }

    @GetMapping("/wishlist/")
    public List<PokemonEntity> getMyWishList() {
        return usersPokemonService.getWishListPokemonsOfUser();
    }

}
