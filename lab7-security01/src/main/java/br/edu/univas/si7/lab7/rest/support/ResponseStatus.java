package br.edu.univas.si7.lab7.rest.support;

public class ResponseStatus {

	public enum STATUS {OK};
	
	private int status;
	private String message;

	public ResponseStatus() {
	}

	public ResponseStatus(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
