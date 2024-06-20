package com.api.interbanking.utils;

import java.time.LocalDate;

import com.api.interbanking.dto.EmpresaDTO;
import com.api.interbanking.dto.TransferenciaDTO;
import com.api.interbanking.model.Empresa;
import com.api.interbanking.model.Transferencia;

public class Utils {
	public static Transferencia convertToEntity(TransferenciaDTO transferenciaDTO) {
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaCredito(transferenciaDTO.getCuentaCredito());
		transferencia.setCuentaDebito(transferenciaDTO.getCuentaDebito());
		Empresa empresa = new Empresa();
		empresa.setId(transferenciaDTO.getIdEmpresa());
		transferencia.setEmpresa(empresa);
		transferencia.setImporte(transferenciaDTO.getImporte());		
		transferencia.setFecha(LocalDate.now());
		return transferencia;
	}
	
	public static Empresa convertToEntity(EmpresaDTO empresaDTO) {

		Empresa empresa = new Empresa();
		empresa.setCuit(empresaDTO.getCuit());
		empresa.setFechaAdhesion(empresaDTO.getFechaAdhesion());
		empresa.setRazonSocial(empresaDTO.getRazonSocial());	
		return empresa;
	}
}
