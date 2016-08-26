
package modelo;

import entidades.Usuario;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AutenticarUsuario {
    
    public Usuario autenticar(String email, String senha){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().autenticar(email, senha);
    }
}
