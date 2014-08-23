package br.com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import br.com.arquitetura.AbstractEntity;
import br.com.arquitetura.Identifiable;

@Entity
@Getter
@Setter
public class SaldosDeEstoque extends AbstractEntity implements Identifiable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idMaterial")
	private Material material;
	
	private Double saldo;
	
	private Double custoMedio;

	@Override
	public Long getId() {
		return id;
	}

}
