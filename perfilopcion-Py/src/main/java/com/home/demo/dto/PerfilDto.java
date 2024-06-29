package com.home.demo.dto;

public class PerfilDto {
    private int idPerfil;
    private String nombrePerfil;
    private String descripcion;

    // Constructor sin parámetros
    public PerfilDto() {
    }

    // Constructor con parámetros
    public PerfilDto(int idPerfil, String nombrePerfil, String descripcion) {
        this.idPerfil = idPerfil;
        this.nombrePerfil = nombrePerfil;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
