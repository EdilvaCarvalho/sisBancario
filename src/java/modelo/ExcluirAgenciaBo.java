
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExcluirAgenciaBo {
    
    public void excluir(Agencia agencia){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().remover(agencia.getNumero());
    }
}
