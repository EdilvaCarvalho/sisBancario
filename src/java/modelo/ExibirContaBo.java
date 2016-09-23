
package modelo;

import entidades.Conta;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExibirContaBo {
    
    public Conta exibir(String numeroConta){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().getConta(numeroConta);
    }
}
