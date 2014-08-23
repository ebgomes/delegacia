package br.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Setter;

import lombok.Getter;

import br.com.arquitetura.AbstractEntity;
import br.com.arquitetura.Identifiable;

@Entity
@Getter
@Setter
public class UnidadeMedida extends AbstractEntity implements Identifiable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	private String sigla;
	
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
