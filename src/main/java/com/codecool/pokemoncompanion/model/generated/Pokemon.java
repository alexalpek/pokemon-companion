package com.codecool.pokemoncompanion.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Generated("com.robohorse.robopojogenerator")
public class Pokemon{

	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;

	@JsonProperty("types")
	private List<TypesItem> types;

	@JsonProperty("base_experience")
	private int baseExperience;

	@JsonProperty("held_items")
	private List<Object> heldItems;

	@JsonProperty("weight")
	private int weight;

	@JsonProperty("is_default")
	private boolean isDefault;

	@JsonProperty("sprites")
	private Sprites sprites;

	@JsonProperty("abilities")
	private List<AbilitiesItem> abilities;

	@JsonProperty("game_indices")
	private List<GameIndicesItem> gameIndices;

	@JsonProperty("species")
	private Species species;

	@JsonProperty("stats")
	private List<StatsItem> stats;

	@JsonProperty("moves")
	private List<MovesItem> moves;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("forms")
	private List<FormsItem> forms;

	@JsonProperty("height")
	private int height;

	@JsonProperty("order")
	private int order;

	public void setLocationAreaEncounters(String locationAreaEncounters){
		this.locationAreaEncounters = locationAreaEncounters;
	}

	public String getLocationAreaEncounters(){
		return locationAreaEncounters;
	}

	public void setTypes(List<TypesItem> types){
		this.types = types;
	}

	public List<TypesItem> getTypes(){
		return types;
	}

	public void setBaseExperience(int baseExperience){
		this.baseExperience = baseExperience;
	}

	public int getBaseExperience(){
		return baseExperience;
	}

	public void setHeldItems(List<Object> heldItems){
		this.heldItems = heldItems;
	}

	public List<Object> getHeldItems(){
		return heldItems;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setIsDefault(boolean isDefault){
		this.isDefault = isDefault;
	}

	public boolean isIsDefault(){
		return isDefault;
	}

	public void setSprites(Sprites sprites){
		this.sprites = sprites;
	}

	public Sprites getSprites(){
		return sprites;
	}

	public void setAbilities(List<AbilitiesItem> abilities){
		this.abilities = abilities;
	}

	public List<AbilitiesItem> getAbilities(){
		return abilities;
	}

	public void setGameIndices(List<GameIndicesItem> gameIndices){
		this.gameIndices = gameIndices;
	}

	public List<GameIndicesItem> getGameIndices(){
		return gameIndices;
	}

	public void setSpecies(Species species){
		this.species = species;
	}

	public Species getSpecies(){
		return species;
	}

	public void setStats(List<StatsItem> stats){
		this.stats = stats;
	}

	public List<StatsItem> getStats(){
		return stats;
	}

	public void setMoves(List<MovesItem> moves){
		this.moves = moves;
	}

	public List<MovesItem> getMoves(){
		return moves;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setForms(List<FormsItem> forms){
		this.forms = forms;
	}

	public List<FormsItem> getForms(){
		return forms;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	@Override
 	public String toString(){
		return 
			"Pokemon{" + 
			"location_area_encounters = '" + locationAreaEncounters + '\'' + 
			",types = '" + types + '\'' + 
			",base_experience = '" + baseExperience + '\'' + 
			",held_items = '" + heldItems + '\'' + 
			",weight = '" + weight + '\'' + 
			",is_default = '" + isDefault + '\'' + 
			",sprites = '" + sprites + '\'' + 
			",abilities = '" + abilities + '\'' + 
			",game_indices = '" + gameIndices + '\'' + 
			",species = '" + species + '\'' + 
			",stats = '" + stats + '\'' + 
			",moves = '" + moves + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",forms = '" + forms + '\'' + 
			",height = '" + height + '\'' + 
			",order = '" + order + '\'' + 
			"}";
		}
}