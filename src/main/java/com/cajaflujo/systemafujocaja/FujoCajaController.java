package com.cajaflujo.systemafujocaja;

import com.cajaflujo.systemafujocaja.facade.DefaultFlujoCajaFacade;
import com.cajaflujo.systemafujocaja.facade.FlujoCajaFacade;
import com.cajaflujo.systemafujocaja.modell.Cargo;
import com.cajaflujo.systemafujocaja.modell.FlujoCaja;
import com.cajaflujo.systemafujocaja.modell.FlujoCaja.Mes;
import com.cajaflujo.systemafujocaja.modell.Producto;
import com.cajaflujo.systemafujocaja.modell.Trabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Ivan Caballero <ivan.caballer at gmail.com>
 */
@SessionScoped
@ManagedBean
public class FujoCajaController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(FujoCajaController.class.getName());

    private static final String OPEN_MODAL_NUEVO_PRODUCTO
            = "PF('widgetvar-nuevoProducto').show();";
    private static final String CLOSE_MODAL_NUEVO_PRODUCTO
            = "PF('widgetvar-nuevoProducto').hide();";
    private static final String OPEN_MODAL_GENERAR_FLUJOCAJA
            = "PF('widgetvar-generarFlujoCaja').show();";
    private static final String CLOSE_MODAL_GENERAR_FLUJOCAJA
            = "PF('widgetvar-generarFlujoCaja').hide();";

    @ManagedProperty("#{flujoCajaFacade}")
    private FlujoCajaFacade flujoCajaFacade;

    private String nombre = "Systema de Flujo";
    private String body = "paginas/default.xhtml";
    private List<Producto> listaProductos;
    private List<Trabajador> listaTrabajadores;
    private List<Cargo> listaCargos;
    private FlujoCaja[] fujoCajas;
    private Producto nuevoProducto;

    @PostConstruct
    public void init() {
        LOGGER.info("GestionControlMedidores -> INIT");
        flujoCajaFacade = new DefaultFlujoCajaFacade();
        listaProductos = flujoCajaFacade.listaProductos();
        listaTrabajadores = flujoCajaFacade.listaTrabajadores();
        fujoCajas = new FlujoCaja[12];
    }

    public void openCostoMaterial() {
        body = "paginas/costosMateriales.xhtml";
    }

    public void openCostoPersonal() {
        body = "paginas/costoPersonal.xhtml";
    }

    public void openGenerarFLujo() {
        RequestContext
                .getCurrentInstance()
                .execute(OPEN_MODAL_GENERAR_FLUJOCAJA);

    }

    public void closeGenerarFlujo() {
        RequestContext
                .getCurrentInstance()
                .execute(CLOSE_MODAL_GENERAR_FLUJOCAJA);
    }

    public void generarFlujo() {
        closeGenerarFlujo();
        double sueldoTotal = listaTrabajadores.stream()
                .mapToDouble(m -> m.getCargo().getSueldo())
                .sum();

        FlujoCaja flujoEnero = new FlujoCaja(Mes.Enero, listaProductos, sueldoTotal);
        fujoCajas[0] = flujoEnero;
        FlujoCaja flujoFebrero = new FlujoCaja(Mes.Febrero, listaProductos, sueldoTotal);
        fujoCajas[1] = flujoFebrero;
        FlujoCaja flujoMarzo = new FlujoCaja(Mes.Marzo, listaProductos, sueldoTotal);
        fujoCajas[2] = flujoMarzo;
        FlujoCaja flujoAbril = new FlujoCaja(Mes.Abril, listaProductos, sueldoTotal);
        fujoCajas[3] = flujoAbril;
        FlujoCaja flujoMayo = new FlujoCaja(Mes.Mayo, listaProductos, sueldoTotal);
        fujoCajas[4] = flujoMayo;
        FlujoCaja flujoJunio = new FlujoCaja(Mes.Junio, listaProductos, sueldoTotal);
        fujoCajas[5] = flujoJunio;
        FlujoCaja flujoJulio = new FlujoCaja(Mes.Julio, listaProductos, sueldoTotal);
        fujoCajas[6] = flujoJulio;
        FlujoCaja flujoAgosto = new FlujoCaja(Mes.Agosto, listaProductos, sueldoTotal);
        fujoCajas[7] = flujoAgosto;
        FlujoCaja flujoSeptiembre = new FlujoCaja(Mes.Septiembre, listaProductos, sueldoTotal);
        fujoCajas[8] = flujoSeptiembre;
        FlujoCaja flujoObtubre = new FlujoCaja(Mes.Obtubre, listaProductos, sueldoTotal);
        fujoCajas[9] = flujoObtubre;
        FlujoCaja flujoNoviembre = new FlujoCaja(Mes.Noviembre, listaProductos, sueldoTotal);
        fujoCajas[10] = flujoNoviembre;
        FlujoCaja flujoDiciembre = new FlujoCaja(Mes.Diciembre, listaProductos, sueldoTotal);
        fujoCajas[11] = flujoDiciembre;

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

    public void openNuevoProducto() {
        nuevoProducto = new Producto();
        RequestContext
                .getCurrentInstance()
                .execute(OPEN_MODAL_NUEVO_PRODUCTO);
    }

    public void closeNuevoProducto() {
        RequestContext
                .getCurrentInstance()
                .execute(CLOSE_MODAL_NUEVO_PRODUCTO);
    }

    public void ingresarNuevoProducto() {
        LOGGER.info("TESTT");
        if (!nuevoProducto.getNombre().isEmpty()) {
            listaProductos.add(nuevoProducto);
            closeNuevoProducto();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Campo nombre no puede ser vacio."));
        }
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

    public FlujoCaja[] getFujoCajas() {
        return fujoCajas;
    }

    public void setFujoCajas(FlujoCaja[] fujoCajas) {
        this.fujoCajas = fujoCajas;
    }

    public Producto getNuevoProducto() {
        return nuevoProducto;
    }

    public void setNuevoProducto(Producto nuevoProducto) {
        this.nuevoProducto = nuevoProducto;
    }

    public FlujoCajaFacade getFlujoCajaFacade() {
        return flujoCajaFacade;
    }

    public void setFlujoCajaFacade(FlujoCajaFacade flujoCajaFacade) {
        this.flujoCajaFacade = flujoCajaFacade;
    }

}
