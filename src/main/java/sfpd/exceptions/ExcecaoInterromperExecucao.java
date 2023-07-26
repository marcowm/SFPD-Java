/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sfpd.exceptions;

/**
 *
 * @author F5115716 
 * @since Jan 15, 2018 
 */
public class ExcecaoInterromperExecucao extends Exception{

    private static final long serialVersionUID = 1L;

    ExcecaoInterromperExecucao(Exception e) {
        super(e);
    }

    public ExcecaoInterromperExecucao(String message) {
        super(message);
    }
    
    

}
