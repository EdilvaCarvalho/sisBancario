
package dao;

import entidades.MovimentacaoFinanceira;

/**
 *
 * @author Edilva
 */
public interface MovimentacaoFinanceiraDaoIF {
    
    public boolean adicionar(MovimentacaoFinanceira movimentacao);
    
    public boolean remover(int id);
    
}
