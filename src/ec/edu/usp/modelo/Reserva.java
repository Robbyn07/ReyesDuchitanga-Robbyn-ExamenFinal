package ec.edu.usp.modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numeroDePersonas;
	private GregorianCalendar fecha;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn
	private Restaurante restaurante;

	public Reserva(int id, int numeroDePersonas, GregorianCalendar fecha, Cliente cliente, Restaurante restaurante) {
		this.setId(id);
		this.setNumeroDePersonas(numeroDePersonas);
		this.setFecha(fecha);
		this.setCliente(cliente);
		this.setRestaurante(restaurante);
	}

	public Reserva() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroDePersonas() {
		return numeroDePersonas;
	}

	public void setNumeroDePersonas(int numeroDePersonas) {
		this.numeroDePersonas = numeroDePersonas;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
   
}
