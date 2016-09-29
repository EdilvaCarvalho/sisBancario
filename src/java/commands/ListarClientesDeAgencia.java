
package commands;

import entidades.Agencia;
import entidades.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ListarClientesBo;

/**
 *
 * @author Edilva
 */
public class ListarClientesDeAgencia implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        Agencia agencia = (Agencia) sessao.getAttribute("agencia");
        ListarClientesBo listarClientes = new ListarClientesBo();
        List<Usuario> lista = listarClientes.listar(agencia.getNumero());
        
        request.setAttribute("listaClientes", lista);
        try {
            request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListarClientesDeAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
