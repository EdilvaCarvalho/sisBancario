/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Edilva
 */
public class EmailExistenteException extends Exception{

    public EmailExistenteException() {
        super("Já existe um usuário cadastrado com esse email.");
    }
}
