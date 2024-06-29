package com.home.demo.dto;

public class UsuarioDto {
    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;

    // Constructor sin parámetros
    public UsuarioDto() {
    }

    // Constructor con parámetros
    public UsuarioDto(int idUsuario, String nombreUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    // Getters y setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
