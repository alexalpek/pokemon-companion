package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.MyPokemon;
import com.codecool.pokemoncompanion.model.generated.AbilitiesItem;
import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.model.generated.TypesItem;
import com.codecool.pokemoncompanion.service.PokeAPIService;
import com.codecool.pokemoncompanion.service.PokemonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PokeListController {

    @Autowired
    private PokemonCreator pokemonCreator;

    @Autowired
    private PokeAPIService pokeAPIService;

    @GetMapping("/pokes")
    public List<ResultsItem> pokes() {
        return pokeAPIService.getPokemons(20, 1);
    }

    @GetMapping("/poke/{id}")
    public Pokemon poke(@PathVariable("id") int id) {
        return pokeAPIService.getPokemon(id);
    }

    @GetMapping("/poke2/{id}")
    public MyPokemon poke2(@PathVariable("id") int id) {
        Pokemon pokemon =  pokeAPIService.getPokemon(id);
        return pokemonCreator.createPokemon(pokemon);
    }
}
