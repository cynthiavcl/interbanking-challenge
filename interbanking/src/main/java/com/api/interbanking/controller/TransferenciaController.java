package com.api.interbanking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.interbanking.dto.TransferenciaDTO;
import com.api.interbanking.exception.TransferenciaCreateException;
import com.api.interbanking.model.Transferencia;
import com.api.interbanking.service.TransferenciaService;
import com.api.interbanking.utils.Utils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author vocal
 *
 */

@RestController
@RequestMapping(path = "/transferencias")
@Tag(name = "Transferencia Controller")
public class TransferenciaController {
	
	final Logger logger = LoggerFactory.getLogger(TransferenciaController.class);
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	
	@Operation(summary = "test")
	@GetMapping(path = "/test")
	public String test() {
		return "Welcome";
	}

	@Operation(summary = "Crear Transferencia")
	@PostMapping(path = "/crear", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transferencia> crear(@RequestBody TransferenciaDTO transferenciaDTO) {
		logger.info("Crea Transferencia");
		Transferencia transferencia = transferenciaService.crear(Utils.convertToEntity(transferenciaDTO));
		if (transferencia == null) {
			throw new TransferenciaCreateException("Transferencia not created");
		}
		logger.info("Transferencia created:" + "id" + transferencia.getId());
		return new ResponseEntity<Transferencia>(transferencia, HttpStatus.CREATED);
	}

}
