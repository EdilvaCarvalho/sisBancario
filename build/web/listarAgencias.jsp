<%-- 
    Document   : listarAgencias
    Created on : 03/09/2016, 13:50:14
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaAgencias" class="modelo.ListarAgenciaBo" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
        <div class="container text-center">
            <h2>Agências</h2><br>
            <form method="post" class="navbar-form navbar-right" action="Controller?command=ExibirAgencia" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" name="numero" id="numero" placeholder="Digite o número da agência">
                </div>
                <input id="btnPesquisar" type="submit" value="Pesquisar" class="btn btn-success">
            </form>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td><strong>NÚMERO</strong></td>
                            <td><strong>NOME</strong></td>
                            <td><strong>UF</strong></td>
                            <td><strong>CIDADE</strong></td>
                            <td><strong>DETALHAR AGÊNCIA</strong></td>
                            <td><strong>EXCLUIR AGÊNCIA</strong></td>
                        </tr>
                        <c:forEach var="agencia" items="${listaAgencias.listar()}">
                            <tr class="row">
                                <td>${agencia.numero}</td>
                                <td>${agencia.nome}</td>
                                <td>${agencia.endereco.estado}</td>
                                <td>${agencia.endereco.cidade}</td>
                                <td class="col-md-2">
                                    <a class="btn btn-primary btn-block" href="Controller?command=ExibirAgencia&numero=${agencia.numero}">Detalhar</a>
                                </td>
                                <td class="col-md-2">
                                    <a class="btn btn-danger btn-block" href="Controller?command=RemoverAgencia&numero=${agencia.numero}">Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
