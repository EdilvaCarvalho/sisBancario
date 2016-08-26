
package modelo;

import entidades.Usuario;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class CadastrarUsuarioBo {
    
    public void cadastrar(Usuario usuario){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().adicionar(usuario);
    }
}
