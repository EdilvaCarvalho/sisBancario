/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import entidades.Conta;
import entidades.MovimentacaoFinanceira;
import entidades.TipoMovimentacao;
import entidades.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ExibirContaBo;
import modelo.ExibirUsuarioBo;

/**
 *
 * @author Edilva
 */
public class MovimentacaoFinanceiraDao implements MovimentacaoFinanceiraDaoIF {

    private Conexao conn = new Conexao();

    public MovimentacaoFinanceiraDao() {
    }

    @Override
    public boolean adicionar(MovimentacaoFinanceira movimentacao) {
        boolean resultado = false;
        PreparedStatement ps;

        try {
            conn.conecta();

            String sql = "INSERT INTO MOVIMENTACAO_FINANCEIRA (DATA, HORA, TIPO, VALOR) VALUES (?, ?, ?, ?)";
            ps = conn.con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(movimentacao.getData()));
            ps.setTime(2, Time.valueOf(movimentacao.getHora()));
            ps.setString(3, movimentacao.getTipo().name());
            ps.setDouble(4, movimentacao.getValor());

            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    movimentacao.setId(rs.getInt("ID"));
                }
                String sql2 = "INSERT INTO REALIZA_MOVIMENTACAO (ID_MOVIMENTACAO, NUMERO_CONTA, CPF_TITULAR) VALUES (?, ?, ?)";
                ps = conn.con.prepareStatement(sql2);
                ps.setInt(1, movimentacao.getId());
                ps.setString(2, movimentacao.getConta().getNumero());
                ps.setString(3, movimentacao.getTitular().getCpf());

                if (ps.executeUpdate() > 0) {
                    String sql3 = "UPDATE CONTA SET SALDO = " + movimentacao.getConta().getSaldo() + " WHERE NUMERO_CONTA = ?";
                    ps = conn.con.prepareStatement(sql3);
                    ps.setString(1, movimentacao.getConta().getNumero());
                    if(ps.executeUpdate() > 0){
                        resultado = true;
                    } 
                }

            }

            ps.close();

        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(MovimentacaoFinanceiraDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }

        return resultado;
    }

    @Override
    public boolean remover(int id) {
        boolean resultado = false;
        PreparedStatement ps;

        try {
            conn.conecta();

            String sql = "DELETE FROM MOVIMENTACAO_FINANCEIRA WHERE ID = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MovimentacaoFinanceiraDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconecta();
        }

        return resultado;
    }

    @Override
    public List<MovimentacaoFinanceira> listar(String numeroConta){
        PreparedStatement ps;
        List<MovimentacaoFinanceira> lista = new ArrayList<>();

        try {
            conn.conecta();
            String sql = "SELECT * FROM ((MOVIMENTACAO_FINANCEIRA M JOIN REALIZA_MOVIMENTACAO R ON "
                    + "M.ID = R.ID_MOVIMENTACAO) JOIN USUARIO U ON R.CPF_TITULAR = U.CPF) "
                    + "WHERE R.NUMERO_CONTA = ?";
            ps = conn.con.prepareStatement(sql);
            ps.setString(1, numeroConta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(dadosDaMovimentacao(rs));
            }
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(MovimentacaoFinanceiraDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.desconecta();
        }
        return lista;
    }
    
    private MovimentacaoFinanceira dadosDaMovimentacao(ResultSet rs) throws SQLException {

        int id = rs.getInt("ID");
        LocalDate data = rs.getDate("DATA").toLocalDate();
        LocalTime hora = rs.getTime("HORA").toLocalTime();
        String tipo = rs.getString("TIPO");
        TipoMovimentacao tipoMovim = TipoMovimentacao.valueOf(tipo);
        double valor = rs.getDouble("VALOR");
        ExibirUsuarioBo user = new ExibirUsuarioBo();
        Usuario titular = user.exibir(rs.getString("CPF_TITULAR"));
        ExibirContaBo c = new ExibirContaBo();
        Conta conta = c.exibir(rs.getString("NUMERO_CONTA"));
        
        MovimentacaoFinanceira m = new MovimentacaoFinanceira(id, data, hora, tipoMovim, valor, conta, titular);

        return m;

    }
}
