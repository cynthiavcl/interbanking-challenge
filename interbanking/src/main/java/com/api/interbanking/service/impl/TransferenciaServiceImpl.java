package com.api.interbanking.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.interbanking.dao.TransferenciaRepository;
import com.api.interbanking.exception.EmpresaCreateException;
import com.api.interbanking.model.Transferencia;
import com.api.interbanking.service.TransferenciaService;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

	final Logger logger = LoggerFactory.getLogger(TransferenciaServiceImpl.class);

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Override
	public Transferencia crear(Transferencia transferencia) {
		Transferencia newTransferencia = new Transferencia();
		try {
			newTransferencia = transferenciaRepository.save(transferencia);
			logger.info("transferencia created");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Data integrity violation for transferencia");
		} catch (DataAccessException e) {
			throw new EmpresaCreateException("Data Access Exception", transferencia.getId());
		} catch (Exception e) {
			throw new EmpresaCreateException("transferencia was not created with id ", transferencia.getId());
		}
		return newTransferencia;
	}

}
