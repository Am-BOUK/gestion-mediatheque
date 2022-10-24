package org.projet.mediatheque.exception;

import lombok.Data;

@Data
public class ItemNotAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotAvailableException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
