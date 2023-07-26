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
public enum Estado {
    Ativo(1),
    Inativo(2);

    private int estado;

    Estado(int e) {
        this.estado = e;
    }
}
