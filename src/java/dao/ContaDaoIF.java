/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Conta;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ContaDaoIF {
    
    public boolean adicionar(Conta conta, String agencia);
    
    public boolean remover(String numero_conta);
    
    public void adicionaTitulares(List<String> cpfTitular, String numeroConta);
    
}
