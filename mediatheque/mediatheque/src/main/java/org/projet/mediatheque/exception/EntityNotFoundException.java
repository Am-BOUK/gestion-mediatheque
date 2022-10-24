package org.projet.mediatheque.exception;

import lombok.Data;

@Data
public class EntityNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public EntityNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
