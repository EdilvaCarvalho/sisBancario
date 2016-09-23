/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.UsuarioDao;
import entidades.Agencia;
import entidades.Conta;
import entidades.Endereco;
import entidades.MovimentacaoFinanceira;
import entidades.TipoMovimentacao;
import entidades.TipoUsuario;
import entidades.Usuario;
import fabrica.DaoFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelo.AbrirConta;
import modelo.AdicionarMovimentacaoBo;
import modelo.AdicionarTitulares;
import modelo.CadastrarUsuarioBo;
import modelo.ExibirAgenciaBo;
import modelo.ExibirContaBo;
import modelo.ExibirUsuarioBo;
import modelo.ListarAgenciaBo;
import modelo.ListarContasBo;
import modelo.ListarMovimentacoesBo;

/**
 *
 * @author Edilva
 */
public class NovoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Endereco endereco = new Endereco("Paraíba", "Souza", "Centro", "bla bla", "19"); List<String> telefones = new ArrayList<>();
//        telefones.add("9945399"); 
//        telefones.add("9111199");
//        telefones.add("9933399"); 
//        Usuario user = new Usuario("556.111.133-11", "Viviane Vieira", "99036",
//        LocalDate.of(1993, Month.APRIL, 23), "vivi@gmail.com",
//        TipoUsuario.GERENTE_DE_AGENCIA, "12345", endereco, telefones, "foto"); CadastrarUsuarioBo cad = new CadastrarUsuarioBo();
//        cad.cadastrar(user);
//        
//        UsuarioDao dao = new UsuarioDao();
//        dao.adicionar(user);

        /**
         * Endereco endereco = new Endereco(); Usuario usuario = new Usuario();
         * CadastrarUsuarioBo cad = new CadastrarUsuarioBo();
        cad.cadastrar(usuario);
         */
        //testes
//        Conta conta = new Conta("2222", LocalDate.now(), 0);
//        AbrirConta abrir = new AbrirConta();
//        abrir.cadastrar(conta, "0011");
//        String[] vet = {"101.326.001-63", "123.322.333-12"};
//        List<String> lista = new ArrayList<>();
//        lista.addAll(Arrays.asList(vet));
//        List<String> lista2 = lista;
//        AdicionarTitulares add = new AdicionarTitulares();
//        add.adicionar(lista2, "2222");
//        String[] vet = {"Edilva", "Edviges", "Eliete", "Eliane", "Eretusa"};
//        
//        System.out.println(Arrays.toString(vet));
//        
//        List<String> lista = new ArrayList<>();
//        lista.addAll(Arrays.asList(vet));
//        
//        System.out.println(lista.toString());
//        ExibirAgenciaBo exibir = new ExibirAgenciaBo();
//        Agencia agencia = exibir.exibir("0099");
//        System.out.println(agencia.toString());
          
//          ExibirContaBo ec = new ExibirContaBo();
//          Conta c = ec.exibir("10001");
//          ExibirUsuarioBo u = new ExibirUsuarioBo();
//          Usuario user = u.exibir("222.111.333-21");
//          MovimentacaoFinanceira m = new MovimentacaoFinanceira(LocalDate.now(), LocalTime.now(), TipoMovimentacao.DEPOSITO, 500, c, user);
//          m.depositar();
//          AdicionarMovimentacaoBo adiciona = new AdicionarMovimentacaoBo();
//          adiciona.adicionar(m);

            ListarMovimentacoesBo lista = new ListarMovimentacoesBo();
            List<MovimentacaoFinanceira> l = lista.listar("10001");
            System.out.println(l);
    }
}
