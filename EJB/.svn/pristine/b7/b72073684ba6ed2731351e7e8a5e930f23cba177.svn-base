package br.com.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.model.Material;
import br.com.remote.MaterialRemote;

@Stateless
public class MaterialEJB implements MaterialRemote{
	
	@PersistenceContext(unitName = PU.UNIT_NAME)
    private EntityManager em;
	
	@Override
	public Material findById(Long id) {
		TypedQuery<Material> query = em.createQuery("from Material u where u.id = :id", Material.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Material reload(Material entity) {
		return findById(entity.getId());
	}

	@Override
	public Material confirm(Material entity) {
		switch (entity.getEntityState()) {
		case NEW:
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(Material.class, entity.getId()));
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
	public List<Material> list() {
		TypedQuery<Material> query = em.createQuery("select d from Material d", Material.class);
		return query.getResultList();
	}	
	
}
