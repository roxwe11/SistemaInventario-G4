package com.home.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombreUsuario;
	private String contraseña;
	
	@OneToMany(mappedBy = "usuarioEntity")
	@JsonIgnore
	private List<ComprobantePagoEntity> comprobantePagoEntities;

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

	public List<ComprobantePagoEntity> getComprobantePagoEntities() {
		return comprobantePagoEntities;
	}

	public void setComprobantePagoEntities(List<ComprobantePagoEntity> comprobantePagoEntities) {
		this.comprobantePagoEntities = comprobantePagoEntities;
	}

	public UsuarioEntity(int idUsuario, String nombreUsuario, String contraseña,
			List<ComprobantePagoEntity> comprobantePagoEntities) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.comprobantePagoEntities = comprobantePagoEntities;
	}

	public UsuarioEntity() {
	}
	
	
}
