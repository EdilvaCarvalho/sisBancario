
package modelo;

import entidades.Conta;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class FecharConta {
    
    public void excluir(Conta conta){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().remover(conta.getNumero());
    }
}
