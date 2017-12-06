package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Cargo implements Serializable {

    private Integer id;
    private String nombre;
    private float sueldo;

    public Cargo() {
    }

    public Cargo(Integer id, String nombre, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

}
