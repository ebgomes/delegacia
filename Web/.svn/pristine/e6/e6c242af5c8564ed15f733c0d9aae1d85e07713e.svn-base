
package controllers.tipodedocumento;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.TipoDeDocumento;
import br.com.remote.TipoDeDocumentoRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class TipoDeDocumentoListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private TipoDeDocumentoRemote tipoDeDocumento;
	
	private List<TipoDeDocumento> lista;
	
	public List<TipoDeDocumento> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = tipoDeDocumento.list();
		}
		return this.lista;
	}	
}
