package utils;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import lombok.experimental.ExtensionMethod;
import br.com.arquitetura.ConfirmaQue;
import br.com.common.ParceiroParaAutoComplete;
import br.com.model.Parceiro;
import br.com.remote.ParceiroRemote;

@javax.faces.bean.ManagedBean
@ExtensionMethod(value={ConfirmaQue.class})
public class ParceiroConverter implements Converter {
	@EJB
	private ParceiroRemote parceiros;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String retorno) {
		Parceiro parceiro = null;
		if (retorno.naoEhUmaStringNulaOuVazia()){
			try {				
				parceiro = parceiros.findById(Long.parseLong(retorno));
			} catch (NumberFormatException e) {
				parceiro = null;	
			}
			
		}
		return parceiro;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String retorno = "";
		if (ConfirmaQue.naoEhNulo(arg2)){
			if(arg2 instanceof ParceiroParaAutoComplete){
				ParceiroParaAutoComplete parceiro = (ParceiroParaAutoComplete)arg2;
				retorno = String.valueOf(parceiro.getId());
			}
			if(arg2 instanceof Parceiro){
				Parceiro parceiro = (Parceiro)arg2;
				retorno = String.valueOf(parceiro.getId());
			}
			
		}
		return retorno;
	}

}
