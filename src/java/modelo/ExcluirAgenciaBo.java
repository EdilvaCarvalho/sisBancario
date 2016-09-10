
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExcluirAgenciaBo {
    
    public boolean excluir(String numAgencia){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().remover(numAgencia);
    }
}
