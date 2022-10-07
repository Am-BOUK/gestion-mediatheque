package org.projet.mediatheque.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "dvd")
@DiscriminatorValue("DVD")
public class Dvd extends Item{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String realisateur;
	private Long duree; 
	private Type type;
}
