package org.projet.mediatheque.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED) // creer Une table par classe
public abstract class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String titre;
	private Long nombreExemplaire;
	private Date dateParution;
	private boolean disponible;

	@ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Emprunt> emprunts = new HashSet<>();
}