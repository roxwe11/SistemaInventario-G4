package com.home.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombreProducto;
	private String precioCompra;
	private String precioVenta;
	private String stock;
	private String fecha_vencimiento;
	
	@ManyToOne
	@JoinColumn(name = "idUbicacion")
	private UbicacionEntity ubicacionEntity;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public UbicacionEntity getUbicacionEntity() {
		return ubicacionEntity;
	}

	public void setUbicacionEntity(UbicacionEntity ubicacionEntity) {
		this.ubicacionEntity = ubicacionEntity;
	}

	public ProductoEntity(int idProducto, String nombreProducto, String precioCompra, String precioVenta, String stock,
			String fecha_vencimiento, UbicacionEntity ubicacionEntity) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.fecha_vencimiento = fecha_vencimiento;
		this.ubicacionEntity = ubicacionEntity;
	}

	public ProductoEntity() {
	}
	
	
	
}
