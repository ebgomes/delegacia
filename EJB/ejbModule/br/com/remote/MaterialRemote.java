package br.com.remote;

import javax.ejb.Local;

import br.com.arquitetura.CanConfirm;
import br.com.arquitetura.CanFind;
import br.com.arquitetura.CanList;
import br.com.arquitetura.IRemote;
import br.com.model.Material;

@Local
public interface MaterialRemote extends IRemote, CanFind<Material>, CanConfirm<Material>, CanList<Material> {

	
	
}
