
package dao;

import conexao.Conexao;
import entidades.Agencia;
import entidades.Endereco;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class AgenciaDao implements AgenciaDaoIF{

    private Conexao conn = new Conexao();

    public AgenciaDao() {
    }
    
    @Override
    public void adicionar(Agencia agencia) {
        
        PreparedStatement ps;
        
        try {
            conn.conecta();
            
            String sql = "INSERT INTO AGENCIA (NUMERO_AGENCIA, NOME, ESTADO, CIDADE, BAIRRO, RUA, NUMERO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, agencia.getNumero());
            ps.setString(2, agencia.getNome());
            ps.setString(3, agencia.getEndereco().getEstado());
            ps.setString(4, agencia.getEndereco().getCidade());
            ps.setString(5, agencia.getEndereco().getBairro());
            ps.setString(6, agencia.getEndereco().getRua());
            ps.setString(7, agencia.getEndereco().getNumero());
            
            if (ps.executeUpdate() > 0) {
                adicionaTelefones(agencia, ps);
            }
            
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        
    }
    
    private void adicionaTelefones(Agencia agencia, PreparedStatement ps){
        
        try {
            String sql = "INSERT INTO TELEFONE_AGENCIA (NUMERO_AGENCIA, TELEFONE) VALUES (?, ?)";
            ps = conn.con.prepareStatement(sql);
            for(String tel : agencia.getTelefones()){
                ps.setString(1, agencia.getNumero());
                ps.setString(2, tel);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void adicionaGerentes(String numeroAgencia, String gerente){
        
        PreparedStatement ps;
        
        try {
            conn.conecta();
            String sql = "INSERT INTO GERENTE_AGENCIA (NUMERO_AGENCIA, GERENTE) VALUES (?, ?)";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numeroAgencia);
            ps.setString(2, gerente);
            ps.executeUpdate();
            ps.close();
            conn.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(String numero_agencia) {
        PreparedStatement ps;
        
        try {
            conn.conecta();
            
            String sql = "DELETE FROM AGENCIA WHERE NUMERO_AGENCIA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numero_agencia);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconecta();
        } 
    }

    private List<String> telefonesDaAgencia(String numeroAgencia){
        PreparedStatement ps;
        List<String> telefones = new ArrayList();
        
        try {
            String sql = "SELECT * FROM TELEFONE_AGENCIA WHERE NUMERO_AGENCIA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numeroAgencia);
            ResultSet rs = ps.executeQuery();
   
            while (rs.next()) {
                telefones.add(rs.getString("TELEFONE"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return telefones;
    }
    
    private List<Usuario> gerentesDaAgencia(String numeroAgencia){
        PreparedStatement ps;
        List<Usuario> gerentes = new ArrayList();
        UsuarioDao dao = new UsuarioDao();
        try {
            String sql = "SELECT * FROM (GERENTE_AGENCIA G JOIN USUARIO U ON G.GERENTE = U.CPF) "
                    + "WHERE G.NUMERO_AGENCIA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numeroAgencia);
            ResultSet rs = ps.executeQuery();
   
            while (rs.next()) {
                Usuario user = dao.dadosDoUsuario(rs);
                gerentes.add(user);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return gerentes;
    }
    
    private Agencia dadosDaAgencia(ResultSet rs) throws SQLException{
        
        String numeroAgencia = rs.getString("NUMERO_AGENCIA");
        String nome = rs.getString("NOME");
        String estado = rs.getString("ESTADO");
        String cidade = rs.getString("CIDADE");
        String bairro = rs.getString("BAIRRO");
        String rua = rs.getString("RUA");
        String numero = rs.getString("NUMERO");
                
        List<String> telefones = new ArrayList<>();
        telefones.addAll(telefonesDaAgencia(numeroAgencia));
        List<Usuario> gerentes = new ArrayList<>();
        gerentes.addAll(gerentesDaAgencia(numeroAgencia));
        
        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        Agencia agencia = new Agencia(numeroAgencia, nome, endereco, telefones);
                
        return agencia;

    }
    
    
    @Override
    public List<Agencia> listar() {
        PreparedStatement ps;
        List<Agencia> lista = new ArrayList<>();
        
        try {
            conn.conecta();
            String sql = "SELECT * FROM AGENCIA";
            ps = conn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(dadosDaAgencia(rs));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }

    @Override
    public Agencia agenciaPorNumero(String numeroAgencia) {
        PreparedStatement ps;
        Agencia agencia = null;
        try {
            conn.conecta();
            String sql = "SELECT * FROM AGENCIA WHERE NUMERO_AGENCIA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numeroAgencia);
            ResultSet rs = ps.executeQuery();
            agencia = dadosDaAgencia(rs);
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AgenciaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        
        return agencia;
    }
    
}
