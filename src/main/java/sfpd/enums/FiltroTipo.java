/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package sfpd.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author F5115716
 */

public enum FiltroTipo {

	FUNDO_MERCADOFINANCEIRO(0,"FUNDO_MERCADOFINANCEIRO","br.com.bbdtvm.risco.mercadofinanceiro.Fundo"), // 0
	POSICAO_MERCADOFINANCEIRO(1,"POSICAO_MERCADOFINANCEIRO","br.com.bbdtvm.risco.mercadofinanceiro.Posicao"), // 1
	INSTRUMENTOACAO_MERCADOFINANCEIRO(2,"INSTRUMENTOACAO_MERCADOFINANCEIRO", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoAcao"), // 2
	INSTRUMENTO_MERCADOFINANCEIRO(3,"INSTRUMENTO_MERCADOFINANCEIRO", "br.com.bbdtvm.risco.mercadofinanceiro.Instrumento"), // 3
	INSTRUMENTO_LETRAFINANCEIRA(4,"INSTRUMENTO_LETRAFINANCEIRA", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoLetraFinanceira"), // 4
	INSTRUMENTO_LFT(5,"INSTRUMENTO_LFT", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoLft"), // 5
	INSTRUMENTO_NTNB(6,"INSTRUMENTO_NTNB", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoNtnB"), // 6
	INSTRUMENTO_NTNC(7,"INSTRUMENTO_NTNC", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoNtnC"), // 7
	INSTRUMENTO_NTNF(8,"INSTRUMENTO_NTNF", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoNtnF"), // 8
	INSTRUMENTO_COMPROMISSADALONGA(9,"INSTRUMENTO_COMPROMISSADALONGA", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCompromissadaLonga"), // 9
	INSTRUMENTO_COMPROMISSADA1D(10,"INSTRUMENTO_COMPROMISSADA1D", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCompromissada1D"), // 10
	INSTRUMENTO_CDB(11,"INSTRUMENTO_CDB", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCDB"), // 11
	INSTRUMENTO_OPCAOACAO(12,"INSTRUMENTO_OPCAOACAO", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoOpcaoAcao"), // 12
	INSTRUMENTO_FUTUROINDICE(13,"INSTRUMENTO_FUTUROINDICE", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoFuturoIndice"), // 13
	INSTRUMENTO_FUTUROMOEDA(14,"INSTRUMENTO_FUTUROMOEDA", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoFuturoMoeda"), // 14
	INSTRUMENTO_OPCAOINDICE(15,"INSTRUMENTO_OPCAOINDICE", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoOpcaoIndice"), // 15
	INSTRUMENTO_ACAO(16,"INSTRUMENTO_ACAO", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoAcao"), // 16 duplicado #TODO remover este
	INSTRUMENTO_FUTUROCUPOMCAMBIAL(17,"INSTRUMENTO_FUTUROCUPOMCAMBIAL", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoFuturoCupomCambial"), // 17
	INSTRUMENTO_OPCAOMOEDA(18,"INSTRUMENTO_OPCAOMOEDA", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoOpcaoMoeda"), // 18
	INDICE(19,"INDICE", "br.com.bbdtvm.risco.mercadofinanceiro.Indice"), // 19
	INSTRUMENTO_BDR(20,"INSTRUMENTO_BDR", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoBdr"), // 20
	INSTRUMENTO_LTN(21,"INSTRUMENTO_LTN", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoLtn"), // 21
	MOEDA(22,"MOEDA", "br.com.bbdtvm.risco.mercadofinanceiro.Moeda"), // 22
	INSTRUMENTO_ACAO_DTO(23,"INSTRUMENTO_ACAO_DTO", "br.com.bbdtvm.risco.mercadofinanceiro.jsonview.InstrumentoAcaoDTO"), // 23
	INSTRUMENTO_DEBENTURE_DTO(24,"INSTRUMENTO_DEBENTURE_DTO", "br.com.bbdtvm.risco.mercadofinanceiro.jsonview.InstrumentoDebentureDTO"), // 24
	Caixa(25,"Caixa", "br.com.bbdtvm.risco.mercadofinanceiro.Caixa"), // 25
	AtivosDiversos(26,"AtivosDiversos", "br.com.bbdtvm.risco.mercadofinanceiro.AtivosDiversos"), // 26
	ContratoCambio(27,"ContratoCambio", "br.com.bbdtvm.risco.mercadofinanceiro.ContratoCambio"), // 27
	TAC(28,"TAC", "br.com.bbdtvm.risco.mercadofinanceiro.TAC"), // 28
	ValoresReceber(29,"ValoresReceber", "br.com.bbdtvm.risco.mercadofinanceiro.ValoresReceber"), // 29
	Instrumento_Adr(30,"Instrumento_Adr", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoAdr"), // 30
	Instrumento_CotaFundoImobiliario(31,"Instrumento_CotaFundoImobiliario", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCotaFundoImobiliario"), // 31
	Instrumento_Etf(32,"Instrumento_Etf", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoEtf"), // 32
	Instrumento_EtfExterior(33,"Instrumento_EtfExterior", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoEtfExterior"), // 33
	Instrumento_CdbComLiquidez(34,"Instrumento_CdbComLiquidez", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCdbComLiquidez"), // 34
	Instrumento_Compromissada(35,"Instrumento_Compromissada", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCompromissada"), // 35
	Instrumento_CreditLinkedNote(36,"Instrumento_CreditLinkedNote", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoCreditLinkedNote"), // 36
	Instrumento_Debenture(37,"Instrumento_Debenture", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoDebenture"), // 37
	Instrumento_Dpge(38,"Instrumento_Dpge", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoDpge"), // 38
	Instrumento_Futuro_Acao(39,"Instrumento_Futuro_Acao", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoFuturoAcao"), // 39
	Instrumento_Futuro_Commodity(40,"Instrumento_Futuro_Commodity", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoFuturoCommodity"), // 40
	Instrumento_Futuro_CupomIndice(41,"Instrumento_Futuro_CupomIndice", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoFuturoCupomIndice"), // 41
	Instrumento_LetraHipotecaria(42,"Instrumento_LetraHipotecaria", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoLetraHipotecaria"), // 42
	Instrumento_NotaPromissoria(43,"Instrumento_NotaPromissoria", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoNotaPromissoria"), // 43
	Instrumento_Ntn(44,"Instrumento_Ntn", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoNtn"), // 44
	Instrumento_Opcao_Commodity(45,"Instrumento_Opcao_Commodity", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoOpcaoCommodity"), // 45
	Instrumento_Opcao_Futuro_Commodity(46,"Instrumento_Opcao_Futuro_Commodity", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoOpcaoFuturoCommodity"), // 46
	Instrumento_Opcao_Futuro_Indice(47,"Instrumento_Opcao_Futuro_Indice", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoOpcaoFuturoIndice"), // 47
	Instrumento_Swap(48,"Instrumento_Swap", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoSwap"), // 48
	Instrumento_TimeDeposit(49,"Instrumento_TimeDeposit", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoTimeDeposit"), // 49
	Instrumento_TituloDivida_Agraria(50,"Instrumento_TituloDivida_Agraria", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoTituloDividaAgraria"), // 50
	Instrumento_TituloDivida_Externa(51,"Instrumento_TituloDivida_Externa", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoTituloDividaExterna"), // 51
	Instrumento_EuroBond(52,"Instrumento_EuroBond", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoEuroBond"), // 52
	Instrumento_GlobalBond(53,"Instrumento_GlobalBond", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoGlobalBond"), // 53
	Instrumento_TreasuryBond(54,"Instrumento_TreasuryBond", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoTreasuryBond"), // 54
	Indice_Data(55,"Indice_Data", "br.com.bbdtvm.risco.mercadofinanceiro.IndiceData"), // 55
	Instrumento_Data(56,"Instrumento_Data", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoData"), // 56
	Instrumento_Acao_Data(57,"Instrumento_Acao_Data", "br.com.bbdtvm.risco.mercadofinanceiro.InstrumentoAcaoData"), // 57
	Moeda_Data(58,"Moeda_Data", "br.com.bbdtvm.risco.mercadofinanceiro.MoedaData"), // 58
	LISTA(59,"LISTA", null); // 59
	private final Integer indice;
	private final String nome;
	private final String path;

	FiltroTipo(int tipoIndice, String tipoNome, String tipoPath) {
		indice = tipoIndice;
		nome = tipoNome;
		path = tipoPath;
	}

	@JsonValue		
	public String getNome() {
		return nome;
	}

	public Integer getIndice() {
		return indice;
	}

	public String getPath() {
		return path;
	}
}
