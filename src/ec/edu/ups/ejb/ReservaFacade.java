package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.usp.modelo.Reserva;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva>{

	public ReservaFacade() {
		super(Reserva.class);
	}
	
	@PersistenceContext(unitName = "ReyesDuchitanga-Robbyn-ExamenFinal")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
