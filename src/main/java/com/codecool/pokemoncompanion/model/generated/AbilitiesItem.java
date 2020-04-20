package com.codecool.pokemoncompanion.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AbilitiesItem{

	@JsonProperty("is_hidden")
	private boolean isHidden;

	@JsonProperty("ability")
	private Ability ability;

	@JsonProperty("slot")
	private int slot;

	public void setIsHidden(boolean isHidden){
		this.isHidden = isHidden;
	}

	public boolean isIsHidden(){
		return isHidden;
	}

	public void setAbility(Ability ability){
		this.ability = ability;
	}

	public Ability getAbility(){
		return ability;
	}

	public void setSlot(int slot){
		this.slot = slot;
	}

	public int getSlot(){
		return slot;
	}

	@Override
 	public String toString(){
		return 
			"AbilitiesItem{" + 
			"is_hidden = '" + isHidden + '\'' + 
			",ability = '" + ability + '\'' + 
			",slot = '" + slot + '\'' + 
			"}";
		}
}