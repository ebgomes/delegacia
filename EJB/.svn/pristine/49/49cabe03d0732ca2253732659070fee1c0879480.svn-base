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
public class Material extends AbstractEntity implements Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUnidadeMedida")
	private UnidadeMedida unidadeMedida;

	private Double pesoBruto;

	private Double pesoLiquido;
	
	private Boolean aceitaEstoqueNegativo; 

	public Long getId() {
		return id;
	}

	public void setCodigo(Long codigo) {
		setId(codigo);
	}

	public Long getCodigo() {
		return getId();
	}

}