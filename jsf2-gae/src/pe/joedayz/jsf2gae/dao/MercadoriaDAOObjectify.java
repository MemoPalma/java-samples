package pe.joedayz.jsf2gae.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import pe.joedayz.jsf2gae.model.Mercadoria;

import com.googlecode.objectify.Key;




public class MercadoriaDAOObjectify implements Serializable, MercadoriaDAO {

	@Override
	public Long save(Mercadoria mercadoria) {
		ofy().save().entity(mercadoria).now();
		return mercadoria.getId();
	}
	
	@Override
	public List<Mercadoria> getAll() {
		return ofy().load().type(Mercadoria.class).list();
	}
	
	@Override
	public Boolean remove(Mercadoria mercadoria) {
		ofy().delete().entity(mercadoria).now();
		return true;
	}
	
	@Override
	public Mercadoria findById(Long id) {
		Key<Mercadoria> k = Key.create(Mercadoria.class, id);
		return ofy().load().key(k).get();
	}
	
}
