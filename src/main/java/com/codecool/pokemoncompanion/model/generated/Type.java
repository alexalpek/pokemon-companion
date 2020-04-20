package com.codecool.pokemoncompanion.model.generated;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

@Data
@Generated("com.robohorse.robopojogenerator")
public class Type{

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	@Override
 	public String toString(){
		return 
			"Type{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}