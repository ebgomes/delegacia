
package controllers.material;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ConfirmaQue;
import br.com.model.Material;
import br.com.remote.MaterialRemote;

@ManagedBean
@Getter
@Setter
@RequestScoped
public class MaterialListController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private MaterialRemote material;
	
	private List<Material> lista;
	
	public List<Material> getLista(){
		if (ConfirmaQue.ehUmaColecaoNulaOuVazia(this.lista)) {
			this.lista = material.list();
		}
		return this.lista;
	}	
}
