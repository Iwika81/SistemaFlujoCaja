package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class FlujoCaja implements Serializable {

    private Mes mes;
    private List<Producto> listaProductos;
    private double sueldoBase;
    private double cts;
    private double grati;

    public FlujoCaja() {
        listaProductos = new ArrayList<>();
    }

    public FlujoCaja(Mes mes, List<Producto> listaProductos, double sueldoBase) {
        this.mes = mes;
        this.listaProductos = listaProductos;
        this.sueldoBase = sueldoBase;
        this.cts = mes.equals(Mes.Mayo) || mes.equals(Mes.Noviembre) ? sueldoBase * 0.5 : 0d;
        this.grati = mes.equals(Mes.Julio) || mes.equals(Mes.Diciembre) ? sueldoBase : 0d;
        calcularCosteo();
    }

    public double calcularTotalIngreso() {
        return listaProductos
                .stream()
                .mapToDouble(m -> m.calcularVentaTotal())
                .sum();
    }

    public double calcularTotalEgreso() {
        return calcularCostoTotalMateriales() + calcularCostoTotalManoObra() + calcularCostoTotalSueldos();
    }

    public double calcularTotalFlujo() {
        return calcularTotalIngreso() - calcularTotalEgreso();
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

    public double calcularCanditadTotalProductos() {
        return listaProductos
                .stream()
                .mapToDouble(m -> m.getCantidad())
                .sum();
    }

    public double calcularCostoTotalSueldos() {
        return sueldoBase + cts + grati + calcularEssalud();
    }

    public double calcularEssalud() {
        return (sueldoBase + cts) * 0.09;
    }

    private void calcularCosteo() {
        listaProductos.stream().forEach((pr) -> {
            pr.setCosteo(pr.getCantidad() * calcularCostoTotalSueldos() / calcularCanditadTotalProductos());
        });
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

    public double getCts() {
        return cts;
    }

    public void setCts(double cts) {
        this.cts = cts;
    }

    public double getGrati() {
        return grati;
    }

    public void setGrati(double grati) {
        this.grati = grati;
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
