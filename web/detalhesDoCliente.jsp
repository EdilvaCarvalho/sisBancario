<%-- 
    Document   : detalhesDoCliente
    Created on : 05/09/2016, 19:42:07
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
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoGerenteDeAgencia.jsp"/></div>
        <div class="container text-center">
            <h2>Dados de ${user.nome}</h2><br>
        </div>
        <div class="container" style="width:90%">
            <div class="row">
                <div class="form-group">
                    <p><strong>CPF:</strong> ${user.cpf}</p>
                    <p><strong>Nome:</strong> ${user.nome}</p>
                    <p><strong>RG:</strong> ${user.rg}</p>
                    <p><strong>Data de Nascimento:</strong> ${user.dataNasc}</p>
                    <p><strong>Email:</strong> ${user.email}</p>
                    <p><strong>Tipo de Usuário:</strong> ${user.tipo}</p>
                    <p><strong>Endereço</strong></p>
                    <p><strong>UF:</strong> ${user.endereco.estado}</p>
                    <p><strong>Cidade:</strong> ${user.endereco.cidade}</p>
                    <p><strong>Bairro:</strong> ${user.endereco.bairro}</p>
                    <p><strong>Rua:</strong> ${user.endereco.rua}</p>
                    <p><strong>Número:</strong> ${user.endereco.numero}</p>
                    <p>
                        <strong>Telefones:</strong><br>
                        <c:forEach var="tel" items="${user.telefones}">
                            ${tel}<br>
                        </c:forEach>
                    </p>                
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="Controller?command=ListarClientesDeAgencia">Voltar</a>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>