package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Producto implements Serializable {

    private String nombre;
    private float costoPata;//Costo Directo
    private float costoAsiento;//Costo Directo
    private float costoRespaldar;//Costo Directo
    private float costoTabla;//Costo Directo
    private float costoEstructura;//Costo Directo
    private float costoPintura;//Costo Directo
    private float costoPintado;//Costo Directo
    private float costoArmado;//Costo Directo

    public Producto() {
    }

    public Producto(String nombre, float costoPata, float costoAsiento, float costoRespaldar, float costoTabla, float costoEstructura, float costoPintura, float costoPintado, float costoArmado) {
        this.nombre = nombre;
        this.costoPata = costoPata;
        this.costoAsiento = costoAsiento;
        this.costoRespaldar = costoRespaldar;
        this.costoTabla = costoTabla;
        this.costoEstructura = costoEstructura;
        this.costoPintura = costoPintura;
        this.costoPintado = costoPintado;
        this.costoArmado = costoArmado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCostoPata() {
        return costoPata;
    }

    public void setCostoPata(float costoPata) {
        this.costoPata = costoPata;
    }

    public float getCostoAsiento() {
        return costoAsiento;
    }

    public void setCostoAsiento(float costoAsiento) {
        this.costoAsiento = costoAsiento;
    }

    public float getCostoRespaldar() {
        return costoRespaldar;
    }

    public void setCostoRespaldar(float costoRespaldar) {
        this.costoRespaldar = costoRespaldar;
    }

    public float getCostoTabla() {
        return costoTabla;
    }

    public void setCostoTabla(float costoTabla) {
        this.costoTabla = costoTabla;
    }

    public float getCostoEstructura() {
        return costoEstructura;
    }

    public void setCostoEstructura(float costoEstructura) {
        this.costoEstructura = costoEstructura;
    }

    public float getCostoPintura() {
        return costoPintura;
    }

    public void setCostoPintura(float costoPintura) {
        this.costoPintura = costoPintura;
    }

    public float getCostoPintado() {
        return costoPintado;
    }

    public void setCostoPintado(float costoPintado) {
        this.costoPintado = costoPintado;
    }

    public float getCostoArmado() {
        return costoArmado;
    }

    public void setCostoArmado(float costoArmado) {
        this.costoArmado = costoArmado;
    }

}
