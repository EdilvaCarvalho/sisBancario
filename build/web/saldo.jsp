<%-- 
    Document   : saldo
    Created on : 19/09/2016, 12:02:36
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h2>Dados da Conta</h2><br>
        </div>
        <div class="container" style="width:90%">
            <div class="row">
                <div class="form-group">
                    <p><strong>Número da Conta:</strong> ${conta.numero}</p>
                    <p><strong>Número da Agência:</strong> ${conta.agencia.numero}</p>
                    <p><strong>Nome da Agência:</strong> ${conta.agencia.nome}</p>
                    <p><strong>Data de Abertura:</strong> ${conta.dataAbertura}</p>
                    <p>
                        <strong>Titulares:</strong><br>
                        <c:forEach var="titular" items="${conta.titulares}">
                            ${titular.nome}<br>
                        </c:forEach>
                    </p>
                    <br>
                    <h3><strong>Saldo:</strong> ${conta.saldo}</h3>
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="Controller?command=ListarContasDeClientes">Voltar</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
