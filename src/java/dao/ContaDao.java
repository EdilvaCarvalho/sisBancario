
package dao;

import conexao.Conexao;
import entidades.Conta;
import entidades.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class ContaDao implements ContaDaoIF{
    
    private Conexao conn = new Conexao();

    public ContaDao() {
    }

    @Override
    public boolean adicionar(Conta conta, String agencia) {
        
        boolean resultado = false;
        PreparedStatement ps;
        
        try {
            conn.conecta();
            
            String sql = "INSERT INTO CONTA (NUMERO_CONTA, DATA_ABERTURA, SALDO, NUMERO_AGENCIA) VALUES (?, ?, ?, ?)";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, conta.getNumero());
            ps.setDate(2, Date.valueOf(conta.getDataAbertura()));
            ps.setDouble(3, conta.getSaldo());
            ps.setString(4, agencia);
            if(ps.executeUpdate() > 0){
                resultado = adicionaTitulares(conta, ps);
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return resultado;   
    }
    
    private boolean adicionaTitulares(Conta conta, PreparedStatement ps){
        boolean resultado = false;
        
        try {
            String sql2 = "INSERT INTO TITULAR_CONTA (CPF_TITULAR, NUMERO_CONTA) VALUES (?, ?)";
            ps = conn.con.prepareStatement(sql2);
            for(Usuario titular : conta.getTitulares()){
                ps.setString(1, titular.getCpf());
                ps.setString(2, conta.getNumero());
                resultado = ps.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }

    @Override
    public boolean remover(String numero_conta) {
        boolean resultado = false;
        PreparedStatement ps;
        
        try {
            conn.conecta();
            
            String sql = "DELETE FROM CONTA WHERE NUMERO_CONTA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numero_conta);
            if(ps.executeUpdate() > 0){
                resultado = true;
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconecta();
        }
        
        return resultado;
    }

    @Override
    public void adicionaTitulares(List<String> cpfTitular, String numeroConta) {
        PreparedStatement ps;
        
        try {
            conn.conecta();
            String sql = "INSERT INTO TITULAR_CONTA (CPF_TITULAR, NUMERO_CONTA) VALUES (?, ?)";
            ps = conn.con.prepareStatement(sql);
            for(String cpf : cpfTitular){
                ps.setString(1, cpf);
                ps.setString(2, numeroConta);
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn.desconecta();
        }
    }
    
}
