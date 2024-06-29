package com.home.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class OpcionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOpcion;
	private String nombreOpcion;
	private String descripcion;
	
	@ManyToMany(mappedBy = "opciones")
	private Set<PerfilEntity> perfiles = new HashSet<>();

	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<PerfilEntity> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<PerfilEntity> perfiles) {
		this.perfiles = perfiles;
	}

	public OpcionEntity(int idOpcion, String nombreOpcion, String descripcion, Set<PerfilEntity> perfiles) {
		this.idOpcion = idOpcion;
		this.nombreOpcion = nombreOpcion;
		this.descripcion = descripcion;
		this.perfiles = perfiles;
	}

	public OpcionEntity() {
	}
	
	
}
