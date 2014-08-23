package br.com.remote;

import javax.ejb.Local;

import br.com.arquitetura.CanConfirm;
import br.com.arquitetura.CanFind;
import br.com.arquitetura.CanList;
import br.com.arquitetura.IRemote;
import br.com.model.UnidadeMedida;

@Local
public interface UnidadeMedidaRemote extends IRemote, CanFind<UnidadeMedida>, CanConfirm<UnidadeMedida>, CanList<UnidadeMedida>{

}
