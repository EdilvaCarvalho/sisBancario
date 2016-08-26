<%-- 
    Document   : listarUsuarios
    Created on : 24/08/2016, 20:57:33
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="lista" class="modelo.ListarUsuarioBo"/>
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
        <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
        <div class="container text-center">
        </div>
        <div class="container" style="width:80%">
            <div class="row">
                <div class="form-group col-md-6">
                    <table class="table table-striped">
                        <tr class="row">
                                <td>CPF</td>
                                <td>NOME</td>
                                <td>RG</td>
                                <td>DATA DE NASC</td>
                                <td>EMAIL</td>
                                <td>TIPO DE USUÁRIO</td>
                                <td>UF</td>
                                <td>CIDADE</td>
                                <td>BAIRRO</td>
                                <td>RUA</td>
                                <td>NÚMERO</td>
                            </tr>
                        <c:forEach var="usuario" items="${lista.listar()}">
                            <tr class="row">
                                <td>${usuario.cpf}</td>
                                <td>${usuario.nome}</td>
                                <td>${usuario.rg}</td>
                                <td>${usuario.dataNasc}</td>
                                <td>${usuario.email}</td>
                                <td>${usuario.tipo}</td>
                                <td>${usuario.endereco.estado}</td>
                                <td>${usuario.endereco.cidade}</td>
                                <td>${usuario.endereco.bairro}</td>
                                <td>${usuario.endereco.rua}</td>
                                <td>${usuario.endereco.numero}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
