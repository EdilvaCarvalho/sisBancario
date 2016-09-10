
package commands;

import entidades.TipoUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ExibirUsuarioBo;

/**
 *
 * @author Edilva
 */
public class ExibirUsuario implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        String cpf = request.getParameter("cpf");
        ExibirUsuarioBo exibi = new ExibirUsuarioBo();
        Usuario user = exibi.exibir(cpf);
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        try {
            if(user != null){
                request.setAttribute("user", user);
                if(usuario.getTipo() == TipoUsuario.ADMINISTRADOR){
                    request.setAttribute("pagina", "listarUsuarios.jsp");
                    request.getRequestDispatcher("detalhesDoUsuario.jsp").forward(request, response);
                }else{
                    request.setAttribute("pagina", "listarClientes.jsp");
                    request.getRequestDispatcher("detalhesDoCliente.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("mensagem", "Não encontrado!");
                if(usuario.getTipo() == TipoUsuario.ADMINISTRADOR){
                    request.setAttribute("pagina", "listarUsuarios.jsp");
                }else{
                    request.setAttribute("pagina", "listarClientes.jsp");
                }
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
