<%-- 
    Document   : listarClientes
    Created on : 05/09/2016, 09:15:12
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="df" uri="/WEB-INF/myTags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <script src="js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoGerenteDeAgencia.jsp"/></div>
        <div class="container text-center">
            <h2>Clientes</h2>
            <form method="post" class="navbar-form navbar-right" action="Controller?command=ExibirUsuario" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" name="cpf" id="cpf" placeholder="Informe o CPF do usuário">
                </div>
                <input id="btnPesquisar" type="submit" value="Pesquisar" class="btn btn-success">
            </form>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>CPF</td>
                            <td>NOME</td>
                            <td>RG</td>
                            <td>DATA DE NASC</td>
                            <td>EMAIL</td>
                            <td>DETALHAR USUÁRIO</td>
                        </tr>
                        <c:forEach var="user" items="${listaClientes}">
                            <tr class="row">
                                <td>${user.cpf}</td>
                                <td>${user.nome}</td>
                                <td>${user.rg}</td>
                                <td><df:dataFormatada data="${user.dataNasc}" /></td>
                                <td>${user.email}</td>
                                <td class="col-md-2">
                                    <a class="btn btn-primary btn-block" href="Controller?command=ExibirUsuario&cpf=${user.cpf}">Detalhar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
