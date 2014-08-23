package br.com.remote;

import java.util.List;

import javax.ejb.Local;

import br.com.arquitetura.CanConfirm;
import br.com.arquitetura.CanFind;
import br.com.arquitetura.CanList;
import br.com.arquitetura.IRemote;
import br.com.common.CidadeParaListagem;
import br.com.model.Cidade;

@Local
public interface CidadeRemote extends IRemote, CanFind<Cidade>, CanList<Cidade>, CanConfirm<Cidade>{
	
	public List<Cidade> listaDeCidadesPorDescricao(String descricao);
	
	public List<CidadeParaListagem> listaDeCidadesPorDescricaoListagem(String descricao);

}
