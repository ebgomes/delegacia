package br.com.arquitetura;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Embeddable
@ForceCloneWhenAssign
public class Data implements ComparavelCom<Data>, PodeSerComparadoComUmFaixa<Data>, Serializable, IsCloneable<Data> {

    /**
     * Converte datas de/para XML no formato dd/MM/yyyy kk:mm:ss
     * 
     * @author jose.junior
     * 
     */
    public static final class DefaultXmlAdapter extends javax.xml.bind.annotation.adapters.XmlAdapter<String, Data> {

        @Override
        public String marshal(Data valor) throws Exception {
            return ConfirmaQue.ehNulo(valor) ? null : valor.toString (DateUtils.FORMATO_PADRAO_DATA);
        }

        @Override
        public Data unmarshal(String valor) throws Exception {
            return ConfirmaQue.ehUmaStringNulaOuVazia(valor) ? null : nova(valor, DateUtils.FORMATO_PADRAO_DATA_HORA);
        }

    }

    public static interface Constantes {
        Integer ANTES_DO_MEIO_DIA = Calendar.AM;

        Integer APOS_AO_MEIO_DIA  = Calendar.PM;
    }

    public static final String CONTEUDO         = "conteudo";

    private static final long  serialVersionUID = 1L;

    public static Integer[] recuperaCampos(Data data, CamposDaData... campos) {
        Integer[] retorno = new Integer[campos.length];
        for (int i = 0; i < campos.length; i++) {
            retorno[i] = data.recupera(campos[i]);
        }
        return retorno;
    }

    public static final Data hoje() {
        return new Data(DateUtils.hoje());
    }

    /**
     * 
     * @param dia 1 a 31
     * @param mes 1 a 12
     * @param ano qualquer ano
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Data nova(Integer dia, Integer mes, Integer ano) {
        return new Data(new Date(ano - 1900, mes - 1, dia));
    }

    public static final Data infinito() {
        return new Data(DateUtils.infinito()).comAHoraIgualAMeiaNoite();
    }

    public static final Data nova(final String data) {
        return new Data(DateUtils.nova(data));
    }

    public static final Data nova(final String data, final DateFormat formatador) {
        return new Data(DateUtils.nova(data, formatador));
    }

    /**
     * 
     * @param data dd/MM/aaaa
     * @param hora hh:mm:ss
     * @return nova data / hora
     */
    public static final Data nova(final String data, final String hora) {
        return new Data(DateUtils.nova(data, hora));
    }

    /**
     * 
     * @param data dd/MM/aaaa
     * @param hora hh:mm:ss
     * @return nova data / hora
     */
    public static final Data nova(final String data, final String hora, final DateFormat formatador) {
        return new Data(DateUtils.nova(data, hora, formatador));
    }

    public static Data ontem() {
        return hoje().menos(1, CamposDaData.DIA);
    }

    public static Data primeiroDiaDoMes(final Data atual) {
        return new Data(DateUtils.primeiroDiaDoMes(atual.conteudo));
    }

    public static final Data primeiroDiaDoMesAtual() {
        return primeiroDiaDoMes(hoje());
    }

    public static Data ultimoDiaDoMes(final Data atual) {
        return new Data(DateUtils.ultimoDiaDoMes(atual.conteudo));
    }

