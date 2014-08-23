package controllers.cidade;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.model.Cidade;
import br.com.model.UF;
import br.com.remote.CidadeRemote;
import br.com.remote.UFRemote;

@ManagedBean
@SessionScoped
public class CidadeFormController extends
		ControladorBasicoDeFormulario<Cidade, CidadeRemote> {
	
		
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CidadeRemote cidade;
	
	@EJB
	private UFRemote uf;
	
	@Override
	protected Cidade criaNovoObjeto() { 
		Cidade m = new Cidade();
		m.setUf(new UF());		
		return m;
	}

	@Override
	protected CidadeRemote servidor() {
		return this.cidade;
	}
	public List<UF> getUf(){
		return uf.list();
	}
}
