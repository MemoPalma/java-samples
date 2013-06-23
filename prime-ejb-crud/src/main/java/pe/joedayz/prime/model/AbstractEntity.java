package pe.joedayz.prime.model;

import java.io.Serializable;

/**
 * Es el  contrato base para las entidades persistentes de la aplicacion
 * 
 * <p>Ese contrato es utilizadopor los componentes responsables de las operaciones básicas de persistencia: <code>AbstractPersistence</code>.</p>
 * 
 * @see pe.joedayz.prime.service.AbstractPersistence
 * 
 * @author JoeDayz
 */
public interface AbstractEntity extends Serializable {

	/**
	 * @return Una referencia de la clave primaria (Primary Key) de cada objeto persistido.
	 * 		   En caso el objeto no pueda ser persistido, debe retornar <code>null</code>.
	 */
	public Number getId();

}
