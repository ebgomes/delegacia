package br.com.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.model.Faturamento;
import br.com.remote.FaturamentoRemote;
import br.com.remote.ParceiroRemote;
import br.com.remote.TipoDeDocumentoRemote;
import br.com.remote.TipoDeMovimentoRemote;

@Stateless
public class FaturamentoEJB implements FaturamentoRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;
	
	@EJB
	ParceiroRemote parceiros;
	
	@EJB
	TipoDeDocumentoRemote tiposDeDocumentos;
	
	@EJB
	TipoDeMovimentoRemote tiposDeMovimentos;
	
	@Override
	public Faturamento findById(Long id) {
		TypedQuery<Faturamento> query = em.createQuery(
				"from Faturamento u where u.id = :id",
				Faturamento.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Faturamento reload(Faturamento entity) {
		return findById(entity.getId());
	}

	@Override
	public Faturamento confirm(Faturamento entity) {
		switch (entity.getEntityState()) {
		case NEW:
			completarFaturamento(entity);
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(Faturamento.class, entity.getId()));
			break;
		case MODIFIED:
			em.merge(entity);
			break;
		default:
			break;
		}
		return entity;
	}

	private void completarFaturamento(Faturamento entity) {
		entity.setParceiro(parceiros.findById(entity.getParceiro().getId()));
		entity.setTipoDeDocumento(tiposDeDocumentos.findById(entity.getTipoDeDocumento().getId()));
		entity.setTipoDeMovimento(tiposDeMovimentos.findById(entity.getTipoDeMovimento().getId()));
	}

	@Override
	public List<Faturamento> list() {
		TypedQuery<Faturamento> query = em.createQuery("select d from Faturamento d", Faturamento.class);
		return query.getResultList();
	}

}
