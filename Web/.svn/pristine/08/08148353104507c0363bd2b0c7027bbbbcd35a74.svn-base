package utils;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import lombok.experimental.ExtensionMethod;
import br.com.arquitetura.ConfirmaQue;
import br.com.common.CidadeParaListagem;
import br.com.model.Cidade;
import br.com.remote.CidadeRemote;

@javax.faces.bean.ManagedBean
@ExtensionMethod(value={ConfirmaQue.class})
public class CidadeConverter implements Converter {
	@EJB
	private CidadeRemote cidades;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String retorno) {
		Cidade cidade = null;
		if (retorno.naoEhUmaStringNulaOuVazia()){
			try {
				cidade = cidades.findById(Long.parseLong(retorno));
			} catch (NumberFormatException e) {
				cidade = null;	
			}
			
		}
		return cidade;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		System.out.println("arg2: "+arg2);
		String retorno = "";
		if (ConfirmaQue.naoEhNulo(arg2)){
			if(arg2 instanceof CidadeParaListagem){
				CidadeParaListagem cidade = (CidadeParaListagem)arg2;
				retorno = String.valueOf(cidade.getId());
			}
			if(arg2 instanceof Cidade){
				Cidade cidade = (Cidade)arg2;
				retorno = String.valueOf(cidade.getId());
			}
			
		}
		return retorno;
	}

}
