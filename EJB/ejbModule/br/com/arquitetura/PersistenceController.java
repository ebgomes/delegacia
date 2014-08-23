package br.com.arquitetura;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

@Local
public interface PersistenceController {
	
	<B extends Serializable> List<B> getBeanList(String sql, Class<B> beanClass, Object... param);

}
