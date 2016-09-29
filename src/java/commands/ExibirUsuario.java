package commands;

import entidades.Agencia;
import entidades.TipoUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ExibirUsuarioBo;
import modelo.ListarClientesBo;

/**
 *
 * @author Edilva
 */
public class ExibirUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        String cpf = request.getParameter("cpf");
        ExibirUsuarioBo exibi = new ExibirUsuarioBo();
        Usuario user = exibi.exibir(cpf);
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if (user != null) {
                if (usuario.getTipo() == TipoUsuario.ADMINISTRADOR) {
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("detalhesDoUsuario.jsp").forward(request, response);
                } else if (user.getTipo() == TipoUsuario.CLIENTE) {
                    Agencia agencia = (Agencia) sessao.getAttribute("agencia");
                    ListarClientesBo listarClientes = new ListarClientesBo();
                    List<Usuario> lista = listarClientes.listar(agencia.getNumero());

                    if (lista.contains(user)) {
                        request.setAttribute("user", user);
                        request.getRequestDispatcher("detalhesDoCliente.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensagem", "Não encontrado!");
                        request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("mensagem", "Não encontrado!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
