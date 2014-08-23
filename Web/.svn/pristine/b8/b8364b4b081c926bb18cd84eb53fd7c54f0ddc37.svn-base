package controllers.parceiro;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.arquitetura.EntityState;
import br.com.common.CidadeParaListagem;
import br.com.model.Cidade;
import br.com.model.Parceiro;
import br.com.remote.CidadeRemote;
import br.com.remote.ParceiroRemote;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class ParceiroFormController extends
		ControladorBasicoDeFormulario<Parceiro, ParceiroRemote> {
	
		
	private static final long serialVersionUID = 1L;
	private Long idCidade;
	
	@EJB
	private ParceiroRemote parceiro;
	
	@EJB
	private CidadeRemote cidade;
	
	@Override
	protected Parceiro criaNovoObjeto() { 
		Parceiro m = new Parceiro();
		m.setEntityState(EntityState.NEW);
		m.setCidade(new Cidade());		
		return m;
	}

	@Override
	protected ParceiroRemote servidor() {
		return this.parceiro;
	}
	public List<Cidade> getCidade(){
		return cidade.list();
	}
	
	@Override
	protected void antesDeConfirmar(Parceiro entidade) {
		
	}
	
	@Override
	public void mudouAlgumValor() {
		System.out.println(idCidade);
	}
	
	/*
	public List<String> cidadePorDescricao(String descricao){
		
		List<String> results = new ArrayList<String>();
		List<Cidade> cidades = cidade.listaDeCidadesPorDescricao(descricao);
		
		for (Cidade cidade : cidades) {
			results.add(cidade.getDescricao() + "-" + cidade.getUf().getSigla());
		}
		return results;
	}
	*/
	
	public List<CidadeParaListagem> cidadePorDescricaoListagem(String descricao){
		return cidade.listaDeCidadesPorDescricaoListagem(descricao);
	}
}
