
package controllers.cidade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.Cidade;
import br.com.remote.CidadeRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class CidadeListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CidadeRemote cidade;
	
	private List<Cidade> lista;
	
	public List<Cidade> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = cidade.list();
		}
		return this.lista;
	}	
}
