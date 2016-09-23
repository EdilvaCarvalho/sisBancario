
package commands;

import entidades.MovimentacaoFinanceira;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ListarMovimentacoesBo;

/**
 *
 * @author Edilva
 */
public class ListarMovimentacoes implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String numero = request.getParameter("numero");
        ListarMovimentacoesBo m = new ListarMovimentacoesBo();
        List<MovimentacaoFinanceira> listaDeMovimentacoes = m.listar(numero);
        
        request.setAttribute("listaDeMovimentacoes", listaDeMovimentacoes);
        try {
            request.getRequestDispatcher("extrato.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListarMovimentacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
