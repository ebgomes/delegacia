package br.com.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.model.TipoDeDocumento;
import br.com.remote.TipoDeDocumentoRemote;

@Stateless
public class TipoDeDocumentoEJB implements TipoDeDocumentoRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	@Override
	public TipoDeDocumento findById(Long id) {
		TypedQuery<TipoDeDocumento> query = em.createQuery(
				"from TipoDeDocumento u where u.id = :id",
				TipoDeDocumento.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public TipoDeDocumento reload(TipoDeDocumento entity) {
		return findById(entity.getId());
	}

	@Override
	public TipoDeDocumento confirm(TipoDeDocumento entity) {
		switch (entity.getEntityState()) {
		case NEW:
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(TipoDeDocumento.class, entity.getId()));
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
	public List<TipoDeDocumento> list() {
		TypedQuery<TipoDeDocumento> query = em.createQuery("select d from TipoDeDocumento d", TipoDeDocumento.class);
		return query.getResultList();
	}

}
