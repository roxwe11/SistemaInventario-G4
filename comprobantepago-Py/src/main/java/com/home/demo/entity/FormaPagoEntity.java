package com.home.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FormaPagoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormapago;
	private String nombreFormapago;
	
	 @OneToMany(mappedBy = "formaPagoEntity")
     @JsonIgnore
     private List<ComprobantePagoEntity> comprobantePagoEntities;

	public int getIdFormapago() {
		return idFormapago;
	}

	public void setIdFormapago(int idFormapago) {
		this.idFormapago = idFormapago;
	}

	public String getNombreFormapago() {
		return nombreFormapago;
	}

	public void setNombreFormapago(String nombreFormapago) {
		this.nombreFormapago = nombreFormapago;
	}

	public List<ComprobantePagoEntity> getComprobantePagoEntities() {
		return comprobantePagoEntities;
	}

	public void setComprobantePagoEntities(List<ComprobantePagoEntity> comprobantePagoEntities) {
		this.comprobantePagoEntities = comprobantePagoEntities;
	}

	public FormaPagoEntity(int idFormapago, String nombreFormapago,
			List<ComprobantePagoEntity> comprobantePagoEntities) {
		this.idFormapago = idFormapago;
		this.nombreFormapago = nombreFormapago;
		this.comprobantePagoEntities = comprobantePagoEntities;
	}

	public FormaPagoEntity() {
	}

	
	
	
}
