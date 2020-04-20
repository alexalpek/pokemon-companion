package com.codecool.pokemoncompanion.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VersionGroupDetailsItem{

	@JsonProperty("level_learned_at")
	private int levelLearnedAt;

	@JsonProperty("version_group")
	private VersionGroup versionGroup;

	@JsonProperty("move_learn_method")
	private MoveLearnMethod moveLearnMethod;

	public void setLevelLearnedAt(int levelLearnedAt){
		this.levelLearnedAt = levelLearnedAt;
	}

	public int getLevelLearnedAt(){
		return levelLearnedAt;
	}

	public void setVersionGroup(VersionGroup versionGroup){
		this.versionGroup = versionGroup;
	}

	public VersionGroup getVersionGroup(){
		return versionGroup;
	}

	public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod){
		this.moveLearnMethod = moveLearnMethod;
	}

	public MoveLearnMethod getMoveLearnMethod(){
		return moveLearnMethod;
	}

	@Override
 	public String toString(){
		return 
			"VersionGroupDetailsItem{" + 
			"level_learned_at = '" + levelLearnedAt + '\'' + 
			",version_group = '" + versionGroup + '\'' + 
			",move_learn_method = '" + moveLearnMethod + '\'' + 
			"}";
		}
}