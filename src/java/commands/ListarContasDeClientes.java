/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import entidades.Conta;
import entidades.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ListarContasBo;

/**
 *
 * @author Edilva
 */
public class ListarContasDeClientes implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        ListarContasBo a = new ListarContasBo();
        List<Conta> listaDeContas = a.listarContasDoCliente(usuario.getCpf());
        
        sessao.setAttribute("listaDeContas", listaDeContas);
        try {
            request.getRequestDispatcher("contasDoCliente.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListarContasDeClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
