
package dao;

import entidades.MovimentacaoFinanceira;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface MovimentacaoFinanceiraDaoIF {
    
    public boolean adicionar(MovimentacaoFinanceira movimentacao);
    
    public boolean remover(int id);
    
    public List<MovimentacaoFinanceira> listar(String numeroConta);
    
}
