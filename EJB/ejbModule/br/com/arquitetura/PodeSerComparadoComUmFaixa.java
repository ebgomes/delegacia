package br.com.arquitetura;

public interface PodeSerComparadoComUmFaixa<Classe> {
	Boolean estaNaFaixaEntre(Classe menor, Classe maior);

	Boolean estaNaFaixaEntre(Classe menor, Classe maior, Boolean inclusive);
}
