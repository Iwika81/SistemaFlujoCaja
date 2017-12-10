package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Operativo extends Trabajador implements Serializable {

    public Operativo() {
        super();
    }

    public Operativo(Integer id) {
        super(id);
    }

    public Operativo(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, Cargo cargo) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, cargo);
    }

}
