package com.codecool.pokemoncompanion.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Sprites{

	@JsonProperty("back_shiny_female")
	private Object backShinyFemale;

	@JsonProperty("back_female")
	private Object backFemale;

	@JsonProperty("back_default")
	private String backDefault;

	@JsonProperty("front_shiny_female")
	private Object frontShinyFemale;

	@JsonProperty("front_default")
	private String frontDefault;

	@JsonProperty("front_female")
	private Object frontFemale;

	@JsonProperty("back_shiny")
	private String backShiny;

	@JsonProperty("front_shiny")
	private String frontShiny;

	public void setBackShinyFemale(Object backShinyFemale){
		this.backShinyFemale = backShinyFemale;
	}

	public Object getBackShinyFemale(){
		return backShinyFemale;
	}

	public void setBackFemale(Object backFemale){
		this.backFemale = backFemale;
	}

	public Object getBackFemale(){
		return backFemale;
	}

	public void setBackDefault(String backDefault){
		this.backDefault = backDefault;
	}

	public String getBackDefault(){
		return backDefault;
	}

	public void setFrontShinyFemale(Object frontShinyFemale){
		this.frontShinyFemale = frontShinyFemale;
	}

	public Object getFrontShinyFemale(){
		return frontShinyFemale;
	}

	public void setFrontDefault(String frontDefault){
		this.frontDefault = frontDefault;
	}

	public String getFrontDefault(){
		return frontDefault;
	}

	public void setFrontFemale(Object frontFemale){
		this.frontFemale = frontFemale;
	}

	public Object getFrontFemale(){
		return frontFemale;
	}

	public void setBackShiny(String backShiny){
		this.backShiny = backShiny;
	}

	public String getBackShiny(){
		return backShiny;
	}

	public void setFrontShiny(String frontShiny){
		this.frontShiny = frontShiny;
	}

	public String getFrontShiny(){
		return frontShiny;
	}

	@Override
 	public String toString(){
		return 
			"Sprites{" + 
			"back_shiny_female = '" + backShinyFemale + '\'' + 
			",back_female = '" + backFemale + '\'' + 
			",back_default = '" + backDefault + '\'' + 
			",front_shiny_female = '" + frontShinyFemale + '\'' + 
			",front_default = '" + frontDefault + '\'' + 
			",front_female = '" + frontFemale + '\'' + 
			",back_shiny = '" + backShiny + '\'' + 
			",front_shiny = '" + frontShiny + '\'' + 
			"}";
		}
}