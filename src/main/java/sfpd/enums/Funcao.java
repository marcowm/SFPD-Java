/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfpd.enums;

/**
 *
 * @author F5115716
 *
 *         inserir funcao nova também na classe BuscaFuncoes;
 */
public enum Funcao {
	SOMA("SOMA",NumeroCamposDaFuncao.Infinito, true), 
	REGEX("REGEX",NumeroCamposDaFuncao.TRES, true),
	DIVIDIR("DIVIDIR",NumeroCamposDaFuncao.QUATRO, true), // O QUARTO CAMPO É O FORMATO E NÃO É OBRIGATORIO O USO
	GETVALOR("GETVALOR",NumeroCamposDaFuncao.Infinito, false), 
	IDENTIFICADORRW("IDENTIFICADORRW",NumeroCamposDaFuncao.UM, false),
	REFERENCIAIDRW("REFERENCIAIDRW",NumeroCamposDaFuncao.Infinito, false), 
	COMPOSICAONOME("COMPOSICAONOME",NumeroCamposDaFuncao.Infinito, false),
	MULTIPLICAR("MULTIPLICAR",NumeroCamposDaFuncao.Infinito, true), // ultimo campo deve ser a escala ou se informado formato deve ser o penultimo campo
	MATHEVAL("MATHEVAL",NumeroCamposDaFuncao.Infinito, false), 
	HISTORICO("HISTORICO",NumeroCamposDaFuncao.Infinito, false),
	CURVA("CURVA",NumeroCamposDaFuncao.Infinito, false),
	DIASCORRIDOS("DIASCORRIDOS",NumeroCamposDaFuncao.TRES, false),
	DIASATEPRIMEIRODIAUTIL("DIASATEPRIMEIRODIAUTIL",NumeroCamposDaFuncao.Infinito, false);

    private String nomeFuncao;
	private NumeroCamposDaFuncao quantidadeCampos;
	private boolean usaOuNaoFormato;

	private Funcao(String nome, NumeroCamposDaFuncao qtde, boolean usaOuNao) {
		this.nomeFuncao = nome;
		this.quantidadeCampos = qtde;
		this.usaOuNaoFormato = usaOuNao;
	}
	public String getNomeFuncao() {
		return nomeFuncao;
	}
	public NumeroCamposDaFuncao getQuantidadeCampos() {
		return quantidadeCampos;
	}
	public boolean getUsaOuNaoFormato() {
		return usaOuNaoFormato;
	}
}
