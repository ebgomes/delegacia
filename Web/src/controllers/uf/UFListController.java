
package controllers.uf;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.UF;
import br.com.remote.UFRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class UFListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UFRemote uf;
	
	private List<UF> lista;
	
	public List<UF> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = uf.list();
		}
		return this.lista;
	}	
}
