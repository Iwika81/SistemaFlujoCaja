package com.cajaflujo.systemafujocaja.facade;

import com.cajaflujo.systemafujocaja.modell.Cargo;
import com.cajaflujo.systemafujocaja.modell.Producto;
import com.cajaflujo.systemafujocaja.modell.Trabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
@ApplicationScoped
public class DefaultFlujoCajaFacade implements FlujoCajaFacade, Serializable {

    @Override
    public List<Cargo> cargosAdministrativos() {
        List<Cargo> listaCargos = new ArrayList<>();
        listaCargos.add(new Cargo(1, "Gerente", Cargo.Tipo.Administrativo, 5000.00f));
        return listaCargos;
    }

    @Override
    public List<Cargo> cargosOperativos() {
        List<Cargo> listaCargos = new ArrayList<>();
        listaCargos.add(new Cargo(3, "Jefe de Operaciones", Cargo.Tipo.Operativo, 5000.00f));
        return listaCargos;
    }

    @Override
    public List<Trabajador> listaTrabajadores() {
        List<Trabajador> listaTrabajadores = new ArrayList<>();
        listaTrabajadores.add(new Trabajador(1, "Jose Carlos", "Caballero", "Pomajambo",
                new Cargo(1, "Gerente", Cargo.Tipo.Administrativo, 5000.00f)
        ));
        return listaTrabajadores;
    }

    @Override
    public List<Producto> listaProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Silla 1", 5, 10, 10, 10, 15, 5, 20, 25));
        listaProductos.add(new Producto("Silla 2", 8, 12, 14, 12, 18, 7, 25, 30));
        return listaProductos;
    }

}
