package com.api.interbanking.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transferencia {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Float importe;
	private String cuentaDebito;
	private String cuentaCredito;
	//private Long idEmpresa;
	@ManyToOne
	@NotNull
	private Empresa empresa;
	@NotNull
	private LocalDate fecha;

}
