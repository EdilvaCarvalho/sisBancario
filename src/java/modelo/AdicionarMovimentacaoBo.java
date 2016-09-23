
package modelo;

import entidades.MovimentacaoFinanceira;
import fabrica.DaoFactory;

/**
 *
 * @author Edilva
 */
public class AdicionarMovimentacaoBo {
    
    public boolean adicionar(MovimentacaoFinanceira movimentacao){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaMovimentacaoFinaceira().adicionar(movimentacao);
    }
}
