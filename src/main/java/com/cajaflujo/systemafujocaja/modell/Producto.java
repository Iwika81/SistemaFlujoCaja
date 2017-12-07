package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Producto implements Serializable {

    private String nombre;
    private double costoPata;//Costo Directo
    private double costoAsiento;//Costo Directo
    private double costoRespaldar;//Costo Directo
    private double costoTabla;//Costo Directo
    private double costoEstructura;//Costo Directo
    private double costoPintura;//Costo Directo
    private double costoPintado;//Costo Directo
    private double costoArmado;//Costo Directo
    private Integer cantidad;
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, double costoPata, double costoAsiento, double costoRespaldar, double costoTabla, double costoEstructura, double costoPintura, double costoPintado, double costoArmado) {
        this.nombre = nombre;
        this.costoPata = costoPata;
        this.costoAsiento = costoAsiento;
        this.costoRespaldar = costoRespaldar;
        this.costoTabla = costoTabla;
        this.costoEstructura = costoEstructura;
        this.costoPintura = costoPintura;
        this.costoPintado = costoPintado;
        this.costoArmado = costoArmado;
        this.cantidad = 0;
        this.precio = 0f;
    }

    public double calcularCostoMateriales() {
        return (costoPata + costoAsiento + costoRespaldar + costoTabla + costoEstructura + costoPintura) * cantidad;
    }

    public double calcularCostoManoObra() {
        return (costoPintado + costoArmado) * cantidad;
    }

    public double calcularVentaTotal() {
        return cantidad * precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoPata() {
        return costoPata;
    }

    public void setCostoPata(double costoPata) {
        this.costoPata = costoPata;
    }

    public double getCostoAsiento() {
        return costoAsiento;
    }

    public void setCostoAsiento(double costoAsiento) {
        this.costoAsiento = costoAsiento;
    }

    public double getCostoRespaldar() {
        return costoRespaldar;
    }

    public void setCostoRespaldar(double costoRespaldar) {
        this.costoRespaldar = costoRespaldar;
    }

    public double getCostoTabla() {
        return costoTabla;
    }

    public void setCostoTabla(double costoTabla) {
        this.costoTabla = costoTabla;
    }

    public double getCostoEstructura() {
        return costoEstructura;
    }

    public void setCostoEstructura(double costoEstructura) {
        this.costoEstructura = costoEstructura;
    }

    public double getCostoPintura() {
        return costoPintura;
    }

    public void setCostoPintura(double costoPintura) {
        this.costoPintura = costoPintura;
    }

    public double getCostoPintado() {
        return costoPintado;
    }

    public void setCostoPintado(double costoPintado) {
        this.costoPintado = costoPintado;
    }

    public double getCostoArmado() {
        return costoArmado;
    }

    public void setCostoArmado(double costoArmado) {
        this.costoArmado = costoArmado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
