package com.home.demo.dto;

import com.home.demo.entity.PerfilEntity;

public class OpcionDto {

	private String nombre_opcion;
	private String descripcion;
	
	private PerfilEntity perfilEntity;

	public String getNombre_opcion() {
		return nombre_opcion;
	}

	public void setNombre_opcion(String nombre_opcion) {
		this.nombre_opcion = nombre_opcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}

	public OpcionDto() {
	}

	public OpcionDto(String nombre_opcion, String descripcion, PerfilEntity perfilEntity) {
		this.nombre_opcion = nombre_opcion;
		this.descripcion = descripcion;
		this.perfilEntity = perfilEntity;
	}
	
	
}
