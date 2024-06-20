package com.api.interbanking.exception;




public class EmpresaCreateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5114155324723110198L;
	/**
	 * 
	 */
	private Long value;

	public EmpresaCreateException(String message,Long value) {
        super(message);
        this.value = value;
    }
	
	public EmpresaCreateException(String message) {
        super(message);
    }

}
