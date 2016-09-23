
package modelo;

import entidades.MovimentacaoFinanceira;
import fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarMovimentacoesBo {
    
    public List<MovimentacaoFinanceira> listar(String numeroConta){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMovimentacaoFinaceira().listar(numeroConta);
    }
}
