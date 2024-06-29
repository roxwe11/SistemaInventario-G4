package com.home.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class NotificacionEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int idNotificacion;
	private String mensaje; 
	private String fecha_notificacion;
	private String tipo_notificacion;
	
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private ProductoEntity productoEntity;


	public int getIdNotificacion() {
		return idNotificacion;
	}


	public void setIdNotificacion(int idNotificacion) {
		this.idNotificacion = idNotificacion;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getFecha_notificacion() {
		return fecha_notificacion;
	}


	public void setFecha_notificacion(String fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}


	public String getTipo_notificacion() {
		return tipo_notificacion;
	}


	public void setTipo_notificacion(String tipo_notificacion) {
		this.tipo_notificacion = tipo_notificacion;
	}


	public ProductoEntity getProductoEntity() {
		return productoEntity;
	}


	public void setProductoEntity(ProductoEntity productoEntity) {
		this.productoEntity = productoEntity;
	}


	public NotificacionEntity(int idNotificacion, String mensaje, String fecha_notificacion, String tipo_notificacion,
			ProductoEntity productoEntity) {
		this.idNotificacion = idNotificacion;
		this.mensaje = mensaje;
		this.fecha_notificacion = fecha_notificacion;
		this.tipo_notificacion = tipo_notificacion;
		this.productoEntity = productoEntity;
	}


	public NotificacionEntity() {
	}
	
	
	
}
