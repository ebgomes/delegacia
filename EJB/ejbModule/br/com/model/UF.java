package br.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.arquitetura.AbstractEntity;
import br.com.arquitetura.Identifiable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UF extends AbstractEntity implements Identifiable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String sigla;
	
	private String descricao;
	
	public void setCodigo(Long codigo) {
        setId(codigo);
    }

    public Long getCodigo() {
        return getId();
    }


}
