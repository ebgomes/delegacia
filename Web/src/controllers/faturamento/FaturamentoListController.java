
package controllers.faturamento;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.Faturamento;
import br.com.remote.FaturamentoRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class FaturamentoListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private FaturamentoRemote faturamento;
	
	private List<Faturamento> lista;
	
	public List<Faturamento> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = faturamento.list();
		}
		return this.lista;
	}	
}
