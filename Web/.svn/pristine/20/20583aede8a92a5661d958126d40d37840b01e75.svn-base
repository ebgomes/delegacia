
package controllers.tipodemovimento;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.TipoDeMovimento;
import br.com.remote.TipoDeMovimentoRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class TipoDeMovimentoListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private TipoDeMovimentoRemote tipoDeMovimento;
	
	private List<TipoDeMovimento> lista;
	
	public List<TipoDeMovimento> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = tipoDeMovimento.list();
		}
		return this.lista;
	}	
}
