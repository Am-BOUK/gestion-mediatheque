package org.projet.mediatheque.exception;

import lombok.Data;

@Data
public class ItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}