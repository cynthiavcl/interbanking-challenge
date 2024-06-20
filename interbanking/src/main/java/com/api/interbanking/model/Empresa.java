package com.api.interbanking.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empresa {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cuit;
	private String razonSocial;
	private LocalDate  fechaAdhesion;
}
