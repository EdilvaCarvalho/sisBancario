/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class Conexao {
    private final String url = "jdbc:postgresql://localhost:5432/SistemaBancario";
    private final String user = "postgres";
    private final String password = "postgres";
    private final String driver = "org.postgresql.Driver";
    public Connection con;

    public void conecta() throws ClassNotFoundException{
        try {
            System.setProperty("jdbc.Drivers", driver);
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao se comunicar com o banco de dados:\n" + e);
        }    
    }
    
    public void desconecta(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao se comunicar com o banco de dados:\n" + ex);
        }
    }
    
}
