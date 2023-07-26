/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfpd.enums;

/**
 *
 * @author F5115716
 */
public enum NumeroCamposDaFuncao {
    Infinito(-1),
    Nenhum(0),
    UM(1),
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5),
    SEIS(6),
    SETE(7),
    OITO(8),
    NOVE(9),
    DEZ(10);

    Integer valor;

    private NumeroCamposDaFuncao(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

}
