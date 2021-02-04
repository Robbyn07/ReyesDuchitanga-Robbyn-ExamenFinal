package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.usp.modelo.Cliente;
import ec.edu.usp.modelo.Reserva;
import ec.edu.usp.modelo.Restaurante;

@Named
@RequestScoped
public class HacerReservaControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteFacade ejbClienteFacade;
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	@EJB
	private ReservaFacade ejbReservaFacade;
	
	private String cedula = "";
	private String nombreCompleto = "";
	private String visibilidadR = "display: none";
	private String visibilidadT = "display: none";
	private String nombre = "";
	private String direccion = "";
	private String telefono = "";
	private int aforo = 0;
	private int personasReservan = 0;
	
	Cliente comprobarCliente = null;
	
	public void buscarCliente() {
		
		comprobarCliente = ejbClienteFacade.buscarCliente(cedula);
		
		if (comprobarCliente != null) {
			this.setNombreCompleto(comprobarCliente.getNombreCompleto());
			this.setCedula(comprobarCliente.getCedula());
			this.setVisibilidadR("display: inline");
		} 
	}
	
	Restaurante comprobarRestaurante = null;
	
	public void buscarRestaurante() {
		
		comprobarRestaurante = ejbRestauranteFacade.buscarRestaurante(nombre);
		
		if (comprobarRestaurante != null) {
			this.setNombre(comprobarRestaurante.getNombre());
			this.setDireccion(comprobarRestaurante.getDireccion());
			this.setTelefono(comprobarRestaurante.getTelefono());
			this.setAforo(comprobarRestaurante.getAforo());
			this.setVisibilidadT("display: inline");
		} else {
			System.out.println("Error al buscar");
		}
	}

	public void hacerReservacion() {
		this.setPersonasReservan(personasReservan);
		
		Reserva reserva = new Reserva(0 , this.getPersonasReservan(), new GregorianCalendar(), comprobarCliente, comprobarRestaurante);
		ejbReservaFacade.create(reserva);
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public String getVisibilidadR() {
		return visibilidadR;
	}

	public void setVisibilidadR(String visibilidadR) {
		this.visibilidadR = visibilidadR;
	}

	public String getVisibilidadT() {
		return visibilidadT;
	}

	public void setVisibilidadT(String visibilidadT) {
		this.visibilidadT = visibilidadT;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public int getPersonasReservan() {
		return personasReservan;
	}

	public void setPersonasReservan(int personasReservan) {
		this.personasReservan = personasReservan;
	}
	
}
