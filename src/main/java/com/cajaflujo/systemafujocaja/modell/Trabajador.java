package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Trabajador implements Serializable {

    private Integer id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Cargo cargo;

    public Trabajador() {
        this.cargo = new Cargo();
    }

    public Trabajador(Integer id) {
        this.id = id;
        this.cargo = new Cargo();
    }

    public Trabajador(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, Cargo cargo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
