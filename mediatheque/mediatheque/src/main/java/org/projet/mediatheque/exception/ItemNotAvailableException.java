package org.projet.mediatheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
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
