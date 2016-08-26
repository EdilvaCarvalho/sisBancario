
package modelo;

import entidades.Usuario;
import excecoes.EmailExistenteException;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExcluirUsuarioBo {
    
    public void excluir(Usuario usuario) throws EmailExistenteException{
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().remover(usuario.getEmail());
    }
}
