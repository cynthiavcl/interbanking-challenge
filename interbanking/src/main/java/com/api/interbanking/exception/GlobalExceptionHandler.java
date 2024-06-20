package com.api.interbanking.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataAccessException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data access error: " + e.getMessage());
    } 

	@ExceptionHandler(EmpresaCreateException.class)
	public ResponseEntity<String> handleCustomerCreateException(EmpresaCreateException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empresa not created: " + e.getMessage());
	}
	
	@ExceptionHandler(TransferenciaCreateException.class)
	public ResponseEntity<String> handleCustomerCreateException(TransferenciaCreateException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transferencia not created: " + e.getMessage());
	}
	
	
	
}
