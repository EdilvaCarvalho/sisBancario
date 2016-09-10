
package dao;

import entidades.Agencia;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AgenciaDaoIF {
    
    public boolean adicionar(Agencia agencia);
    
    public void adicionaGerentes(String numeroAgencia, String gerente);
    
    public boolean remover(String numero_agencia);
    
    public Agencia agenciaPorNumero(String numero_agencia);
    
    public Agencia agenciaPorGerente(String cpfGerente);
    
    public List<Agencia> listar();
}
