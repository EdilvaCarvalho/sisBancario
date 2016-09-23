
package dao;

import conexao.Conexao;
import entidades.Agencia;
import entidades.Conta;
import entidades.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AgenciaPorNumeroBo;
import modelo.ExibirUsuarioBo;

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

    @Override
    public List<Conta> listar() {
        PreparedStatement ps;
        List<Conta> lista = new ArrayList<>();

        try {
            conn.conecta();
            String sql = "SELECT * FROM CONTA";
            ps = conn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaConta(rs));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }
    
    private Conta dadosDaConta(ResultSet rs) throws SQLException {

        String numeroConta = rs.getString("NUMERO_CONTA");
        LocalDate dataAbertura = rs.getDate("DATA_ABERTURA").toLocalDate();
        double saldo = rs.getDouble("SALDO");
        String numeroAgencia = rs.getString("NUMERO_AGENCIA");
        
        AgenciaPorNumeroBo a = new AgenciaPorNumeroBo();
        Agencia agencia = a.getAgencia(numeroAgencia);
        List<Usuario> titulares = getTitulares(numeroConta);
        Conta conta = new Conta(numeroConta, dataAbertura, saldo, agencia, titulares);

        return conta;

    }
    
    private List<Usuario> getTitulares(String numConta){
        PreparedStatement ps;
        List<Usuario> lista = new ArrayList<>();

        try {
            conn.conecta();
            String sql = "SELECT * FROM (TITULAR_CONTA T JOIN USUARIO U ON U.CPF = T.CPF_TITULAR) "
                    + "WHERE T.NUMERO_CONTA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numConta);
            ResultSet rs = ps.executeQuery();
            
            ExibirUsuarioBo user = new ExibirUsuarioBo();
            
            while (rs.next()) {
                lista.add(user.exibir(rs.getString("CPF")));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }
    
    @Override
    public List<Conta> contasDoCliente(String cpfTitular) {
        PreparedStatement ps;
        List<Conta> lista = new ArrayList<>();

        try {
            conn.conecta();
            String sql = "SELECT * FROM (CONTA C JOIN TITULAR_CONTA T ON C.NUMERO_CONTA = T.NUMERO_CONTA)"
                    + "WHERE T.CPF_TITULAR = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, cpfTitular);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaConta(rs));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }

    @Override
    public Conta getConta(String numeroConta) {
        PreparedStatement ps;
        Conta conta = null;
        try {
            conn.conecta();
            String sql = "SELECT * FROM CONTA WHERE NUMERO_CONTA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numeroConta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conta = dadosDaConta(rs);
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }

        return conta;
    }
    
}
