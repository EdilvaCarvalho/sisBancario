
package modelo;

import fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class AdicionarTitulares {
    
    public void adicionar(List<String> cpfTitular, String numeroConta){
        DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().adicionaTitulares(cpfTitular, numeroConta);
    }
}
