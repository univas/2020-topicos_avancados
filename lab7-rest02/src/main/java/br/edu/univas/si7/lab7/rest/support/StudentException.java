package br.edu.univas.si7.lab7.rest.support;

public class StudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentException() {
	}

	public StudentException(String message) {
		super(message);
	}

	public StudentException(Throwable cause) {
		super(cause);
	}

	public StudentException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
