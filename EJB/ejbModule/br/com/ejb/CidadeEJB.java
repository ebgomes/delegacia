package br.com.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.common.CidadeParaListagem;
import br.com.model.Cidade;
import br.com.remote.CidadeRemote;

@Stateless
public class CidadeEJB implements CidadeRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
	private EntityManager em;

	/*
	 * @EJB PersistenceController persistencia;
	 */

	@Override
	public Cidade findById(Long id) {
		TypedQuery<Cidade> query = em.createQuery(
				"from Cidade u where u.id = :id", Cidade.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Cidade reload(Cidade entity) {
		return findById(entity.getId());
	}

	@Override
	public List<Cidade> list() {
		TypedQuery<Cidade> query = em.createQuery("select d from Cidade d",
				Cidade.class);
		return query.getResultList();
	}

	@Override
	public Cidade confirm(Cidade entity) {
		switch (entity.getEntityState()) {
		case NEW:
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(Cidade.class, entity.getId()));
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
	public List<Cidade> listaDeCidadesPorDescricao(String descricao) {

		// return persistencia.getBeanList(getQueryPorNome(nome),
		// AlfaParceiroTransportadorListagem.class, new BeanConsultaGroup());

		// return persistencia.getBeanList(getQueryPorDescricao(descricao),
		// Cidade.class);

		/*
		 * StringBuffer sql = new StringBuffer();
		 * sql.append(getQueryPorDescricao(descricao));
		 */

		TypedQuery<Cidade> query = em.createQuery(
				"select d from Cidade d where d.descricao like :descricao",
				Cidade.class);
		query.setParameter("descricao", "%" + descricao.toUpperCase() + "%");
		return query.getResultList();

	}

	/*
	 * private String getQueryPorDescricao(String descricao) { StringBuilder sb
	 * = new StringBuilder(); sb.append("SELECT CIDADE.DESCRICAO" +
	 * " from CIDADE " + " where CIDADE.DESCRICAO LIKE '" + "'%" +
	 * descricao.toUpperCase() + "%'" + " ORDER BY CIDADE.DESCRICAO"); return
	 * sb.toString(); }
	 */

	@Override
	public List<CidadeParaListagem> listaDeCidadesPorDescricaoListagem(
			String descricao) {

		List<Cidade> cidades = listaDeCidadesPorDescricao(descricao);
		List<CidadeParaListagem> cidadesParaListagem = new ArrayList<CidadeParaListagem>();

		for (Cidade cidade : cidades) {
			CidadeParaListagem c = new CidadeParaListagem();
			c.setId(cidade.getId());
			c.setDescricao(cidade.getDescricao());
			c.setDescricaoUF(cidade.getUf().getSigla());
			cidadesParaListagem.add(c);
		}
		return cidadesParaListagem;
	}
}
