package pe.joedayz.cdi.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.cdi.model.Mercadoria;
import pe.joedayz.cdi.service.MercadoriaService;



@Named
@RequestScoped
public class MercadoriaMB implements Serializable {
	

	@Inject
	private MercadoriaService service;
	

	@Inject
	private Mercadoria mercadoria;
	
	private Long idSelecionado;
	
	private List<Mercadoria> mercadorias;
	
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
	
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		mercadoria = service.find(idSelecionado);
		//log.debug("Pronto pra editar");
	}
	
	public List<Mercadoria> getMercadorias() {
		System.out.println("service: "+service);
		if (mercadorias == null) {
			mercadorias = service.findAll();
		}
		return mercadorias;
	}

	
	public String salvar() {
		try {
			System.out.println("service: "+service);
			service.save(mercadoria);
		} catch(Exception ex) {
		
			addMessage(getMessageFromI18N("msg.erro.salvar.mercadoria"), ex.getMessage());
			return "";
		}
		
		return "listaMercadorias";
	}
	
	public String remover() {
		try {
			service.remove(mercadoria);
		} catch(Exception ex) {
			
			addMessage(getMessageFromI18N("msg.erro.remover.mercadoria"), ex.getMessage());
			return "";
		}
		
		return "listaMercadorias";
	}
	

	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	

	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
}
