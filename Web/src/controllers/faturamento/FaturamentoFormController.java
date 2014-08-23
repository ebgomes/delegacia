package controllers.faturamento;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.ControladorBasicoDeFormulario;
import br.com.arquitetura.Data;
import br.com.common.ParceiroParaAutoComplete;
import br.com.model.Faturamento;
import br.com.model.Parceiro;
import br.com.model.TipoDeDocumento;
import br.com.model.TipoDeMovimento;
import br.com.remote.FaturamentoRemote;
import br.com.remote.ParceiroRemote;
import br.com.remote.TipoDeDocumentoRemote;
import br.com.remote.TipoDeMovimentoRemote;

@ManagedBean
@SessionScoped 
@Getter
@Setter
public class FaturamentoFormController extends
		ControladorBasicoDeFormulario<Faturamento, FaturamentoRemote> {

	private static final long serialVersionUID = 1L;
	private Long idParceiro;

	@EJB
	private FaturamentoRemote faturamento;
	
	@EJB
	private TipoDeDocumentoRemote tipoDeDocumento;
	 
	@EJB
	private TipoDeMovimentoRemote tipoDeMovimento;

	@EJB
	private ParceiroRemote parceiro;
	
	@Override
	protected Faturamento criaNovoObjeto() { 
		Faturamento f = new Faturamento();
		f.setDataMovimento(Data.hoje());	
     	f.setParceiro(new Parceiro());
     	f.setTipoDeDocumento(new TipoDeDocumento());
      	f.setTipoDeMovimento(new TipoDeMovimento());
		return f;
	}

	@Override
	protected FaturamentoRemote servidor() {
		return this.faturamento;
	}
	public List<ParceiroParaAutoComplete> parceiroParaAutoComplete(String descricao){
		return parceiro.listaDeParceirosParaAutoComplete(descricao);
	}
	public List<TipoDeDocumento> getTipoDeDocumento(){
		return tipoDeDocumento.list();
	}
	public List<TipoDeMovimento> getTipoDeMovimento(){
		return tipoDeMovimento.list();	 
	}
	
}
