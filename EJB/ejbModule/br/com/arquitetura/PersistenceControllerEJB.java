/*
package br.com.arquitetura;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersistenceControllerEJB implements PersistenceController {

	
	@EJB
	private QueryControllerEJB queryControllerEJB;
	
	@Override
	public <B extends Serializable> List<B> getBeanList(String sql,
			Class<B> beanClass, Object... param) {
		
		return queryControllerEJB.getBeanList(sql, beanClass, param);
		
	}

}
*/
