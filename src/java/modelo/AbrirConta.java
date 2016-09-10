
package modelo;

import entidades.Conta;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AbrirConta {
    
    public boolean cadastrar(Conta conta, String agencia){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().adicionar(conta, agencia);
    }
}
