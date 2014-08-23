package br.com.arquitetura;

import java.io.Serializable;

public interface IIdentifier<I> extends Serializable {
	
	I getId();

}
