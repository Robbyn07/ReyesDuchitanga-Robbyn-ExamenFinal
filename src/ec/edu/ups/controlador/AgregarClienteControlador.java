package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.usp.modelo.Cliente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class AgregarClienteControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	private String nombreCompleto = "";
	private String cedula = "";
    private String direccion = "";
    private String telefono = "";
    private String correo = "";
    
    public String agregarCliente() {
    	Cliente clienteComprobar = null;
    	try {
    		clienteComprobar = ejbClienteFacade.buscarCliente(cedula);
    		
    		if(clienteComprobar == null) {
    			Cliente cliente = new Cliente(0, nombreCompleto, cedula, direccion, telefono, correo);
    			ejbClienteFacade.create(cliente);
    			
    			return "Cliente Creado";
    		}else {
    			return "Ya existe el cliente";
    		}
		} catch (Exception e) {
			return "Error: Crear Cliente " + e;
		}
    }

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
