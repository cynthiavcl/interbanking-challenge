package com.api.interbanking.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {
	
	private Long id;
	private String cuit;
	private String razonSocial;
	private LocalDate  fechaAdhesion;

}
