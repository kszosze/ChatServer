package com.chatapp.exception;

public class SecurityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5067617106416548466L;

	public SecurityException() {
	}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
