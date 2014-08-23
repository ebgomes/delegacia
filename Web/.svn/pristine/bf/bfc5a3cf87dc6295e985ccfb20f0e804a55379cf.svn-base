package controllers.uf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.model.UF;
import br.com.remote.UFRemote;

@ManagedBean
@SessionScoped
public class UFFormController extends
		ControladorBasicoDeFormulario<UF, UFRemote> {

	private static final long serialVersionUID = 1L;

	@EJB
	private UFRemote uf;

	@Override
	protected UF criaNovoObjeto() { 
		return new UF();
	}

	@Override
	protected UFRemote servidor() {
		return this.uf;
	}
}
