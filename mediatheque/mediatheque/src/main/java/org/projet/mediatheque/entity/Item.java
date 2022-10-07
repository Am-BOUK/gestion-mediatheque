package org.projet.mediatheque.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED) // creer Une table par classe
@DiscriminatorColumn(name="item_type")
public abstract class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String titre;
	private Long nombreExemplaire;
	private Date dateParution;

}