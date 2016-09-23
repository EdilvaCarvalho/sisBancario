package commands;

import entidades.Conta;
import entidades.MovimentacaoFinanceira;
import entidades.TipoMovimentacao;
import entidades.TipoUsuario;
import entidades.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.AdicionarMovimentacaoBo;
import modelo.ExibirContaBo;
import modelo.ExibirUsuarioBo;

/**
 *
 * @author Edilva
 */
public class RealizarMovimentacao implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        MovimentacaoFinanceira movimentacao = dadosDaMovimentacao(request);
        AdicionarMovimentacaoBo adiciona = new AdicionarMovimentacaoBo();
        String tipo = request.getParameter("tipo");
        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("usuario");
        
        if(u.getTipo() == TipoUsuario.ADMINISTRADOR){
            request.setAttribute("pagina", "paginaDoAdministrador.jsp");
        }else{
            request.setAttribute("pagina", "paginaDoCliente.jsp");
        }
        
        if (!adiciona.adicionar(movimentacao)) {
            try {
                request.setAttribute("mensagem", "Erro ao realizar " + tipo);
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RealizarMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (movimentacao.getTipo() == TipoMovimentacao.TRANSFERENCIA) {
                    if (request.getParameter("numeroContaDest") != null) {
                        String numeroConta = request.getParameter("numeroContaDest");
                        ExibirContaBo c = new ExibirContaBo();
                        Conta conta = c.exibir(numeroConta);
                        movimentacao.setConta(conta);
                        movimentacao.setValor(movimentacao.getValor() * (-1));
                        movimentacao.depositar();
                        adiciona.adicionar(movimentacao);
                    }
                }
                request.setAttribute("mensagem", "Sucesso ao realizar " + tipo);
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RealizarMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private MovimentacaoFinanceira dadosDaMovimentacao(HttpServletRequest request) {

        MovimentacaoFinanceira movimentacao = new MovimentacaoFinanceira();

        if (request.getParameter("numeroConta") != null) {
            String numeroConta = request.getParameter("numeroConta");
            ExibirContaBo c = new ExibirContaBo();
            Conta conta = c.exibir(numeroConta);
            movimentacao.setConta(conta);
        }

        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            ExibirUsuarioBo u = new ExibirUsuarioBo();
            Usuario usuario = u.exibir(cpf);
            movimentacao.setTitular(usuario);
        }

        if (request.getParameter("valor") != null) {
            double valor = Double.parseDouble(request.getParameter("valor"));
            movimentacao.setValor(valor);
        }

        movimentacao.setData(LocalDate.now());
        movimentacao.setHora(LocalTime.now());
        
        if (request.getParameter("tipo") != null) {
            String tipo = request.getParameter("tipo");
            switch (tipo) {
                case "saque":
                    movimentacao.setTipo(TipoMovimentacao.SAQUE);
                    movimentacao.sacar();
                    movimentacao.setValor(movimentacao.getValor() * (-1));
                    break;
                case "depósito":
                    movimentacao.setTipo(TipoMovimentacao.DEPOSITO);
                    movimentacao.depositar();
                    break;
                case "transferência":
                    movimentacao.setTipo(TipoMovimentacao.TRANSFERENCIA);
                    movimentacao.sacar();
                    movimentacao.setValor(movimentacao.getValor() * (-1));
                    break;
                default:
                    break;
            }
        }

        return movimentacao;
    }
}
