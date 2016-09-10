
package modelo;

import excecoes.EmailExistenteException;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExcluirUsuarioBo {
    
    public boolean excluir(String cpf) throws EmailExistenteException{
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaUsuario().remover(cpf);
    }
}
