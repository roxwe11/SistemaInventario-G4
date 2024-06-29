package com.home.demo.dto;

public class FormaPagoDto {
    private int idFormapago;
    private String nombreFormapago;

    // Constructor sin parámetros
    public FormaPagoDto() {
    }

    // Constructor con parámetros
    public FormaPagoDto(int idFormapago, String nombreFormapago) {
        this.idFormapago = idFormapago;
        this.nombreFormapago = nombreFormapago;
    }

    // Getters y setters

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
}