    public static final Data ultimoDiaDoMesAtual() {
        return ultimoDiaDoMes(hoje());
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date conteudo;

    public Data() {
        this(DateUtils.hoje());
    }

    public Data(final Date conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public int compareTo(final Data outra) {
        return outra == null || outra.conteudo == null ? 1 : this.conteudo.compareTo(outra.conteudo);
    }

    public Long diasEntreHojeEAData(final Data outra) {
        return DateUtils.diasEntreUmaDataEOutra(this.conteudo, outra.conteudo);
    }

    @Override
    public Boolean ehIgual(final Data outro) {
        return compareTo(outro) == 0;
    }

    @Override
    public Boolean ehMaior(final Data outro) {
        return compareTo(outro) > 0;
    }

    @Override
    public Boolean ehMaiorOuIgual(final Data outro) {
        return ehMaior(outro) || ehIgual(outro);
    }

    @Override
    public Boolean ehMenor(final Data outro) {
        return compareTo(outro) < 0;
    }

    @Override
    public Boolean ehMenorOuIgual(final Data outro) {
        return ehMenor(outro) || ehIgual(outro);
    }

    @Override
    public Boolean estaNaFaixaEntre(final Data menor, final Data maior) {
        return ehMaior(menor) && ehMenor(maior);
    }

    @Override
    public Boolean estaNaFaixaEntre(final Data menor, final Data maior, final Boolean inclusive) {
        if (inclusive == null || !inclusive) {
            return estaNaFaixaEntre(menor, maior);
        }
        return ehMaiorOuIgual(menor) && ehMenorOuIgual(maior);
    }

    public Date getConteudo() {
        return conteudo;
    }

    public Data mais(final Number valor, final CamposDaData campo) {
        return campo.soma(this, valor);
    }

    public Data menos(final Number valor, final CamposDaData campo) {
        return campo.subtrai(this, valor);
    }

    public Integer recupera(final CamposDaData campo) {
        return campo.recupera(this);
    }

    /**
     * Usar apenas com os bindings da DC
     * 
     * @param conteudo
     */
    public void setConteudo(final Date conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isAntesDoMeioDia() {
        return CamposDaData.PERIODO.recupera(this).equals(Constantes.ANTES_DO_MEIO_DIA);
    }

    public boolean isAposAoMeioDia() {
        return CamposDaData.PERIODO.recupera(this).equals(Constantes.APOS_AO_MEIO_DIA);
    }

    @Override
    public String toString() {
        return conteudo.toString();
    }

    public String toString(DateFormat formato) {
        return formato.format(this.conteudo);
    }

    public Data troca(CamposDaData campo, Integer valor) {
        return campo.troca(this, valor);
    }

    public Data clone() {
        return new Data((Date) this.conteudo.clone());
    }

    public void setHora(Integer hora) {
        boolean ehApósAoMeioDia = (hora >= 12);
        this.conteudo = DateUtils.trocaAHora(this.conteudo, ehApósAoMeioDia ? (hora - 12) : hora);
        this.conteudo = DateUtils.trocaOPeriodo(this.conteudo, ehApósAoMeioDia ? Constantes.APOS_AO_MEIO_DIA : Constantes.ANTES_DO_MEIO_DIA);
    }

    public Integer getHora() {
        return DateUtils.recuperaHora(this.conteudo) + (isAposAoMeioDia() ? 12 : 0);
    }

    public void setMinutos(Integer minutos) {
        try {
            GaranteQue.naoEhNulo(minutos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setConteudo(DateUtils.trocaOMinuto(this.conteudo, minutos));
    }

    public Integer getMinutos() {
        return DateUtils.recuperaMinuto(this.conteudo);
    }

    public Data comAHoraIgualAMeiaNoite() {
        return as(23, 59, 59, 999);
    }

    public Data comAHoraIgualAZero() {
        return as(0, 0, 0, 0).troca(CamposDaData.PERIODO, Constantes.ANTES_DO_MEIO_DIA);
    }

    /**
     * Cria uma nova data com o horario especificado
     * 
     * @param hora
     * @param minutos
     * @param segundos
     * @param milisegundos
     * @return nova data com o horario especificado
     */
    public Data as(Integer hora, Integer minutos, Integer segundos, Integer milisegundos) {
        return this.troca(CamposDaData.HORA, hora)
                   .troca(CamposDaData.MINUTOS, minutos)
                   .troca(CamposDaData.SEGUNDOS, segundos)
                   .troca(CamposDaData.MILISEGUNDOS, milisegundos);
    }

    /**
     * Cria uma nova data com o horario especificado
     * 
     * @param hora
     * @param minutos
     * @param segundos
     * @return nova data com o horario especificado
     */
    public Data as(Integer hora, Integer minutos, Integer segundos) {
        return as(hora, minutos, segundos, recupera(CamposDaData.MILISEGUNDOS));
    }

    /**
     * Cria uma nova data com o horario especificado
     * 
     * @param hora
     * @param minutos
     * @return nova data com o horario especificado
     */
    public Data as(Integer hora, Integer minutos) {
        return as(hora, minutos, recupera(CamposDaData.SEGUNDOS));
    }

    public Data comAHoraDa(Data data) {
        return as(data.getHora(), data.getMinutos(), data.recupera(CamposDaData.SEGUNDOS));
    }

    public String porExtenso() {
        return DateUtils.porExtenso(getConteudo());
    }

    public String noFormato(String formato) {
        return porExtensoUsandoO(new SimpleDateFormat(formato));
    }

    public <Formatador extends DateFormat> String porExtensoUsandoO(Formatador formatador) {
        return formatador.format(getConteudo());
    }

    @Override
    public boolean equals(Object objeto) {
        return ConfirmaQue.ehUmTipoDe(Data.class, objeto) ? equals(Data.class.cast(objeto)) : false;
    }

    public boolean equals(Data outra) {
        return new EqualsBuilder().append(this.conteudo, outra.conteudo)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.conteudo).toHashCode();
    }

    public DiaDaSemana getDiaDaSemana() {
        return DiaDaSemana.referente(this);
    }

    public boolean ehDiaDaSemanaUtil() {
        return getDiaDaSemana().ehUtil();
    }

}
