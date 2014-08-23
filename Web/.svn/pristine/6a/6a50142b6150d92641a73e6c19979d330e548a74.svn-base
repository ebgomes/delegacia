package controllers.tipodedocumento;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.model.TipoDeDocumento;
import br.com.remote.TipoDeDocumentoRemote;

@ManagedBean
@SessionScoped
public class TipoDeDocumentoFormController extends
		ControladorBasicoDeFormulario<TipoDeDocumento, TipoDeDocumentoRemote> {

	private static final long serialVersionUID = 1L;

	@EJB
	private TipoDeDocumentoRemote tipoDeDocumento;

	@Override
	protected TipoDeDocumento criaNovoObjeto() { 
		return new TipoDeDocumento();
	}

	@Override
	protected TipoDeDocumentoRemote servidor() {
		return this.tipoDeDocumento;
	}
}
