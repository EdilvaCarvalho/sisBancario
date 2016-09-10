
package modelo;

import entidades.Conta;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class FecharConta {
    
    public boolean excluir(Conta conta){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().remover(conta.getNumero());
    }
}
