package commands;

import entidades.Agencia;
import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.AgenciaPorGerente;

/**
 *
 * @author Edilva
 */
public class Filtrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        Usuario gerente = (Usuario) sessao.getAttribute("usuario");
        AgenciaPorGerente a = new AgenciaPorGerente();
        Agencia agencia = a.exibir(gerente.getCpf());
        
        double valor1 = Double.parseDouble(request.getParameter("valor1"));
        double valor2 = Double.parseDouble(request.getParameter("valor2"));

        if (valor1 > valor2) {
            double k = valor1;
            valor1 = valor2;
            valor2 = k;
        }

        try {
            sessao.setAttribute("valor1", valor1);
            sessao.setAttribute("valor2", valor2);
            sessao.setAttribute("agencia", agencia);
            request.getRequestDispatcher("contasFiltradas.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Filtrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
