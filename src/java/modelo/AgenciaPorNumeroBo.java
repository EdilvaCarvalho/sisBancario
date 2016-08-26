/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AgenciaPorNumeroBo {
    
    public Agencia getAgencia(String numero_agencia){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().agenciaPorNumero(numero_agencia);
    }
    
}
