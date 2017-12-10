package com.cajaflujo.systemafujocaja.facade;

import com.cajaflujo.systemafujocaja.modell.Cargo;
import com.cajaflujo.systemafujocaja.modell.Producto;
import com.cajaflujo.systemafujocaja.modell.Trabajador;
import java.util.List;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
public interface FlujoCajaFacade {

    public List<Cargo> cargosAdministrativos();

    public List<Cargo> cargosOperativos();

    public List<Trabajador> listaTrabajadores();

    public List<Producto> listaProductos();
}
