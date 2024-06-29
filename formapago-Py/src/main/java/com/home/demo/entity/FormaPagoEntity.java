package com.home.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormaPagoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormapago;
	private String nombreFormapago;
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
	public FormaPagoEntity(int idFormapago, String nombreFormapago) {
		this.idFormapago = idFormapago;
		this.nombreFormapago = nombreFormapago;
	}
	public FormaPagoEntity() {
	}
	
}
