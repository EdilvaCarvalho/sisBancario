<%-- 
    Document   : contasDoCliente
    Created on : 18/09/2016, 17:57:49
    Author     : Edilva
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="df" uri="/WEB-INF/myTags"%>
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
        <div><jsp:include page="paginaDoCliente.jsp"/></div>
        <div class="container text-center">
            <h2>Contas</h2><br>
        </div>
        <div class="container" style="width:75%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td><strong>NÚMERO DA CONTA</strong></td>
                            <td><strong>NÚMERO DA AGÊNCIA</strong></td>
                            <td><strong>SALDO DA CONTA</strong></td>
                            <td><strong>EXTRATO DA CONTA</strong></td>
                            <td><strong>TRANSFERÊNCIA</strong></td>
                        </tr>
                        <c:forEach var="conta" items="${sessionScope.listaDeContas}">
                            <tr class="row">
                                <td>${conta.numero}</td>
                                <td>${conta.agencia.numero} - ${conta.agencia.nome}</td>
                                <td class="col-md-2">
                                    <a class="btn btn-success btn-block" href="Controller?command=ExibirConta&numero=${conta.numero}">Saldo</a>
                                </td>
                                <td class="col-md-2">
                                    <a class="btn btn-primary btn-block" href="Controller?command=ListarMovimentacoes&numero=${conta.numero}">Extrato</a>
                                </td>
                                <td class="col-md-2">
                                    <a class="btn btn-info btn-block" href="Controller?command=PegaConta&numeroConta=${conta.numero}">Realizar Transferência</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>