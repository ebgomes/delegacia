package br.com.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.model.UnidadeMedida;
import br.com.remote.UnidadeMedidaRemote;

@Stateless
public class UnidadeMedidaEJB implements UnidadeMedidaRemote{

	@PersistenceContext(unitName = PU.UNIT_NAME)
    private EntityManager em;
	
	@Override
	public UnidadeMedida findById(Long id) {
		TypedQuery<UnidadeMedida> query = em.createQuery("from UnidadeMedida u where u.id = :id", UnidadeMedida.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public UnidadeMedida reload(UnidadeMedida entity) {
		return findById(entity.getId());
	}

	@Override
	public UnidadeMedida confirm(UnidadeMedida entity) {
		switch (entity.getEntityState()) {
		case NEW:
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(UnidadeMedida.class, entity.getId()));
			break;
		case MODIFIED:
			em.merge(entity);
			break;
		default:
			break;

		}
		return entity;
	}

	@Override
	public List<UnidadeMedida> list() {
		TypedQuery<UnidadeMedida> query = em.createQuery("select d from UnidadeMedida d", UnidadeMedida.class);
		return query.getResultList();
	}
}
