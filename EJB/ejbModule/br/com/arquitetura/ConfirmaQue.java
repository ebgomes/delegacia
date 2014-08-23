package br.com.arquitetura;

import java.util.Collection;
import java.util.Map;

public final class ConfirmaQue {

    public static final boolean nao(Boolean condicao) {
        return !condicao;
    }

    public static final boolean ehUmaStringNulaOuVazia(String string) {
        return StringUtils.isNullOrEmpty(string);
    }

    public static final boolean naoEhUmaStringNulaOuVazia(String string) {
        return nao(ehUmaStringNulaOuVazia(string));
    }

    public static final <T> boolean ehUmaColecaoVazia(Collection<T> colecao) {
        return colecao.isEmpty();
    }

    public static final <T> boolean ehUmaColecaoNulaOuVazia(Collection<T> colecao) {
        return CollectionUtils.isNullOrEmpty(colecao);
    }

    public static <T> boolean naoEhUmaColecaoNulaOuVazia(Collection<T> colecao) {
        return nao(ehUmaColecaoNulaOuVazia(colecao));
    }

    public static <T> boolean ehNulo(T valor) {
        return ObjectUtils.isNull(valor);
    }

    public static <T> boolean naoEhNulo(T valor) {
        return nao(ehNulo(valor));
    }

    public static <T> boolean contem(T valor, Collection<T> colecao) {
        return colecao.contains(valor);
    }

    public static <T> boolean naoContem(T valor, Collection<T> colecao) {
        return nao(contem(valor, colecao));
    }

    public static boolean ehUmNumeroNuloOuZero(Number valor) {
        return ehNulo(valor) ? true : valor.doubleValue() == 0;
    }

    public static boolean naoEhUmNumeroNuloOuZero(Number valor) {
        return nao(ehUmNumeroNuloOuZero(valor));
    }

    public static <T> boolean ehIgual(T este, T aquele) {
        return saoIguais(este, aquele);
    }

    public static <T> boolean naoEhIgual(T este, T aquele) {
        return naoSaoIguais(este, aquele);
    }

    public static <T> boolean saoIguais(T este, T aquele) {
        if (ConfirmaQue.ehNulo(este) && ConfirmaQue.ehNulo(aquele)) {
            return true;
        }
        if (ConfirmaQue.ehNulo(este) && ConfirmaQue.naoEhNulo(aquele)) {
            return false;
        }
        if (ConfirmaQue.naoEhNulo(este) && ConfirmaQue.ehNulo(aquele)) {
            return false;
        }
        return saoAMesmaInstancia(este, aquele) ? true : este.equals(aquele);
    }

    public static <T> boolean naoEhUmTipoDe(Class<T> classe, Object objeto) {
        return nao(ehUmTipoDe(classe, objeto));
    }

    public static <T> boolean naoEhUmTipoDe(Object objeto, Class<T> classe) {
        return nao(ehUmTipoDe(classe, objeto));
    }

    public static <T> boolean ehUmTipoDe(Class<T> classe, Object objeto) {
        return naoSaoNulos(classe, objeto) && classe.isInstance(objeto);
    }

    public static <T> boolean ehUmTipoDe(Object objeto, Class<T> classe) {
        return naoSaoNulos(classe, objeto) && classe.isInstance(objeto);
    }

    public static <T> boolean saoDaMesmaClasse(Class<T> classe, Object este, Object aquele) {
        return classe.isInstance(este) && classe.isInstance(aquele);
    }

    public static <T> boolean naoSaoDaMesmaClasse(Class<T> classe, Object este, Object aquele) {
        return nao(saoDaMesmaClasse(classe, este, aquele));
    }

    public static <T> boolean saoAMesmaInstancia(T este, T aquele) {
        return este == aquele;
    }

    public static <T> boolean naoSaoIguais(T este, Object aquele) {
        return nao(saoIguais(este, aquele));
    }

    public static <T> boolean naoSaoAMesmaIntancia(T este, T aquele) {
        return nao(saoAMesmaInstancia(este, aquele));
    }

    public static boolean peloMenosParteDaPalavraEstaEmUmaDasPalavrasDaLista(String palavra, Collection<String> palavras) {
        return StringUtils.peloMenosParteDaPalavraEstaEmUmaDasPalavrasDaLista(palavra, palavras);
    }

    public static boolean aPalavraNaoEstahContidaEmNenhumaDasPalavrasDaLista(String palavra, Collection<String> palavras) {
        return nao(peloMenosParteDaPalavraEstaEmUmaDasPalavrasDaLista(palavra, palavras));
    }

    public static <T> boolean ehUmDosValores(T este, T... valores) {
        for (T aquele : valores) {
            if (saoIguais(este, aquele)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean naoEhUmDosValores(T este, T... valores) {
        return nao(ehUmDosValores(este, valores));
    }

    public static <T> boolean saoDiferentes(T este, T aquele) {
        return nao(saoIguais(este, aquele));
    }

    public static <K, V> boolean temAChave(K chave, Map<K, V> mapa) {
        return ehNulo(mapa) || ehNulo(chave) ? false : mapa.containsKey(chave);
    }

    public static boolean naoSaoNulos(Object... valores) {
        return nao(saoNulos(valores));
    }

    public static boolean saoNulos(Object... valores) {
        for (Object valor : valores) {
            if (ehNulo(valor)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ehUmEmailValido(String email) {
        return EmailUtil.validarEmail(email);
    }

    public static boolean naoEhUmEmailValido(String email) {
        return nao(ehUmEmailValido(email));
    }
    /*
    public static boolean temUmContextoNaListaDeParametros(Object... parametros) {
        for (Object parametro : parametros)
            if (ehUmTipoDe(DCContextShared.class, parametro))
                return true;
        return false;
    }
    

    public static boolean naoTemUmContextoNaListaDeParametros(Object... parametros) {
        return nao(temUmContextoNaListaDeParametros(parametros));
    }
    */

    public static boolean ehUmArrayVazio(Object... valores) {
        return valores.length <= 0;
    }

    public static boolean naoEhUmArrayVazio(Object... valores) {
        return nao(ehUmArrayVazio(valores));
    }

    public static boolean ehUmArrayNuloOuVazio(Object... valores) {
        return ehNulo(valores) || ehUmArrayVazio(valores);
    }

    public static boolean naoEhUmArrayNuloOuVazio(Object... valores) {
        return nao(ehUmArrayNuloOuVazio(valores));
    }

}
