package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.usp.modelo.Restaurante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class AgregarRestauranteControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;
			
	@EJB 
	private RestauranteFacade ejbRestauranteFacade;
	
	private String nombre = "";
    private String direccion = "";
    private String telefono = "";
    private int aforo = 0;
    
    public String agregarRestaurante() {
    	Restaurante comprobarRestaurante = null;
    	try {
    		comprobarRestaurante = ejbRestauranteFacade.buscarRestaurante(nombre);
    		
    		if(comprobarRestaurante == null) {
    			Restaurante restaurante = new Restaurante(0, nombre, direccion, telefono, aforo);
    			ejbRestauranteFacade.create(restaurante);
    			
    			return "Restaurante Credo";
    		} else {
    			return "Ya existe el restaurante";
    		}
    	} catch (Exception e) {
    		return "Error: Crear Restaurante " + e;
    	}
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
    
}
