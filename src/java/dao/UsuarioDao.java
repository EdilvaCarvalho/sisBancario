
package dao;

import conexao.Conexao;
import entidades.Endereco;
import entidades.TipoUsuario;
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

/**
 *
 * @author Edilva
 */
public class UsuarioDao implements UsuarioDaoIF{

    private Conexao conn = new Conexao();

    public UsuarioDao() {
        
    }
    
    @Override
    public boolean adicionar(Usuario usuario) {
        boolean resultado = false;
        PreparedStatement ps;
        
        try {
            conn.conecta();
            
            String sql = "INSERT INTO USUARIO (EMAIL, CPF, NOME, RG, DATA_NASC, TIPO, SENHA, ESTADO, CIDADE, "
                + "BAIRRO, RUA, NUMERO, FOTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getRg());
            ps.setDate(5, Date.valueOf(usuario.getDataNasc()));
            ps.setString(6, usuario.getTipo().name());
            ps.setString(7, usuario.getSenha());
            ps.setString(8, usuario.getEndereco().getEstado());
            ps.setString(9, usuario.getEndereco().getCidade());
            ps.setString(10, usuario.getEndereco().getBairro());
            ps.setString(11, usuario.getEndereco().getRua());
            ps.setString(12, usuario.getEndereco().getNumero());
            ps.setString(13, usuario.getFoto());
            
            if (ps.executeUpdate() > 0) {
                resultado = adicionaTelefone(usuario, ps);
            }
            ps.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        
        return resultado;
    }
    
    private boolean adicionaTelefone(Usuario usuario, PreparedStatement ps){
        
        boolean resultado = false;
        
        try {
            String sql = "INSERT INTO TELEFONE_USUARIO (CPF_USUARIO, TELEFONE) VALUES (?, ?)";
            ps = conn.con.prepareStatement(sql);
            for(String tel : usuario.getTelefones()){
                ps.setString(1, usuario.getCpf());
                ps.setString(2, tel);
                resultado = ps.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }

    @Override
    public boolean remover(String cpf) {
        boolean resultado = false;
        PreparedStatement ps;
        
        try {
            conn.conecta();
            
            String sql = "DELETE FROM USUARIO WHERE CPF = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, cpf);
            if(ps.executeUpdate() > 0){
                resultado = true;
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconecta();
        }  
        
        return resultado;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        
        PreparedStatement ps;
        Usuario usuario = null;
        
        try {
            conn.conecta();
            
            String sql = "SELECT * FROM USUARIO WHERE EMAIL = ? AND SENHA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = dadosDoUsuario(rs);
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconecta();
        }
        
        return usuario;
    }
    
    @Override
    public Usuario getUsuario(String cpf) {
        
        PreparedStatement ps;
        Usuario usuario = null;
        
        try {
            conn.conecta();
            
            String sql = "SELECT * FROM USUARIO WHERE CPF = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = dadosDoUsuario(rs);
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconecta();
        }
        
        return usuario;
    }
    
    private List<String> telefonesDoUsuario(String cpf){
        PreparedStatement ps;
        List<String> telefones = new ArrayList();
        
        try {
            conn.conecta();
            String sql = "SELECT * FROM TELEFONE_USUARIO WHERE CPF_USUARIO = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
   
            while (rs.next()) {
                telefones.add(rs.getString("TELEFONE"));
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return telefones;
    }
    
    protected Usuario dadosDoUsuario(ResultSet rs) throws SQLException{
        String cpf = rs.getString("CPF");
        String nome = rs.getString("NOME");
        String rg = rs.getString("RG");
        LocalDate dataNasc = rs.getDate("DATA_NASC").toLocalDate();
        String emailUsuario = rs.getString("EMAIL");
        String tipoUser = rs.getString("TIPO");
        TipoUsuario tipo = TipoUsuario.valueOf(tipoUser);
        String senhaUsuario = rs.getString("SENHA");
        String estado = rs.getString("ESTADO");
        String cidade = rs.getString("CIDADE");
        String bairro = rs.getString("BAIRRO");
        String rua = rs.getString("RUA");
        String numero = rs.getString("NUMERO");
        String foto = rs.getString("FOTO");
                
        List<String> telefones = new ArrayList<>();
        telefones.addAll(telefonesDoUsuario(cpf));
        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        Usuario usuario = new Usuario(cpf, nome, rg, dataNasc, emailUsuario, tipo, senhaUsuario, endereco, telefones, foto);
                
        return usuario;

    }

    @Override
    public List<Usuario> listar() {
        PreparedStatement ps;
        List<Usuario> lista = new ArrayList<>();
        
        try {
            conn.conecta();
            String sql = "SELECT * FROM USUARIO";
            ps = conn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDoUsuario(rs));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }
    
    public List<Usuario> listarClientes(String agencia){
        PreparedStatement ps;
        List<Usuario> lista = new ArrayList<>();
        
        try {
            conn.conecta();
            String sql = "SELECT * FROM ((USUARIO U JOIN TITULAR_CONTA T ON U.CPF = T.CPF_TITULAR) "
                    + "JOIN CONTA C ON C.NUMERO_CONTA = T.NUMERO_CONTA) WHERE C.NUMERO_AGENCIA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, agencia);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDoUsuario(rs));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }
}
