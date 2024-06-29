package com.home.demo.dto;

public class UbicacionDto {
    private int idUbicacion;
    private String nombreUbicacion;

    // Constructor sin parámetros
    public UbicacionDto() {
    }

    // Constructor con parámetros
    public UbicacionDto(int idUbicacion, String nombreUbicacion) {
        this.idUbicacion = idUbicacion;
        this.nombreUbicacion = nombreUbicacion;
    }

    // Getters y setters

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }
}
