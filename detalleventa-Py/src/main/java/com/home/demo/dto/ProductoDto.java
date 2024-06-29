package com.home.demo.dto;

public class ProductoDto {
    private String nombreProducto;
    private String precioCompra;
    private String precioVenta;
    private String stock;
    private String fecha_vencimiento;

    // Constructor sin parámetros
    public ProductoDto() {
    }

    // Constructor con parámetros
    public ProductoDto(String nombreProducto, String precioCompra, String precioVenta, String stock, String fecha_vencimiento) {
        this.nombreProducto = nombreProducto;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    // Getters y setters
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
}
