
package modelo;

import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AdicionaGerente {
    
    public void adicionar(String numerAgencia, String gerente){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().adicionaGerentes(numerAgencia, gerente);
    }
    
}
