
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarAgenciaBo {
    
    public List<Agencia> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().listar();
    }
}
