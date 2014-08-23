
package controllers.parceiro;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.Parceiro;
import br.com.remote.ParceiroRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class ParceiroListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ParceiroRemote parceiro;
	
	private List<Parceiro> lista;
	
	public List<Parceiro> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = parceiro.list();
		}
		return this.lista;
	}	
}
