
package modelo;

import entidades.Usuario;
import fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarUsuarioBo {
    
    public List<Usuario> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().listar();
    }
        
}
