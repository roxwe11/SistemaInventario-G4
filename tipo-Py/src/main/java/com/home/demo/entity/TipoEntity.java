package com.home.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	private String nombreTipo;
	private String detalleTipo;
	
	
	@OneToMany(mappedBy = "tipoEntity")
	@JsonIgnore
	private List<ProductoEntity> productoEntities;


	public int getIdTipo() {
		return idTipo;
	}


	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}


	public String getNombreTipo() {
		return nombreTipo;
	}


	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}


	public String getDetalleTipo() {
		return detalleTipo;
	}


	public void setDetalleTipo(String detalleTipo) {
		this.detalleTipo = detalleTipo;
	}


	public List<ProductoEntity> getProductoEntities() {
		return productoEntities;
	}


	public void setProductoEntities(List<ProductoEntity> productoEntities) {
		this.productoEntities = productoEntities;
	}


	public TipoEntity(int idTipo, String nombreTipo, String detalleTipo, List<ProductoEntity> productoEntities) {
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.detalleTipo = detalleTipo;
		this.productoEntities = productoEntities;
	}


	public TipoEntity() {
	}
	
	
	
	
	
}
