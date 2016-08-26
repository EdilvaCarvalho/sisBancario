
package fabrica;

import dao.AgenciaDao;
import dao.AgenciaDaoIF;
import dao.ContaDao;
import dao.ContaDaoIF;
import dao.MovimentacaoFinanceiraDao;
import dao.MovimentacaoFinanceiraDaoIF;
import dao.UsuarioDao;
import dao.UsuarioDaoIF;

/**
 *
 * @author Edilva
 */
public class DaoFactoryBD implements DaoFactoryIF{

    @Override
    public UsuarioDaoIF criaUsuario() {
        return new UsuarioDao();
    }

    @Override
    public AgenciaDaoIF criaAgencia() {
        return new AgenciaDao();
    }

    @Override
    public ContaDaoIF criaConta() {
        return new ContaDao();
    }

    @Override
    public MovimentacaoFinanceiraDaoIF criaMovimentacaoFinaceira() {
        return new MovimentacaoFinanceiraDao();
    }
    
}
