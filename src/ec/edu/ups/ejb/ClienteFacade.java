package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.usp.modelo.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	public ClienteFacade() {
		super(Cliente.class);
	}

	@PersistenceContext(unitName = "ReyesDuchitanga-Robbyn-ExamenFinal")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Cliente buscarCliente(String cedula) {
		try {
			String jpql = "SELECT cli FROM Cliente cli WHERE cli.cedula='" + cedula + "'";
			Cliente cliente = (Cliente) em.createQuery(jpql).getSingleResult();
			return cliente;
		} catch (Exception e) {
			return null;
		}
	}

}
