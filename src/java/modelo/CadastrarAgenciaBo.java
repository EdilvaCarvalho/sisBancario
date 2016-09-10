
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarAgenciaBo {
    
    public boolean cadastrar(Agencia agencia){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().adicionar(agencia);
    }
}
