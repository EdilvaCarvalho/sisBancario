
package modelo;

import entidades.Usuario;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExibirUsuarioBo {
    
    public Usuario exibir(String cpf){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().getUsuario(cpf);
    }
}
