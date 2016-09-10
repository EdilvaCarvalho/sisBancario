
package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ExcluirAgenciaBo;

/**
 *
 * @author Edilva
 */
public class RemoverAgencia implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String numAgencia = request.getParameter("numero");
        ExcluirAgenciaBo remover = new ExcluirAgenciaBo();
        request.setAttribute("pagina", "listarAgencias.jsp");
        try {
            if(remover.excluir(numAgencia)){
                request.setAttribute("mensagem", "Agência removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Agência não pode ser removida!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RemoverAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
