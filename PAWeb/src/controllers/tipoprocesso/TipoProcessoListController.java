package controllers.tipoprocesso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.pa.model.Motivo;
import br.com.pa.remote.MotivoRemote;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class TipoProcessoListController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	MotivoRemote tipos;

	List<Motivo> lista = new ArrayList<Motivo>();

	public List<Motivo> listarTipoProcessos() {
		return tipos.list();
	}

}
