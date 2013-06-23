package pe.joedayz.jsf2gae.dao;

import java.util.List;

import pe.joedayz.jsf2gae.model.Mercadoria;



public interface MercadoriaDAO {

	Long save(Mercadoria mercadoria);

	List<Mercadoria> getAll();

	Boolean remove(Mercadoria mercadoria);
	

	Mercadoria findById(Long id);
}
