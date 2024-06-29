package com.home.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UbicacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idUbicacion;
	private String nombre_ubicacion;
	
	
	@OneToMany(mappedBy = "ubicacionEntity")
	@JsonIgnore
	private List<ProductoEntity> productoEntities;


	public int getIdUbicacion() {
		return idUbicacion;
	}


	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}


	public String getNombre_ubicacion() {
		return nombre_ubicacion;
	}


	public void setNombre_ubicacion(String nombre_ubicacion) {
		this.nombre_ubicacion = nombre_ubicacion;
	}


	public List<ProductoEntity> getProductoEntities() {
		return productoEntities;
	}


	public void setProductoEntities(List<ProductoEntity> productoEntities) {
		this.productoEntities = productoEntities;
	}


	public UbicacionEntity(int idUbicacion, String nombre_ubicacion, List<ProductoEntity> productoEntities) {
		this.idUbicacion = idUbicacion;
		this.nombre_ubicacion = nombre_ubicacion;
		this.productoEntities = productoEntities;
	}


	public UbicacionEntity() {
	}
	
	
	
}
