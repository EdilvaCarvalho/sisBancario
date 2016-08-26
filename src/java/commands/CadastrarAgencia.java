
package commands;

import entidades.Agencia;
import entidades.Endereco;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CadastrarAgenciaBo;

/**
 *
 * @author Edilva
 */
public class CadastrarAgencia implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        Agencia agencia = dadosDaAgencia(request);
        CadastrarAgenciaBo cadastro = new CadastrarAgenciaBo();
        cadastro.cadastrar(agencia);
        
        if (agencia == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro ao cadastrar agência!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarAgencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("agencia", agencia);
            try {
                request.setAttribute("mensagem", "Agência cadastrada com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarAgencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Agencia dadosDaAgencia(HttpServletRequest request) {
        Agencia agencia = new Agencia();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            agencia.setNome(nome);
        }
        
        if (request.getParameter("numeroAgencia") != null) {
            String numero = request.getParameter("numeroAgencia");
            agencia.setNumero(numero);
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
        
        String[] telefones = request.getParameterValues("telefone");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(telefones));
        
        agencia.setEndereco(endereco);
        agencia.setTelefones(lista);
        
        return agencia;
    }
    
}
