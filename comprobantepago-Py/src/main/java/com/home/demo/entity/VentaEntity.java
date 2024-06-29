package com.home.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    private String fecha_venta;
    private String totalventa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comprobante_pago_id", referencedColumnName = "idComprobantePago")
    private ComprobantePagoEntity comprobantePagoEntity;

    // Getters y setters

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

    public ComprobantePagoEntity getComprobantePagoEntity() {
        return comprobantePagoEntity;
    }

    public void setComprobantePagoEntity(ComprobantePagoEntity comprobantePagoEntity) {
        this.comprobantePagoEntity = comprobantePagoEntity;
    }

    public VentaEntity(int idVenta, String fecha_venta, String totalventa,
                       ComprobantePagoEntity comprobantePagoEntity) {
        this.idVenta = idVenta;
        this.fecha_venta = fecha_venta;
        this.totalventa = totalventa;
        this.comprobantePagoEntity = comprobantePagoEntity;
    }

    public VentaEntity() {
    }
}
