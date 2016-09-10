/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import entidades.MovimentacaoFinanceira;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                movimentacao.setId(rs.getInt("ID"));
            }

            if (ps.executeUpdate() > 0) {
                String sql2 = "INSERT INTO REALIZA_MOVIMENTACAO (ID_MOVIMENTACAO, NUMERO_CONTA, CPF_TITULAR) VALUES (?, ?, ?)";
                ps = conn.con.prepareStatement(sql2);
                ps.setInt(1, movimentacao.getId());
                ps.setString(2, movimentacao.getConta().getNumero());
                ps.setString(3, movimentacao.getTitular().getCpf());

                if (ps.executeUpdate() > 0) {
                    resultado = true;
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

}
