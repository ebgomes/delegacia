package controllers.material;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.model.Material;
import br.com.model.UnidadeMedida;
import br.com.remote.MaterialRemote;
import br.com.remote.UnidadeMedidaRemote;

@ManagedBean
@SessionScoped
public class MaterialFormController extends
		ControladorBasicoDeFormulario<Material, MaterialRemote> {
	
		
	private static final long serialVersionUID = 1L;
	
	@EJB
	private MaterialRemote material;
	
	@EJB
	private UnidadeMedidaRemote unidadeMedida;

	@Override
	protected Material criaNovoObjeto() { 
		Material m = new Material();
		m.setUnidadeMedida(new UnidadeMedida());		
		return m;
	}

	@Override
	protected MaterialRemote servidor() {
		return this.material;
	}
	public List<UnidadeMedida> getUnidadeMedida(){
		return unidadeMedida.list();
	}
}
