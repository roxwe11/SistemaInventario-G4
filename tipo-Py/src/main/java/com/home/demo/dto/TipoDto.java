package com.home.demo.dto;

public class TipoDto {
    private int idTipo;
    private String nombreTipo;
    private String detalleTipo;

    // Constructor sin parámetros
    public TipoDto() {
    }

    // Constructor con parámetros
    public TipoDto(int idTipo, String nombreTipo, String detalleTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.detalleTipo = detalleTipo;
    }

    // Getters y setters

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDetalleTipo() {
        return detalleTipo;
    }

    public void setDetalleTipo(String detalleTipo) {
        this.detalleTipo = detalleTipo;
    }
}
