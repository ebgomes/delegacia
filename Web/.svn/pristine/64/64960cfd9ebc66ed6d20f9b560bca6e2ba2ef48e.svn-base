package controllers.unidademedida;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.model.UnidadeMedida;
import br.com.remote.UnidadeMedidaRemote;

@ManagedBean
@SessionScoped
public class UnidadeMedidaFormController extends
		ControladorBasicoDeFormulario<UnidadeMedida, UnidadeMedidaRemote> {

	private static final long serialVersionUID = 1L;

	@EJB
	private UnidadeMedidaRemote unidadeMedida;

	@Override
	protected UnidadeMedida criaNovoObjeto() { 
		return new UnidadeMedida();
	}

	@Override
	protected UnidadeMedidaRemote servidor() {
		return this.unidadeMedida;
	}
}
