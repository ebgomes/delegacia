package br.com.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.arquitetura.PU;
import br.com.common.ParceiroParaAutoComplete;
import br.com.model.Parceiro;
import br.com.remote.CidadeRemote;
import br.com.remote.ParceiroRemote;

@Stateless
public class ParceiroEJB implements ParceiroRemote {

	@PersistenceContext(unitName = PU.UNIT_NAME)
    private EntityManager em;
	
	@EJB
	private CidadeRemote cidades;
	
	@Override
	public Parceiro findById(Long id) {
		System.out.println("ID " + id);
		TypedQuery<Parceiro> query = em.createQuery("from Parceiro o  where o.id = :id", Parceiro.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Parceiro reload(Parceiro entity) {
		return findById(entity.getId());
	}

	@Override
	public Parceiro confirm(Parceiro entity) {
		switch (entity.getEntityState()) {
		case NEW:
			completarParceiro(entity);
			em.persist(entity);
			break;
		case DELETED:
			em.remove(em.getReference(Parceiro.class, entity.getId()));
			break;
		case MODIFIED:
			em.merge(entity);
			break;
		default:
			break;
		}
		return entity;
	}

	private void completarParceiro(Parceiro entity) {		
		entity.setCidade(cidades.findById(entity.getCidade().getId()));
	}

	@Override
	public List<Parceiro> list() {
		TypedQuery<Parceiro> query = em.createQuery("select o from Parceiro o", Parceiro.class);
		return query.getResultList(); 
	}

	@Override
	public List<ParceiroParaAutoComplete> listaDeParceirosParaAutoComplete(
			String nome) {

		List<Parceiro> parceiros = listaDeParceirosPorNome(nome);
		List<ParceiroParaAutoComplete> parceirosParaListagem = new ArrayList<ParceiroParaAutoComplete>();

		for (Parceiro parceiro : parceiros) {
			ParceiroParaAutoComplete p = new ParceiroParaAutoComplete();
			p.setId(parceiro.getId());
			p.setNome(parceiro.getNome());
			p.setCnpjcpf(parceiro.getCnpjcpf());
			p.setDescricaoCidade(parceiro.getCidade().getDescricao());
			parceirosParaListagem.add(p);
		}
		return parceirosParaListagem;

	}

	@Override
	public List<Parceiro> listaDeParceirosPorNome(String nome) {
		TypedQuery<Parceiro> query = em.createQuery(				
				"from Parceiro d where d.nome like :nome order by d.nome",
				Parceiro.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.getResultList();
	}
}
