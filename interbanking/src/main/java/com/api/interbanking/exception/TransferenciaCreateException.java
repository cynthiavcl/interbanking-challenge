package com.api.interbanking.exception;




public class TransferenciaCreateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5114155324723110198L;
	/**
	 * 
	 */
	private Long value;

	public TransferenciaCreateException(String message,Long value) {
        super(message);
        this.value = value;
    }
	
	public TransferenciaCreateException(String message) {
        super(message);
    }

}
