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
public enum Constantes {
    ISNOTNULL("ISNOTNULL"),
    ISNULL("ISNULL"),
    ISEMPTY("ISEMPTY");

    public String descricao;

    Constantes(String descricao) {
        this.descricao = descricao;
    }
}
