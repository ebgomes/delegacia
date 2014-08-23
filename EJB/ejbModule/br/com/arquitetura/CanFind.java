package br.com.arquitetura;

import com.sun.istack.internal.NotNull;

public interface CanFind <Type extends Identifiable>{
	
	Type findById(@NotNull Long id);
	Type reload(@NotNull Type entity);

}
