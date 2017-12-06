package com.cajaflujo.systemafujocaja;

import com.cajaflujo.systemafujocaja.modell.Administrativo;
import com.cajaflujo.systemafujocaja.modell.Cargo;
import com.cajaflujo.systemafujocaja.modell.Producto;
import com.cajaflujo.systemafujocaja.modell.Trabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
@SessionScoped
@ManagedBean
public class FujoCajaController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(FujoCajaController.class.getName());
    private String nombre = "Systema de Flujo";
    private String body = "paginas/default.xhtml";
    private List<Producto> listaProductos;
    private List<Trabajador> listaTrabajadores;
    private List<Cargo> listaCargos;

    public FujoCajaController() {
    }

    @PostConstruct
    public void init() {
        LOGGER.info("GestionControlMedidores -> INIT");
        listaProductos = new ArrayList<>();
        Producto silla1 = new Producto("Silla 1", 5, 10, 10, 10, 15, 5, 20, 25);
        Producto silla2 = new Producto("Silla 2", 8, 12, 14, 12, 18, 7, 25, 30);
        listaProductos.add(silla1);
        listaProductos.add(silla2);
        listaTrabajadores = new ArrayList<>();
        Cargo gerente = new Cargo(1, "Gerente", 5000.00f);
        Cargo jefeOperaciones = new Cargo(1, "Jefe de Operaciones", 500.00f);
        Administrativo administrador = new Administrativo(1, "Jose Carlos", "Caballero", "Pomajambo", gerente);
        listaTrabajadores.add(administrador);
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

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Producto Editado", ((Producto) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Producto) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEditTrabajador(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Trabajador Editado", ((Trabajador) event.getObject()).getNombres() + " " + ((Trabajador) event.getObject()).getApellidoPaterno());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancelTrabajador(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion de Trabajador Cancelada", ((Trabajador) event.getObject()).getNombres() + " " + ((Trabajador) event.getObject()).getApellidoPaterno());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

}
