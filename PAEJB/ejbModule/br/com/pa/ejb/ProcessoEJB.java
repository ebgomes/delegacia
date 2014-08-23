package br.com.pa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.pa.arquitetura.PU;
import br.com.pa.model.Processo;
import br.com.pa.remote.ProcessoRemote;

@Stateless
public class ProcessoEJB implements ProcessoRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	@Override
	public Processo findById(Long id) {
		try {
			return em
					.createQuery("from Processo p where p.id = :id ",
							Processo.class).setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Processo reload(Processo entity) {
		return findById(entity.getId());
	}

	@Override
	public Processo confirm(Processo entity) {
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
	public List<Processo> list() {
		return em.createQuery("from Processo", Processo.class).getResultList();

	}

}
