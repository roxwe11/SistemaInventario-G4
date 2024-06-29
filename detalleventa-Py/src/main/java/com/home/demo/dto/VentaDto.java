package com.home.demo.dto;


public class VentaDto {
    private String fecha_venta;
    private String totalventa;

    // Constructor sin parámetros
    public VentaDto() {
    }

    // Constructor con parámetros
    public VentaDto(String fecha_venta, String totalventa) {
        this.fecha_venta = fecha_venta;
        this.totalventa = totalventa;
    }

    // Getters y setters
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
}

