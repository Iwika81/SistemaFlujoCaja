package com.cajaflujo.systemafujocaja;

import com.cajaflujo.systemafujocaja.modell.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
@SessionScoped
@ManagedBean
public class FujoCajaContoroller implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(FujoCajaContoroller.class.getName());
    private String nombre = "Systema de Flujo";
    private String body = "paginas/default.xhtml";
    private List<Producto> listaProductos;

    public FujoCajaContoroller() {
    }

    @PostConstruct
    public void init() {
        LOGGER.info("GestionControlMedidores -> INIT");
        listaProductos = new ArrayList<>();
        Producto silla1 = new Producto("Silla 1", 5, 10, 10, 10, 15, 5, 20, 25);
        Producto silla2 = new Producto("Silla 2", 8, 12, 14, 12, 18, 7, 25, 30);
        listaProductos.add(silla1);
        listaProductos.add(silla2);

    }

    public void openCostoMaterial() {
        body = "paginas/costosMateriales.xhtml";
    }

    public void openCostoPersonal() {
        body = "paginas/costoPersonal.xhtml";
    }

    public void openGenerarFLujo() {
        body = "paginas/flujoCaja.xhtml";
    }
    ////GETTER AND SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
