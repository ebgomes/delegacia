package br.com.arquitetura;

public interface ComparavelCom<Classe> extends Comparable<Classe> {

	Boolean ehIgual(Classe outro);

	Boolean ehMaior(Classe outro);

	Boolean ehMaiorOuIgual(Classe outro);

	Boolean ehMenor(Classe outro);

	Boolean ehMenorOuIgual(Classe outro);

}
