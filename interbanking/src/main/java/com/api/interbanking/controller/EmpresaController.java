package com.api.interbanking.controller;

import java.util.List;

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

import com.api.interbanking.dto.EmpresaDTO;
import com.api.interbanking.exception.TransferenciaCreateException;
import com.api.interbanking.model.Empresa;
import com.api.interbanking.service.EmpresaService;
import com.api.interbanking.utils.Utils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author vocal
 *
 */

@RestController
@RequestMapping(path = "/empresas")
@Tag(name = "Empresa Controller")
public class EmpresaController {
	
	final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@Operation(summary = "test")
	@GetMapping(path = "/test")
	public String test() {
		return "Welcome";
	}

	@Operation(summary = "Crear Empresa")
	@PostMapping(path = "/crear", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> crear(@RequestBody EmpresaDTO empresaDTO) {
		logger.info("Crea Empresa");
		Empresa empresa = empresaService.crear(Utils.convertToEntity(empresaDTO));

		if (empresa == null) {
			throw new TransferenciaCreateException("Empresa not created");
		}
		logger.info("Empresa created:" + "id" + empresa.getId());
		return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "Lista de empresas con transferencia el ultimo mes")
	@GetMapping(path = "/conTransferenciasUltimoMes", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity <List <Empresa> > empresasConTransferenciasUltimoMes() {
		logger.info("conTransferenciasUltimoMes");
		List <Empresa> empresas=empresaService.empresasConTransferenciasUltimoMes();
		return new ResponseEntity<List <Empresa> >(empresas, HttpStatus.OK);
	}
	
	
	@Operation(summary = "Lista de empresas adheridas Ultimo Mes")
	@GetMapping(path = "/adheridasUltimoMes", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity <List <Empresa> > empresasAdheridasUltimoMes() {
		logger.info("adheridasUltimoMes");
		List <Empresa> empresas=empresaService.empresasAdheridasUltimoMes();
		return new ResponseEntity<List <Empresa> >(empresas, HttpStatus.OK);
	}

}
