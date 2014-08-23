package br.com.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.model.TipoDeMovimento;
import br.com.remote.TipoDeMovimentoRemote;

@Stateless
public class TipoDeMovimentoEJB implements TipoDeMovimentoRemote{

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;
	
	@Override
	public TipoDeMovimento confirm(TipoDeMovimento entity) {
		switch (entity.getEntityState()) {
		case NEW:
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(TipoDeMovimento.class, entity.getId()));
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
	public List<TipoDeMovimento> list() {
		TypedQuery<TipoDeMovimento> query = em.createQuery("select d from TipoDeMovimento d", TipoDeMovimento.class);
		return query.getResultList();
	}

	@Override
	public TipoDeMovimento findById(Long id) {
		TypedQuery<TipoDeMovimento> query = em.createQuery(
				"from TipoDeMovimento u where u.id = :id",
				TipoDeMovimento.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public TipoDeMovimento reload(TipoDeMovimento entity) {
		return findById(entity.getId());
	}

}
