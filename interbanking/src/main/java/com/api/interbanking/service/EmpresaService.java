package com.api.interbanking.service;

import java.util.List;

import com.api.interbanking.model.Empresa;

public interface EmpresaService {
	
	List<Empresa> empresasConTransferenciasUltimoMes();
	
	List<Empresa> empresasAdheridasUltimoMes();
	
	Empresa crear(Empresa empresa);
	
}
