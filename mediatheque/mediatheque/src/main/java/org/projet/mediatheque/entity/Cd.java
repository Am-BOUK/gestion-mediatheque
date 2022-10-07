package org.projet.mediatheque.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "cd")
public class Cd extends Item {

	private String artisteGroup;
	private Long duree;
	private Long nombreTitre;
}
