package com.codecool.pokemoncompanion.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TypesItem{

	@JsonProperty("slot")
	private int slot;

	@JsonProperty("type")
	private Type type;

	public void setSlot(int slot){
		this.slot = slot;
	}

	public int getSlot(){
		return slot;
	}

	public void setType(Type type){
		this.type = type;
	}

	public Type getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"TypesItem{" + 
			"slot = '" + slot + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}