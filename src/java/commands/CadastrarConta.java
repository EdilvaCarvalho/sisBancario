package commands;

import entidades.Conta;
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
import modelo.AbrirConta;
import modelo.AdicionarTitulares;

/**
 *
 * @author Edilva
 */
public class CadastrarConta implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        Conta conta = null;
        if (request.getParameter("agencia") != null) {
            conta = dadosDaConta(request);
            AbrirConta abrirConta = new AbrirConta();
            AdicionarTitulares add = new AdicionarTitulares();
            String agencia = request.getParameter("agencia");
            String numConta = request.getParameter("numeroConta");
            abrirConta.cadastrar(conta, agencia);
            List<String> listaTitulares = listaDeTitulares(request);
            add.adicionar(listaTitulares, numConta);
        }
        if (conta == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Erro ao abrir da conta!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("conta", conta);
            try {
                request.setAttribute("mensagem", "Conta aberta com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarConta.class.getName()).log(Level.SEVERE, null, ex);
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

        return conta;
    }

    private List<String> listaDeTitulares(HttpServletRequest request) {
        String[] titular = request.getParameterValues("titular");
        List<String> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(titular));
        return lista;
    }
}
