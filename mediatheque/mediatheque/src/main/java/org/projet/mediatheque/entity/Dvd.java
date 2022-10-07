package org.projet.mediatheque.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "dvd")
public class Dvd extends Item{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String realisateur;
	private Long duree; 
	
	@Enumerated(EnumType.STRING)
	private Type type;
}
