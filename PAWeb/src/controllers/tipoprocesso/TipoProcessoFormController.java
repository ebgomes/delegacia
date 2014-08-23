package controllers.tipoprocesso;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.pa.arquitetura.ControladorBasicoDeFormulario;
import br.com.pa.model.Motivo;
import br.com.pa.remote.MotivoRemote;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class TipoProcessoFormController extends
		ControladorBasicoDeFormulario<Motivo, MotivoRemote> {

	private static final long serialVersionUID = 1L;

	@EJB
	MotivoRemote tipos;

	@Override
	protected Motivo criaNovoObjeto() {
		return new Motivo();
	}

	@Override
	protected MotivoRemote servidor() {
		return tipos;
	}

}
