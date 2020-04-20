package com.codecool.pokemoncompanion.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class GameIndicesItem{

	@JsonProperty("game_index")
	private int gameIndex;

	@JsonProperty("version")
	private Version version;

	public void setGameIndex(int gameIndex){
		this.gameIndex = gameIndex;
	}

	public int getGameIndex(){
		return gameIndex;
	}

	public void setVersion(Version version){
		this.version = version;
	}

	public Version getVersion(){
		return version;
	}

	@Override
 	public String toString(){
		return 
			"GameIndicesItem{" + 
			"game_index = '" + gameIndex + '\'' + 
			",version = '" + version + '\'' + 
			"}";
		}
}