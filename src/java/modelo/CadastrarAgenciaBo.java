
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarAgenciaBo {
    
    public void cadastrar(Agencia agencia){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().adicionar(agencia);
    }
}
