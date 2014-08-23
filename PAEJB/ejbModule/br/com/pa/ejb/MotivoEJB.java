package br.com.pa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.pa.arquitetura.PU;
import br.com.pa.model.Motivo;
import br.com.pa.remote.MotivoRemote;

@Stateless
public class MotivoEJB implements MotivoRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	@Override
	public Motivo findById(Long id) {
		try {
			return em
					.createQuery("from Motivo p where p.id = :id ",
							Motivo.class).setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Motivo reload(Motivo entity) {
		return findById(entity.getId());
	}

	@Override
	public Motivo confirm(Motivo entity) {
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
	public List<Motivo> list() {
		return em.createQuery("from Motivo", Motivo.class).getResultList();

	}

}