
package modelo;

import entidades.Agencia;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AgenciaPorGerente {
    
    public Agencia exibir(String cpfGerente){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaAgencia().agenciaPorGerente(cpfGerente);
    }
}
