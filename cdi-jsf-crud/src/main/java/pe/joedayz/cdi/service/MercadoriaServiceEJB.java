package pe.joedayz.cdi.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.joedayz.cdi.model.Mercadoria;



@Stateless
public class MercadoriaServiceEJB extends AbstractPersistence<Mercadoria, Long> 
	implements MercadoriaService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public MercadoriaServiceEJB() {
		super(Mercadoria.class);
	}
	
}
