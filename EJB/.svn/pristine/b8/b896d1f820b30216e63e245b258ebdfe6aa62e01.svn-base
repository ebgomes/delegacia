package br.com.remote;

import java.util.List;

import javax.ejb.Local;

import br.com.arquitetura.CanConfirm;
import br.com.arquitetura.CanFind;
import br.com.arquitetura.CanList;
import br.com.arquitetura.IRemote;
import br.com.common.ParceiroParaAutoComplete;
import br.com.model.Parceiro;

@Local
public interface ParceiroRemote extends IRemote, CanFind<Parceiro>, CanConfirm<Parceiro>, CanList<Parceiro>{

	public List<ParceiroParaAutoComplete> listaDeParceirosParaAutoComplete(
			String descricao);
	
	public List<Parceiro> listaDeParceirosPorNome(String descricao); 

}
