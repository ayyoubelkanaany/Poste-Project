package com.example.application.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Node
public class Reaction implements Serializable{
	@Id
	private Long id;
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
