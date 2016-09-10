
package modelo;

import entidades.Usuario;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarUsuarioBo {
    
    public boolean cadastrar(Usuario usuario){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().adicionar(usuario);
    }
}
