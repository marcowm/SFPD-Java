package sfpd.enums;

public enum FlagChave {
    CHAVE,
    DEFAULT_PRIMEIRA_LINHA,// pega valor fixo no atribudo e insere na primeira linha depois do cabeçalho
    CONDENSAR_LINHAS,
    APENAS_PRIMEIRA_LINHA,// imprime o valor do atributo apenas na primeira linha
    COLOCA_ASPAS,// coloca aspas no valor
    NAO_INCLUIR_CAMPO;

    @Override
    public String toString() {
        return super.toString();
    }
}
