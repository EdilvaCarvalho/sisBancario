
package dao;

import entidades.Agencia;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AgenciaDaoIF {
    
    public void adicionar(Agencia agencia);
    
    public void adicionaGerentes(String numeroAgencia, String gerente);
    
    public void remover(String numero_agencia);
    
    public Agencia agenciaPorNumero(String numero_agencia);
    
    public List<Agencia> listar();
}
