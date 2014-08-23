package br.com.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.model.UF;
import br.com.remote.UFRemote;

@Stateless
public class UFEJB implements UFRemote{

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	@Override
	public UF findById(Long id) {
		TypedQuery<UF> query = em.createQuery(
				"from UF u where u.id = :id",
				UF.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public UF reload(UF entity) {
		return findById(entity.getId());
	}

	@Override
	public UF confirm(UF entity) {
		switch (entity.getEntityState()) {
		case NEW:
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(UF.class, entity.getId()));
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
	public List<UF> list() {
		TypedQuery<UF> query = em.createQuery("select d from UF d", UF.class);
		return query.getResultList();
	}

}
