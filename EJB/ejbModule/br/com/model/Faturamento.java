package br.com.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import br.com.arquitetura.AbstractEntity;
import br.com.arquitetura.Data;
import br.com.arquitetura.Identifiable;

@Entity
@Getter
@Setter
public class Faturamento extends AbstractEntity implements Identifiable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue	
	private Long id;  
	
	private Long numeroDocumento;
	
	@AttributeOverride(name = Data.CONTEUDO, column = @Column(name = "dataMovimento"))
	private Data dataMovimento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idParceiro")
	private Parceiro parceiro;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipoDeMovimento")
	private TipoDeMovimento tipoDeMovimento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipoDeDocumento")
	private TipoDeDocumento tipoDeDocumento;
	
	@Override
	public Long getId() {
		return id;
	}
}
