package sfpd.pojo;

import sfpd.enums.FlagChave;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AtributoPOJO {

    private List<FlagChave> flags = null;

    private String cabecalho;

    private Object valor;

    private Object valorPadrao;

    private String valorComAspas;

    private Boolean chave;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public AtributoPOJO(List<FlagChave> flags, String cabecalho, Object valor, Object valorPadrao) {
        this.flags = flags;
        this.cabecalho = cabecalho;
        this.valor = valor;
        this.valorPadrao = valorPadrao;
    }

    public List<FlagChave> getFlags() {
        return flags;
    }

    public void setFlags(List<FlagChave> flags) {
        this.flags = flags;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Object getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(Object valorPadrao) {
        this.valorPadrao = valorPadrao;
    }

    public String getValorComAspas() {
        return valorComAspas;
    }

    public void setValorComAspas(String valorComAspas) {
        this.valorComAspas = valorComAspas;
    }

    public Boolean getChave() {
        return chave;
    }

    public void setChave(Boolean chave) {
        this.chave = chave;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public boolean containsFlag(FlagChave flag) {
        return Optional.ofNullable(flags).filter(f -> {
            return f.contains(flag);
        }).isPresent();
    }

    public boolean isChave() {
        return Optional.ofNullable(flags).filter(f -> {
            return f.contains(FlagChave.CHAVE);
        }).isPresent();
    }
    public String getValor(int nlinha) {
        String valor = valorPadraoPrimeiraLinha(nlinha);
        valor = primeiraLinha(nlinha, valor);
        valor = comAspas(valor);
        return valor;
    }


    private String valorPadraoPrimeiraLinha(int nlinha) {
        if (this.containsFlag(FlagChave.DEFAULT_PRIMEIRA_LINHA) && nlinha == 1) {
            return String.valueOf(this.getValorPadrao());
        }
        return String.valueOf(this.getValor());

    }

    private String comAspas(String valor) {
        if (this.containsFlag(FlagChave.COLOCA_ASPAS)) valor = "\"" + valor + "\"";
        return valor;
    }

    private String primeiraLinha(int nlinha, String valor) {
        if ((this.containsFlag(FlagChave.APENAS_PRIMEIRA_LINHA) && nlinha == 1) || !this.containsFlag(FlagChave.APENAS_PRIMEIRA_LINHA)) {
            return valor;
        }
        return "";
    }
}
