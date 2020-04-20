package com.codecool.pokemoncompanion.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MovesItem{

	@JsonProperty("version_group_details")
	private List<VersionGroupDetailsItem> versionGroupDetails;

	@JsonProperty("move")
	private Move move;

	public void setVersionGroupDetails(List<VersionGroupDetailsItem> versionGroupDetails){
		this.versionGroupDetails = versionGroupDetails;
	}

	public List<VersionGroupDetailsItem> getVersionGroupDetails(){
		return versionGroupDetails;
	}

	public void setMove(Move move){
		this.move = move;
	}

	public Move getMove(){
		return move;
	}

	@Override
 	public String toString(){
		return 
			"MovesItem{" + 
			"version_group_details = '" + versionGroupDetails + '\'' + 
			",move = '" + move + '\'' + 
			"}";
		}
}