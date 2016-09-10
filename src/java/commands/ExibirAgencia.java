
package commands;

import entidades.Agencia;
import entidades.TipoUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ExibirAgenciaBo;

/**
 *
 * @author Edilva
 */
public class ExibirAgencia implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        String numero = request.getParameter("numero");
        ExibirAgenciaBo exibir = new ExibirAgenciaBo();
        Agencia agencia = exibir.exibir(numero);
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        try {
            if(agencia != null){
                request.setAttribute("agencia", agencia);
                if(usuario.getTipo() == TipoUsuario.ADMINISTRADOR){
                    request.setAttribute("pagina", "listarAgencia.jsp");
                    request.getRequestDispatcher("detalhesDaAgencia.jsp").forward(request, response);
                }else{
                    request.setAttribute("pagina", "listarAgencias2.jsp");
                    request.getRequestDispatcher("detalhesDaAgencia2.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("mensagem", "Erro ao exibir detalhes da agência!");
                if(usuario.getTipo() == TipoUsuario.ADMINISTRADOR){
                    request.setAttribute("pagina", "listarAgencia.jsp");
                }else{
                    request.setAttribute("pagina", "listarAgencias2.jsp");
                }
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
