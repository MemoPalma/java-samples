package pe.joedayz.prime.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import pe.joedayz.prime.model.Mercadoria;
import pe.joedayz.prime.service.MercadoriaService;


/**
 * Componente responsable por integrar el front-end (páginas JSF) con la capa de serviço (EJB), y  resolver el registro de <code>Mercadoria</code>.
 * 
 * <p>Se trata de un  <code>Managed Bean</code>, es decir, una instancia de esta clase sera controlada por <code>JSF</code>. Un objeto es creado para atender alguna página del registro (Lista / Nuevo / Editar). Mientras una página permanece abierta en el navegador, un objeto <code>MercadoriaMB</code> permanece en el servidor.</p>
 * 
 * <p>Este componente actua con el rol parecido a un <code>Controller</code> de otros frameworks <code>MVC</code>, el resuelve el flujo de navegaçión y relaciona los componentes visuales con sus datos.</p>
 * 
 * @author JoeDayz
 */
@ManagedBean(name="mercadoriaMB")
@ViewScoped
public class MercadoriaMB implements Serializable {

	/**
	 * Contenedor inyecta una referencia del ejb MercadoriaService
	 */
	@EJB
	private MercadoriaService service;
	
	private Long idSelecionado;
	
	/**
	 * Lista de las <code>Mercadoria</code>(s) presentadas en el  <code>Datatable</code>.
	 */
	private List<Mercadoria> mercadorias;
	
	/**
	 * Referencia para la mercadoria que sera utilizada en la inclusión o edición.
	 */
	private Mercadoria mercadoria;
	
	
	public MercadoriaMB() {
	}
	
	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public Long getIdSelecionado() {
		return idSelecionado;
	}
	
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	
	public void incluir(){
		mercadoria = new Mercadoria();
		//log.debug("Para añadir");
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		mercadoria = service.find(idSelecionado);
		//log.debug("Para editar");
	}
	
	public List<Mercadoria> getMercadorias() {
		if (mercadorias == null) {
			mercadorias = service.findAll();
		}
		return mercadorias;
	}

	
	public String salvar() {
		try {
			service.save(mercadoria);
		} catch(Exception ex) {
			//log.error("Error al guardar Mercaderia.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.mercadoria"), ex.getMessage());
			return "";
		}
		//log.debug("Guardar Mercaderia "+mercadoria.getId());
		return "listaMercadorias";
	}
	
	public String remover() {
		try {
			service.remove(mercadoria);
		} catch(Exception ex) {
			//log.error("Error al eliminar mercaderia.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover.mercadoria"), ex.getMessage());
			return "";
		}
		//log.debug("Eliminar Mercaderia "+mercadoria.getId());
		return "listaMercadorias";
	}
	
	/**
	 * @param key
	 * @return Recupera un mensaje del archivo properties <code>ResourceBundle</code>.
	 */
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Agrega un mensaje al contexto de Faces (<code>FacesContext</code>).
	 * @param summary
	 * @param detail
	 */
	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
}
