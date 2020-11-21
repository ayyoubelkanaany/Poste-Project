package com.example.application.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Reaction {
	
	private String type;
    private Utilisateur reactif;
    private String dateReaction;
	public Reaction() {
		super();
	}
	public Reaction(String type, Utilisateur reactif) {
		super();
		this.type = type;
		this.reactif = reactif;
	}

	
	public String getDateReaction() {
		return dateReaction;
	}
	public void setDateReaction(String dateReaction) {
		this.dateReaction = dateReaction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Utilisateur getReactif() {
		return reactif;
	}
	public void setReactif(Utilisateur reactif) {
		this.reactif = reactif;
	}
    

}
