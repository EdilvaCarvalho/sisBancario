
package commands;

import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.AutenticarUsuario;

/**
 *
 * @author Edilva
 */
public class Autenticar implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessao = request.getSession();
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        AutenticarUsuario autentica = new AutenticarUsuario();
        Usuario usuario = autentica.autenticar(email, senha);
        
        
        if (usuario == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Email ou senha incorretos!");
                request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("usuario", usuario);
            try {
                switch(usuario.getTipo()){
                    case CLIENTE: request.getRequestDispatcher("paginaDoCliente.jsp").forward(request, response);
                    case ADMINISTRADOR: request.getRequestDispatcher("paginaDoAdministrador.jsp").forward(request, response);
                    case GERENTE_DE_AGENCIA: request.getRequestDispatcher("paginaDoGerenteDeAgencia.jsp").forward(request, response);
                    case GERENTE_GERAL_DO_BANCO: request.getRequestDispatcher("paginaDoGerenteGeral.jsp").forward(request, response);
                }
            } catch (ServletException | IOException ex) {
                Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
