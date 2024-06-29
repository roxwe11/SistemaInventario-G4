package com.home.demo.dto;

public class ComprobantePagoDto {
    private int idComprobantePago;
    private String fechaComprobantePago;
    private String nombreComprobante;
    private double opGravada;
    private double igv;

    // Constructor sin parámetros
    public ComprobantePagoDto() {
    }

    // Constructor con parámetros
    public ComprobantePagoDto(int idComprobantePago, String fechaComprobantePago, String nombreComprobante,
                              double opGravada, double igv) {
        this.idComprobantePago = idComprobantePago;
        this.fechaComprobantePago = fechaComprobantePago;
        this.nombreComprobante = nombreComprobante;
        this.opGravada = opGravada;
        this.igv = igv;
    }

    // Getters y setters

    public int getIdComprobantePago() {
        return idComprobantePago;
    }

    public void setIdComprobantePago(int idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    public String getFechaComprobantePago() {
        return fechaComprobantePago;
    }

    public void setFechaComprobantePago(String fechaComprobantePago) {
        this.fechaComprobantePago = fechaComprobantePago;
    }

    public String getNombreComprobante() {
        return nombreComprobante;
    }

    public void setNombreComprobante(String nombreComprobante) {
        this.nombreComprobante = nombreComprobante;
    }

    public double getOpGravada() {
        return opGravada;
    }

    public void setOpGravada(double opGravada) {
        this.opGravada = opGravada;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }
}
