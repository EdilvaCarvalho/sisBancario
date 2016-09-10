
package commands;

import excecoes.EmailExistenteException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ExcluirUsuarioBo;

/**
 *
 * @author Edilva
 */
public class RemoverUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        String cpf = request.getParameter("cpf");
        ExcluirUsuarioBo remover = new ExcluirUsuarioBo();
        request.setAttribute("pagina", "listarUsuarios.jsp");
        try {
            if(remover.excluir(cpf)){
                request.setAttribute("mensagem", "Usuário removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Usuário não foi removido!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (EmailExistenteException | ServletException | IOException ex) {
            Logger.getLogger(RemoverUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
