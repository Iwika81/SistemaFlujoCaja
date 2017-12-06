package com.cajaflujo.systemafujocaja.modell;

import java.io.Serializable;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public class Administrativo extends Trabajador implements Serializable {

    public Administrativo(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, Cargo cargo) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, cargo);
    }

}
