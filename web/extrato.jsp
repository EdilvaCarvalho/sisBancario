<%-- 
    Document   : extrato
    Created on : 19/09/2016, 20:33:59
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/myTags" prefix="df" %>
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
        <div><jsp:include page="paginaDoCliente.jsp"/></div>
        <div class="container text-center">
            <h2>Extrato da Conta</h2><br>
        </div>
        <div class="container" style="width:75%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td><strong>DATA</strong></td>
                            <td><strong>HORA</strong></td>
                            <td><strong>TIPO</strong></td>
                            <td><strong>VALOR</strong></td>
                            <td><strong>ATOR</strong></td>
                        </tr>
                        <c:forEach var="movimentacao" items="${requestScope.listaDeMovimentacoes}">
                            <tr class="row">
                                <td><df:dataFormatada data="${movimentacao.data}" /></td>
                                <td>${movimentacao.hora}</td>
                                <td>${movimentacao.tipo}</td>
                                <td>${movimentacao.valor}</td>
                                <td>${movimentacao.titular.nome}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-12 text-center">
                    <a class="btn btn-primary" href="Controller?command=ListarContasDeClientes">Voltar</a>
                </div>
            </div>
        </div>
    </body>
</html>
