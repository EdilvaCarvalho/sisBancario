
package fabrica;

import dao.AgenciaDaoIF;
import dao.ContaDaoIF;
import dao.MovimentacaoFinanceiraDaoIF;
import dao.UsuarioDaoIF;

/**
 *
 * @author Edilva
 */
public interface DaoFactoryIF {
    
    public UsuarioDaoIF criaUsuario();
    
    public AgenciaDaoIF criaAgencia();
    
    public ContaDaoIF criaConta();
    
    public MovimentacaoFinanceiraDaoIF criaMovimentacaoFinaceira();
}
