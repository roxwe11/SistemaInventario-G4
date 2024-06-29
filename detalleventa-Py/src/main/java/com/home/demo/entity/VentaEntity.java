package com.home.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class VentaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	private String fecha_venta;
	private String totalventa;
	
	@ManyToMany
    @JoinTable(
        name = "detalle_venta",
        joinColumns = @JoinColumn(name = "venta_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<ProductoEntity> productos;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public String getTotalventa() {
		return totalventa;
	}

	public void setTotalventa(String totalventa) {
		this.totalventa = totalventa;
	}

	public Set<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}

	public VentaEntity(int idVenta, String fecha_venta, String totalventa, Set<ProductoEntity> productos) {
		this.idVenta = idVenta;
		this.fecha_venta = fecha_venta;
		this.totalventa = totalventa;
		this.productos = productos;
	}

	public VentaEntity() {
	}

	 public VentaEntity(String fecha_venta, String totalventa) {
	        this.fecha_venta = fecha_venta;
	        this.totalventa = totalventa;
	    }
	 

}
