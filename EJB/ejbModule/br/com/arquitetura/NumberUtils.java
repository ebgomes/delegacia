package br.com.arquitetura;

import static java.math.BigDecimal.*;
import static java.util.Arrays.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public static <N extends Number> BigDecimal asBigDecimal(final N number) {
        return number instanceof BigDecimal ? (BigDecimal) number : asBigDecimal(number, 5, RoundingMode.HALF_UP);
    }

    public static <N extends Number> BigDecimal asBigDecimal(final N number, final int casasDecimais, final RoundingMode arredondamento) {
        return BigDecimal.class.isInstance(number)
                                                  ? BigDecimal.class.cast(number).setScale(casasDecimais, arredondamento)
                                                  : BigDecimal.valueOf(number.doubleValue()).setScale(casasDecimais, arredondamento);
    }

    /**
     * 
     * @param este
     * @param aquele
     * @return este eh igual a aquele?
     */
    public static final <N extends Number> Boolean ehIgual(final N este, final N aquele) {
        return este.doubleValue() == aquele.doubleValue();
    }

    /**
     * 
     * @param este
     * @param aquele
     * @return este eh maior do que aquele?
     */
    public static final <N extends Number> Boolean ehMaior(final N este, final N aquele) {
        return este.doubleValue() > aquele.doubleValue();
    }

    /**
     * 
     * @param este
     * @param aquele
     * @return este eh maior ou igual a aquele
     */
    public static final <N extends Number> Boolean ehMaiorOuIgual(final N este, final N aquele) {
        return este.doubleValue() >= aquele.doubleValue();
    }

    /**
     * @param este
     * @param aquele
     * @return este eh menor do que aquele?
     */
    public static final <N extends Number> Boolean ehMenor(final N este, final N aquele) {
        return este.doubleValue() < aquele.doubleValue();
    }

    /**
     * 
     * @param este
     * @param aquele
     * @return este eh menor ou igual a aquele?
     */
    public static final <N extends Number> Boolean ehMenorOuIgual(final N este, final N aquele) {
        return este.doubleValue() <= aquele.doubleValue();
    }

    /**
     * 
     * @param valor
     * @param inicio
     * @param fim
     * @return o valor esta na faixa entre o inicio e o fim?
     */
    public static final <N extends Number> Boolean estaNaFaixa(final N valor, final N inicio, final N fim) {
        return valor.doubleValue() > inicio.doubleValue() && valor.doubleValue() < fim.doubleValue();
    }

    /**
     * 
     * @param valor
     * @param inicio
     * @param fim
     * @return o valor esta na faixa entre o inicio e o fim, incluse ?
     */
    public static final <N extends Number> Boolean estaNaFaixaInclusive(final N valor, final N inicio, final N fim) {
        return valor.doubleValue() >= inicio.doubleValue() && valor.doubleValue() <= fim.doubleValue();
    }

    public static final BigDecimal multiplica(final BigDecimal... valores) {
        return multiplica(asList(valores));
    }

    public static BigDecimal multiplica(final Iterable<BigDecimal> valores) {
        BigDecimal total = ONE;
        for (final BigDecimal valor : valores) {
            total = total.multiply(valor == null ? ONE : valor);
        }
        return total;
    }

    public static final BigDecimal soma(final BigDecimal... valores) {
        return soma(asList(valores));
    }

    public static final BigDecimal soma(final Iterable<BigDecimal> valores) {
        BigDecimal total = ZERO;
        for (final BigDecimal valor : valores) {
            total = total.add(valor == null ? ZERO : valor);
        }
        return total;
    }

    public static BigDecimal subtrai(final BigDecimal... valores) {
        return subtrai(asList(valores));
    }

    public static BigDecimal subtrai(final List<BigDecimal> valores) {
        BigDecimal primeiro = ZERO.add(valores.get(0));
        for (int atual = 1, maximo = valores.size(); atual < maximo; atual++) {
            primeiro = primeiro.subtract(ConfirmaQue.ehNulo(valores.get(atual)) ? ZERO : valores.get(atual));
        }
        return primeiro;
    }

    public static Long asLong(String valor) {
        try {
            return new Long(valor);
        } catch (NumberFormatException erro) {
            return null;
        }
    }

    public static List<Integer> geraInteirosDeXAtehY(Integer x, Integer y)  {
        return geraInteirosDeXAtehY(x, y, 1);
    }

    public static List<Integer> geraInteirosDeXAtehY(Integer x, Integer y, Integer incremento)  {
        GaranteQue.naoEhNulo(x);
        GaranteQue.naoEhNulo(y);
        List<Integer> gerados = new ArrayList<Integer>();
        for (Integer i = x; i <= y; i = i + incremento) {
            gerados.add(i);
        }
        return gerados;
    }

}
