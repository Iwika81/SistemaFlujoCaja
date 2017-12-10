package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class FlujoCaja implements Serializable {

    private Mes mes;
    private List<Producto> listaProductos;
    private double sueldoBase;

    public FlujoCaja() {
    }

    public FlujoCaja(Mes mes, List<Producto> listaProductos, double sueldoBase) {
        this.mes = mes;
        this.listaProductos = listaProductos;
        this.sueldoBase = sueldoBase;
    }

    public double calcularTotalIngreso() {
        return listaProductos
                .stream()
                .mapToDouble(m -> m.calcularVentaTotal())
                .sum();
    }

    public double calcularCostoTotalMateriales() {
        return listaProductos
                .stream()
                .mapToDouble(m -> m.calcularCostoMateriales())
                .sum();
    }

    public double calcularCostoTotalManoObra() {
        return listaProductos
                .stream()
                .mapToDouble(m -> m.calcularCostoManoObra())
                .sum();
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public enum Mes {
        Enero,
        Febrero,
        Marzo,
        Abril,
        Mayo,
        Junio,
        Julio,
        Agosto,
        Septiembre,
        Obtubre,
        Noviembre,
        Diciembre
    }
}
