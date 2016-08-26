package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidades.Agencia;
import modelo.ListarAgenciaBo;
import java.util.List;

public final class cadastroUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>\n");
      out.write("        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paginaDoAdministrador.jsp", out, false);
      out.write("</div>\n");
      out.write("        <div class=\"container text-center\">\n");
      out.write("            <h1>Dados do usuário</h1>\n");
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\" style=\"width:60%\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <form method=\"post\" id=\"cadastroUsuario\" action=\"Controller?command=CadastrarUsuario\" name=\"formUsuario\">\n");
      out.write("                    <div class=\"form-group col-md-8\">\n");
      out.write("                        <label for=\"nome\">Nome: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nome\" id=\"nome\" autofocus required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-4\">\n");
      out.write("                        <label for=\"data\">Data de nascimento: </label>\n");
      out.write("                        <input type=\"date\" class=\"form-control\" name=\"data\" id=\"data\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"rg\">Registro Geral (RG): </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"rg\" id=\"rg\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"cpf\">CPF: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"cpf\" id=\"cpf\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"estado\">Estado: </label>\n");
      out.write("                        <select class=\"form-control\" name=\"estado\" id=\"estado\">\n");
      out.write("                            <option value=\"AC\">Acre</option>\n");
      out.write("                            <option value=\"AL\">Alagoas</option>\n");
      out.write("                            <option value=\"AM\">Amazonas</option>\n");
      out.write("                            <option value=\"AM\">Amapá</option>\n");
      out.write("                            <option value=\"BA\">Bahia</option>\n");
      out.write("                            <option value=\"DF\">Brasília</option>\n");
      out.write("                            <option value=\"CE\">Ceará</option>\n");
      out.write("                            <option value=\"ES\">Espírito Santo</option>\n");
      out.write("                            <option value=\"GO\">Goiás</option>\n");
      out.write("                            <option value=\"MA\">Maranhão</option>\n");
      out.write("                            <option value=\"MT\">Mato Grosso</option>\n");
      out.write("                            <option value=\"MS\">Mato Gosso do Sul</option>\n");
      out.write("                            <option value=\"MG\">Minas Gerais</option>\n");
      out.write("                            <option value=\"PA\">Pará</option>\n");
      out.write("                            <option value=\"PB\" selected>Paraíba</option>\n");
      out.write("                            <option value=\"PR\">Paraná</option>\n");
      out.write("                            <option value=\"PE\">Pernambuco</option>\n");
      out.write("                            <option value=\"PI\">Piauí</option>\n");
      out.write("                            <option value=\"RJ\">Rio de Janeiro</option>\n");
      out.write("                            <option value=\"RN\">Rio Grande do Norte</option>\n");
      out.write("                            <option value=\"RS\">Rio Grande do Sul</option>\n");
      out.write("                            <option value=\"RO\">Rondônia</option>\n");
      out.write("                            <option value=\"RR\">Roraima</option>\n");
      out.write("                            <option value=\"SC\">Santa Catarina</option>\n");
      out.write("                            <option value=\"SC\">São Paulo</option>\n");
      out.write("                            <option value=\"SE\">Sergipe</option>\n");
      out.write("                            <option value=\"TO\">Tocantins</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"cidade\">Cidade: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"cidade\" id=\"cidade\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-5\">\n");
      out.write("                        <label for=\"bairro\">Bairro: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"bairro\" id=\"bairro\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-5\">\n");
      out.write("                        <label for=\"rua\">Rua: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"rua\" id=\"rua\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-2\">\n");
      out.write("                        <label for=\"numero\">Número: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"numero\" id=\"numero\" min=\"1\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"tipo\">Tipo de Usuário: </label>\n");
      out.write("                        <select class=\"form-control\" name=\"tipo\" id=\"tipo\" onchange=\"this.value==='GERENTE_DE_AGENCIA' ? agencia.disabled=false : agencia.disabled=true;\">\n");
      out.write("                            <option value=\"ADMINISTRADOR\">Administrador</option>\n");
      out.write("                            <option value=\"CLIENTE\">Cliente</option>\n");
      out.write("                            <option value=\"GERENTE_DE_AGENCIA\">Gerente de Agência</option>\n");
      out.write("                            <option value=\"GERENTE_GERAL_DO_BANCO\">Gerente Geral do Banco</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"tipo\">Agencia: </label>\n");
      out.write("                        <select class=\"form-control\" name=\"agencia\" id=\"agencia\" disabled>\n");
      out.write("                            ");

                                ListarAgenciaBo lista = new ListarAgenciaBo();
                                List<Agencia> agencia = lista.listar();
                                for(Agencia a: agencia){
                                    out.print("<option value="+ a.getNumero() +">"+ a.getNome() +"</option>");
                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-8\">\n");
      out.write("                        <label for=\"email\">Email: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"email\" id=\"email\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-4\">\n");
      out.write("                        <label for=\"senha\">Senha: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"senha\" id=\"senha\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-4\">\n");
      out.write("                        <label for=\"telefone\">Telefone: </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"telefone\" id=\"telefone\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"telefones\"></div>\n");
      out.write("                    <div class=\"form-group col-md-12\">\n");
      out.write("                        <a href=\"#\" id=\"add\" class=\"btn btn-success btn-lg btn-xs\">+ Adicionar mais telefones</a><br>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group col-md-2\">\n");
      out.write("                        <input id=\"btnCadastrar\" type=\"submit\" value=\"Cadastrar\" class=\"btn btn-primary btn-block\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write(" \t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/funcoes.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
