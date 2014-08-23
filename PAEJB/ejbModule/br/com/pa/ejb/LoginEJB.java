package br.com.pa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.pa.arquitetura.PU;
import br.com.pa.model.Login;
import br.com.pa.remote.LoginRemote;

@Stateless
public class LoginEJB implements LoginRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	@Override
	public Login findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login reload(Login entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login confirm(Login entity) {
		System.out.println(entity.getEntityState());
		switch (entity.getEntityState()) {

		case NEW:

			em.persist(entity);
			break;
		case MODIFIED:
			em.merge(entity);
			break;
		case DELETED:
			em.remove(entity);
			entity = null;
		default:
			break;
		}
		return entity;
	}

	@Override
	public List<Login> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login buscaPorUsuario(String usuario) {
		try {
			return em
					.createQuery(
							"select l from Login l where l.usuario =:usuario",
							Login.class).setParameter("usuario", usuario)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
