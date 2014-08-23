package controllers.tipodemovimento;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.model.TipoDeMovimento;
import br.com.remote.TipoDeMovimentoRemote;

@ManagedBean
@SessionScoped
public class TipoDeMovimentoFormController extends
		ControladorBasicoDeFormulario<TipoDeMovimento, TipoDeMovimentoRemote> {

	private static final long serialVersionUID = 1L;

	@EJB
	private TipoDeMovimentoRemote tipoDeMovimento;

	@Override
	protected TipoDeMovimento criaNovoObjeto() { 
		return new TipoDeMovimento();
	}

	@Override
	protected TipoDeMovimentoRemote servidor() {
		return this.tipoDeMovimento;
	}
}
