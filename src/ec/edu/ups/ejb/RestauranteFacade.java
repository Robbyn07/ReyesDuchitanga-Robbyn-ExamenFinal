package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.usp.modelo.Restaurante;

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante>{
	
	public RestauranteFacade() {
		super(Restaurante.class);
	}
	
	@PersistenceContext(unitName = "ReyesDuchitanga-Robbyn-ExamenFinal")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Restaurante buscarRestaurante(String nombre) {
		try {
			String jpql = "SELECT res FROM Restaurante res WHERE res.nombre='" + nombre + "'";
			Restaurante restaurante = (Restaurante) em.createQuery(jpql).getSingleResult();
			return restaurante;
		} catch (Exception e) {
			return null;
		}
	}
}
