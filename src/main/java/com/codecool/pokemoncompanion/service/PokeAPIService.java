package com.codecool.pokemoncompanion.service;

import com.codecool.pokemoncompanion.model.generated.Pokemon;
import com.codecool.pokemoncompanion.model.generated.PokemonList;
import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.model.wrapper.ResultItemWithId;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class PokeAPIService {

    @Cacheable("allPokemons")
    public List<ResultItemWithId> getPokemons(int limit, int pageNumber)  {
        String apiPath = "https://pokeapi.co/api/v2/pokemon/?offset=" + pageNumber + "&limit=" + limit;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PokemonList> responseEntity = restTemplate.exchange(apiPath, HttpMethod.GET, null, PokemonList.class);
        return Objects.requireNonNull(responseEntity.getBody()).getResults()
                .stream()
                .map(ResultItemWithId::new)
                .collect(Collectors.toList());
    }


    @Cacheable("getPokemonByID")
    public Pokemon getPokemonByID(int id)  {
        String apiPath = "https://pokeapi.co/api/v2/pokemon/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pokemon> responseEntity = restTemplate.exchange(apiPath, HttpMethod.GET, null, Pokemon.class);
        return responseEntity.getBody();
    }

    @Cacheable("getPokemonByName")
    public Pokemon getPokemonByName(String name){
        String apiPath = "https://pokeapi.co/api/v2/pokemon/" + name;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pokemon> responseEntity = restTemplate.exchange(apiPath, HttpMethod.GET, null, Pokemon.class);
        return responseEntity.getBody();
    }

}
