package pe.joedayz.prime.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.joedayz.prime.model.Mercadoria;


/**
 * Componente EJB que define las operaciones de negocio de la entidad <code>Mercadoria</code>.
 * 
 * <p>Hereda de <code>AbstractPersistence</code> para resolver las operaciones básicas de persistencia de <code>Mercadoria</code>.</p>
 * 
 * @author JoeDayz
 */
@Stateless
public class MercadoriaService extends AbstractPersistence<Mercadoria, Long>{

	/**
	 * Un contenedor injecta una referencia para el <code>EntityManager</code>.
	 */
	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public MercadoriaService() {
		super(Mercadoria.class);
	}

}
