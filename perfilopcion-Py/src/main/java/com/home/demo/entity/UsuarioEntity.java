package com.home.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombreUsuario;
	private String contraseña;
	
	@ManyToOne
	@JoinColumn(name = "idPerfil")
	private PerfilEntity perfilEntity;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}

	public UsuarioEntity(int idUsuario, String nombreUsuario, String contraseña, PerfilEntity perfilEntity) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.perfilEntity = perfilEntity;
	}

	public UsuarioEntity() {
	}
	
	
}
