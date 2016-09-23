
package commands;

import entidades.Conta;
import entidades.TipoUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ExibirContaBo;

/**
 *
 * @author Edilva
 */
public class ExibirConta implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        String numero = request.getParameter("numero");
        ExibirContaBo exibir = new ExibirContaBo();
        Conta conta = exibir.exibir(numero);
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        try {
            if(conta != null){
                request.setAttribute("conta", conta);
                if(null != usuario.getTipo())switch (usuario.getTipo()) {
                    case ADMINISTRADOR:
                        request.getRequestDispatcher("detalhesDaConta.jsp").forward(request, response);
                        break;
                    case GERENTE_GERAL_DO_BANCO:
                        request.getRequestDispatcher("detalhesDaConta2.jsp").forward(request, response);
                        break;
                    case CLIENTE:
                        request.getRequestDispatcher("saldo.jsp").forward(request, response);
                        break;
                    case GERENTE_DE_AGENCIA:
                        request.getRequestDispatcher("detalhesDaConta3.jsp").forward(request, response);
                        break;
                    default:
                        break;
                }
            }else{
                request.setAttribute("mensagem", "Erro ao exibir detalhes da conta!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExibirConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
