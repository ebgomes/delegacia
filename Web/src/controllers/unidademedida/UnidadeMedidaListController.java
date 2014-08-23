
package controllers.unidademedida;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.UnidadeMedida;
import br.com.remote.UnidadeMedidaRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class UnidadeMedidaListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UnidadeMedidaRemote unidadeMedida;
	
	private List<UnidadeMedida> lista;
	
	public List<UnidadeMedida> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = unidadeMedida.list();
		}
		return this.lista;
	}	
}
