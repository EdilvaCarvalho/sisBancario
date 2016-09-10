
package modelo;

import entidades.Usuario;
import fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarClientesBo {
    
    public List<Usuario> listar(String numeroAgencia){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().listarClientes(numeroAgencia);
    }
}
