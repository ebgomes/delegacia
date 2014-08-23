package br.com.remote;

import javax.ejb.Local;

import br.com.arquitetura.IRemote;
import br.com.model.Material;
import br.com.model.SaldosDeEstoque;

@Local
public interface SaldoDeEstoqueRemote extends IRemote {

	public SaldosDeEstoque localizaPorMaterial(Material material);
	
	public SaldosDeEstoque atualizaSaldoDeEstoqueDoMaterial(Material material);
	
	public void reprocessaSaldosDeEstoqueDoMaterial(Material material);
	
	public void reprocessaSaldosDeEstoque();
	
}
