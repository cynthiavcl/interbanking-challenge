package com.api.interbanking.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDTO {
	
	private Long id;
	private Float importe;
	private String cuentaDebito;
	private String cuentaCredito;
	private Long idEmpresa;
	private LocalDate fecha;

}
