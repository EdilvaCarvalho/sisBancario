
package modelo;

import entidades.Conta;
import fabrica.DaoFactory;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class ListarContasBo {
    
    public List<Conta> listar(){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().listar();
    }
    
    public List<Conta> listarContasDoCliente(String cpfTitular){
        return DaoFactory.createFactory(DaoFactory.DAO_BD).criaConta().contasDoCliente(cpfTitular);
    }
}
