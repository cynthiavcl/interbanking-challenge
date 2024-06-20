package com.api.interbanking.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.interbanking.model.Empresa;


@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{
	
	List<Empresa> findByFechaAdhesionAfter(LocalDate  lastMonth);
	
    @Query("SELECT DISTINCT e FROM Empresa e JOIN Transferencia t ON e.id = t.empresa.id WHERE t.empresa.fechaAdhesion > :lastMonth")
	List<Empresa> empresasConTransferenciasUltimoMes(LocalDate  lastMonth);
	

}
