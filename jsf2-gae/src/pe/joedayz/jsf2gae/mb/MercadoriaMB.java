package pe.joedayz.jsf2gae.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;

import pe.joedayz.jsf2gae.dao.MercadoriaDAO;
import pe.joedayz.jsf2gae.dao.MercadoriaDAOObjectify;
import pe.joedayz.jsf2gae.model.Mercadoria;



@ManagedBean
@SessionScoped
public class MercadoriaMB implements Serializable {
	
	private static Logger log = Logger.getLogger(MercadoriaMB.class);

	private MercadoriaDAO dao;
	

	private Mercadoria mercadoria;

	private Long idSelecionado;
	

	private Map<Long, Mercadoria> mercadorias;
	
	public MercadoriaMB() {
		dao = new MercadoriaDAOObjectify();
		fillMercadorias();
	}
	
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	
	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}
	
	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public Long getIdSelecionado() {
		return idSelecionado;
	}
	

	public DataModel<Mercadoria> getDmMercadorias() {
		return new ListDataModel<Mercadoria>(new ArrayList<Mercadoria>(mercadorias.values()));
	}
	
	private void fillMercadorias() {
		try {
			List<Mercadoria> qryMercadorias = new ArrayList<Mercadoria>(dao.getAll());
			mercadorias = new HashMap<Long, Mercadoria>();
			for (Mercadoria m: qryMercadorias) {
				mercadorias.put(m.getId(), m);
			}
			
			log.debug("Carregou a lista de mercadorias ("+mercadorias.size()+")");
		} catch(Exception ex) {
			log.error("Erro ao carregar a lista de mercadorias.", ex);
			addMessage(getMessageFromI18N("msg.erro.listar.mercadoria"), ex.getMessage());
		}
		
	}
	

	public void incluir(){
		mercadoria = new Mercadoria();
		log.debug("Pronto pra incluir");
	}
	

	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		mercadoria = mercadorias.get(idSelecionado);
		log.debug("Pronto pra editar");
	}


	public String salvar() {
		try {
			dao.save(mercadoria);
			mercadorias.put(mercadoria.getId(), mercadoria);
		} catch(Exception ex) {
			log.error("Erro ao salvar mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.mercadoria"), ex.getMessage());
			return "";
		}
		log.debug("Salvour mercadoria "+mercadoria.getId());
		return "listaMercadorias";
	}
	

	public void atualizar() {
		fillMercadorias();
	}
	

	public void reset() {
		mercadoria = null;
		idSelecionado = null;
	}
	

	public String remover() {
		try {
			dao.remove(mercadoria);
			mercadorias.remove(mercadoria.getId());
		} catch(Exception ex) {
			log.error("Erro ao remover mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover.mercadoria"), ex.getMessage());
			return "";
		}
		log.debug("Removeu mercadoria "+mercadoria.getId());
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
