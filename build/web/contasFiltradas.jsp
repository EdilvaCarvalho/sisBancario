<%-- 
    Document   : contasFiltradas
    Created on : 22/09/2016, 13:52:01
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="df" uri="/WEB-INF/myTags"%>
<jsp:useBean id="listaContas" class="modelo.ListarContasBo" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoGerenteDeAgencia.jsp"/></div>
        <div class="container text-center">
            <h2>Contas</h2><br>
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
                        <c:forEach var="conta" items="${listaContas.listar()}">
                            <c:if test="${(conta.saldo >= valor1) && (conta.saldo <= valor2)}">
                                <tr class="row">
                                    <td>${conta.numero}</td>
                                    <td><df:dataFormatada data="${conta.dataAbertura}" /></td>
                                    <td>${conta.saldo}</td>
                                    <td>${conta.agencia.numero}</td>
                                    <td class="col-md-2">
                                        <a class="btn btn-primary btn-block" href="Controller?command=ExibirConta&numero=${conta.numero}">Detalhar</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
