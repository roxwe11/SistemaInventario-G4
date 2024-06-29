package com.home.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class PerfilEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	private String nombrePerfil;
	private String descripcion;
	
	@OneToMany(mappedBy = "perfilEntity")
	@JsonIgnore
	private List<UsuarioEntity> usuarioEntities;
	
	@ManyToMany
	@JoinTable(
	        name = "perfil_opcion",
	        joinColumns = @JoinColumn(name = "perfil_id_perfil"),
	        inverseJoinColumns = @JoinColumn(name = "opcion_id_opcion")
	    )
	private Set<OpcionEntity> opciones = new HashSet<>();

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<UsuarioEntity> getUsuarioEntities() {
		return usuarioEntities;
	}

	public void setUsuarioEntities(List<UsuarioEntity> usuarioEntities) {
		this.usuarioEntities = usuarioEntities;
	}

	public Set<OpcionEntity> getOpciones() {
		return opciones;
	}

	public void setOpciones(Set<OpcionEntity> opciones) {
		this.opciones = opciones;
	}

	public PerfilEntity(int idPerfil, String nombrePerfil, String descripcion, List<UsuarioEntity> usuarioEntities,
			Set<OpcionEntity> opciones) {
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
		this.descripcion = descripcion;
		this.usuarioEntities = usuarioEntities;
		this.opciones = opciones;
	}

	public PerfilEntity() {
	}

	
	
	
}
