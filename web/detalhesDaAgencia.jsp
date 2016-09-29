<%-- 
    Document   : detalhesDaAgencia
    Created on : 03/09/2016, 14:19:08
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
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
        <div class="container text-center">
            <h2>Dados da Agência</h2><br>
        </div>
        <div class="container" style="width:90%">
            <div class="row">
                <div class="form-group">
                    <p><strong>Número da Agência:</strong> ${agencia.numero}</p>
                    <p><strong>Nome:</strong> ${agencia.nome}</p>
                    <p><strong>Endereço</strong></p>
                    <p><strong>UF:</strong> ${agencia.endereco.estado}</p>
                    <p><strong>Cidade:</strong> ${agencia.endereco.cidade}</p>
                    <p><strong>Bairro:</strong> ${agencia.endereco.bairro}</p>
                    <p><strong>Rua:</strong> ${agencia.endereco.rua}</p>
                    <p><strong>Número:</strong> ${agencia.endereco.numero}</p>
                    <p>
                        <strong>Telefones:</strong><br>
                        <c:forEach var="tel" items="${agencia.telefones}">
                            ${tel}<br>
                        </c:forEach>
                    </p>
                    <p>
                        <strong>Gerentes:</strong><br>
                        <c:forEach var="gerente" items="${agencia.gerentes}">
                            ${gerente.nome}<br>
                        </c:forEach>
                    </p>
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="listarAgencias.jsp">Voltar</a>
                        <a class="btn btn-danger" href="Controller?command=RemoverAgencia&numero=${agencia.numero}&pagina=lsitarAgencias">Excluir</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
