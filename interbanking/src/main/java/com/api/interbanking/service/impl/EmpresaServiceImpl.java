package com.api.interbanking.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.interbanking.dao.EmpresaRepository;
import com.api.interbanking.exception.EmpresaCreateException;
import com.api.interbanking.model.Empresa;
import com.api.interbanking.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Empresa crear(Empresa empresa) {
		Empresa newEmpresa = new Empresa();
		empresa.setFechaAdhesion(LocalDate.now());
		try {
			newEmpresa = empresaRepository.save(empresa);
			logger.info("empresa with id " + newEmpresa.getId() + "created");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Data integrity violation for customer");
		} catch (DataAccessException e) {
			throw new EmpresaCreateException("Data Access Exception", empresa.getId());
		} catch (Exception e) {
			throw new EmpresaCreateException("Empresa was not created with id ", empresa.getId());
		}
		return newEmpresa;
	}

	@Override
	public List<Empresa> empresasConTransferenciasUltimoMes() {
		LocalDate lastMonth = LocalDate.now().minusMonths(1);
		List<Empresa> result = new ArrayList<Empresa>();
		try {
			result = empresaRepository.empresasConTransferenciasUltimoMes(lastMonth);
			logger.info("empresasConTransferenciasUltimoMes");
		} catch (DataAccessException e) {
			throw new EmpresaCreateException("Data Access Exception");
		} catch (Exception e) {
			throw new EmpresaCreateException("Empresa was not created with id ");
		}
		return result;
	}

	@Override
	public List<Empresa> empresasAdheridasUltimoMes() {
		LocalDate lastMonth = LocalDate.now().minusMonths(1);
		List<Empresa> result = new ArrayList<Empresa>();

		try {
			result = empresaRepository.findByFechaAdhesionAfter(lastMonth);
			logger.info("empresasAdheridasUltimoMes");
		} catch (DataAccessException e) {
			throw new EmpresaCreateException("Data Access Exception");
		} catch (Exception e) {
			throw new EmpresaCreateException("Empresa was not created with id ");
		}
		return result;
	}
}
