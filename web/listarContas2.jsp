<%-- 
    Document   : listarContas2
    Created on : 12/09/2016, 09:43:35
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="df" uri="/WEB-INF/myTags"%>
<jsp:useBean id="listaContas2" class="modelo.ListarContasBo" scope="page"/>
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
        <div><jsp:include page="paginaDoGerenteGeral.jsp"/></div>
        <div class="container text-center">
            <h2>Contas</h2><br>
            <form method="post" class="navbar-form navbar-right" action="Controller?command=ExibirConta" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" name="numero" id="numero" placeholder="Digite o número da conta">
                </div>
                <input id="btnPesquisar" type="submit" value="Pesquisar" class="btn btn-success">
            </form>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td><strong>NÚMERO DA CONTA</strong></td>
                            <td><strong>DATA DE ABERTURA</strong></td>
                            <td><strong>SALDO</strong></td>
                            <td><strong>NÚMERO DA AGÊNCIA</strong></td>
                            <td><strong>DETALHAR CONTA</strong></td>
                        </tr>
                        <c:forEach var="conta" items="${listaContas2.listar()}">
                            <tr class="row">
                                <td>${conta.numero}</td>
                                <td><df:dataFormatada data="${conta.dataAbertura}" /></td>
                                <td>${conta.saldo}</td>
                                <td>${conta.agencia.numero}</td>
                                <td class="col-md-2">
                                    <a class="btn btn-primary btn-block" href="Controller?command=ExibirConta&numero=${conta.numero}">Detalhar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

