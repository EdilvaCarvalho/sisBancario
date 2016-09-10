package commands;

import entidades.Conta;
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
import modelo.AbrirConta;
import modelo.ExibirUsuarioBo;

/**
 *
 * @author Edilva
 */
public class CadastrarConta implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("agencia") != null) {
            Conta conta = dadosDaConta(request);
            AbrirConta abrirConta = new AbrirConta();
            String agencia = request.getParameter("agencia");
            request.setAttribute("pagina", "cadastroConta.jsp");
            if (!abrirConta.cadastrar(conta, agencia)) {
                try {
                    request.setAttribute("mensagem", "Erro ao abrir da conta!");
                    request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    request.setAttribute("mensagem", "Conta aberta com sucesso!");
                    request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private Conta dadosDaConta(HttpServletRequest request) {
        Conta conta = new Conta();

        if (request.getParameter("numeroConta") != null) {
            String numeroConta = request.getParameter("numeroConta");
            conta.setNumero(numeroConta);
        }

        if (request.getParameter("dataAbertura") != null) {
            LocalDate dataAbertura = LocalDate.parse(request.getParameter("dataAbertura"));
            conta.setDataAbertura(dataAbertura);
        }

        if (request.getParameter("saldo") != null) {
            double saldo = Double.parseDouble(request.getParameter("saldo"));
            conta.setSaldo(saldo);
        }
        
        String[] titular = request.getParameterValues("cpf");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(titular));
        
        List<Usuario> listaUser = new ArrayList<>();
        ExibirUsuarioBo user = new ExibirUsuarioBo();
        for (String u : lista) {
            listaUser.add(user.exibir(u));  
        }
        conta.setTitulares(listaUser);

        return conta;
    }

}
