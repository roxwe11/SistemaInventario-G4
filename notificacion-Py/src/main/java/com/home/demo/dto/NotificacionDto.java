package com.home.demo.dto;

public class NotificacionDto {
    private int idNotificacion;
    private String mensaje;
    private String fecha_notificacion;
    private String tipo_notificacion;

    // Constructor sin parámetros
    public NotificacionDto() {
    }

    // Constructor con parámetros
    public NotificacionDto(int idNotificacion, String mensaje, String fecha_notificacion, String tipo_notificacion) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.fecha_notificacion = fecha_notificacion;
        this.tipo_notificacion = tipo_notificacion;
    }

    // Getters y setters

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha_notificacion() {
        return fecha_notificacion;
    }

    public void setFecha_notificacion(String fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    public String getTipo_notificacion() {
        return tipo_notificacion;
    }

    public void setTipo_notificacion(String tipo_notificacion) {
        this.tipo_notificacion = tipo_notificacion;
    }

}
