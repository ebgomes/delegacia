package br.com.arquitetura;

import javax.validation.Valid;

import com.sun.istack.internal.NotNull;

public interface CanConfirm <Type extends Identifiable>{
	
	Type confirm(@Valid @NotNull Type entity);

}
