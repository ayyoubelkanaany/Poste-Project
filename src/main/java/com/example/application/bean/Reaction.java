package com.example.application.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;


@Node
public class Reaction implements Serializable{
	@Id @GeneratedValue
	private Long idReaction;
	private String type;
	@Relationship(type = "Reagie",direction = Direction.INCOMING)
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
	
	public Long getIdReaction() {
		return idReaction;
	}
	public void setIdReaction(Long idReaction) {
		this.idReaction = idReaction;
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
