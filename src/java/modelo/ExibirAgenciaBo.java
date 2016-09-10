
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class ExibirAgenciaBo {
    
    public Agencia exibir(String numero){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().agenciaPorNumero(numero);
    }
}
