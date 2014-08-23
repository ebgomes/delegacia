package br.com.pa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.pa.arquitetura.PU;
import br.com.pa.model.Situacao;
import br.com.pa.remote.SituacaoRemote;

@Stateless
public class SituacaoEJB implements SituacaoRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	@Override
	public Situacao findById(Long id) {
		try {
			return em
					.createQuery("from Situacao p where p.id = :id ",
							Situacao.class).setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Situacao reload(Situacao entity) {
		return findById(entity.getId());
	}

	@Override
	public Situacao confirm(Situacao entity) {
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
	public List<Situacao> list() {
		return em.createQuery("from Situacao", Situacao.class).getResultList();

	}

}
