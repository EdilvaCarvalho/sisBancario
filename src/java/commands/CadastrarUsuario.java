
package commands;

import entidades.Endereco;
import entidades.TipoUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.AdicionaGerente;
import modelo.CadastrarUsuarioBo;

/**
 *
 * @author Edilva
 */
public class CadastrarUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        Usuario usuario = dadosDoUsuario(request);
        CadastrarUsuarioBo cadastro = new CadastrarUsuarioBo();
        cadastro.cadastrar(usuario);
        if (usuario.getTipo() == TipoUsuario.GERENTE_DE_AGENCIA) {
            String numeroAgencia = request.getParameter("agencia");
            String cpf = request.getParameter("cpf");
            AdicionaGerente gerente = new AdicionaGerente();
            gerente.adicionar(numeroAgencia, cpf);
        }
        
        if (usuario == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro ao cadastrar usuário!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("usuario", usuario);
            try {
                request.setAttribute("mensagem", "Usuário cadastrado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Usuario dadosDoUsuario(HttpServletRequest request) {
        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            usuario.setNome(nome);
        }
        
        if (request.getParameter("data") != null) {
            LocalDate dataNasc = LocalDate.parse(request.getParameter("data"));
            usuario.setDataNasc(dataNasc);
        }
        
        if (request.getParameter("rg") != null) {
            String rg = request.getParameter("rg");
            usuario.setRg(rg);
        }
        
        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            usuario.setCpf(cpf);
        }
        
        if (request.getParameter("estado") != null) {
            String estado = request.getParameter("estado");
            endereco.setEstado(estado);
        }
        
        if (request.getParameter("cidade") != null) {
            String cidade = request.getParameter("cidade");
            endereco.setCidade(cidade);
        }
        
        if (request.getParameter("bairro") != null) {
            String bairro = request.getParameter("bairro");
            endereco.setBairro(bairro);
        }
        
        if (request.getParameter("rua") != null) {
            String rua = request.getParameter("rua");
            endereco.setRua(rua);
        }
        
        if (request.getParameter("numero") != null) {
            String numero = request.getParameter("numero");
            endereco.setNumero(numero);
        }
        
        if (request.getParameter("tipo") != null) {
            TipoUsuario tipo = TipoUsuario.valueOf(request.getParameter("tipo"));
            usuario.setTipo(tipo);
        }
        
        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            usuario.setEmail(email);
        }
        
        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            usuario.setSenha(senha);
        }
        
        usuario.setFoto("foto");
        
        String[] telefones = request.getParameterValues("telefone");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        usuario.setEndereco(endereco);
        usuario.setTelefones(lista);
        
        return usuario;
    }
    
}
