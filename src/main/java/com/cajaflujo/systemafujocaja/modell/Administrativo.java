package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Administrativo extends Trabajador implements Serializable {

    private double bonoAnual;

    public Administrativo(Integer id) {
        super(id);
        this.bonoAnual = 0d;
    }

    public Administrativo(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, Cargo cargo) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, cargo);
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }

}
