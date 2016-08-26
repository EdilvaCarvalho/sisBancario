
package modelo;

import entidades.Conta;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AbrirConta {
    
    public void cadastrar(Conta conta, String agencia){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().adicionar(conta, agencia);
    }
}
