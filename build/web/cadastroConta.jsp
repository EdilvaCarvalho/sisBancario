<%-- 
    Document   : cadastroConta
    Created on : 08/08/2016, 09:24:35
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="lista" class="modelo.ListarAgenciaBo" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <script src="js/jquery.maskedinput.min.js" type="text/javascript"></script>
        <script src="js/funcoes.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoAdministrador.jsp"/></div>
        <div class="container text-center">
            <h1>Dados da Conta</h1>
            <br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="cadastroConta" action="Controller?command=CadastrarConta">
                    <div class="form-group col-md-8">
                        <label for="numeroConta">Número: </label>
                        <input type="text" class="form-control" name="numeroConta" id="numeroConta" autofocus required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="dataAbertura">Data da Abertura: </label>
                        <input type="date" class="form-control" name="dataAbertura" id="dataAbertura" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="saldo">Saldo: </label>
                        <input type="text" class="form-control" name="saldo" id="saldo" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="agencia">Agencia: </label>
                        <select class="form-control" name="agencia" id="agencia">
                            <c:forEach var="agencia" items="${lista.listar()}">
                                <option value="${agencia.numero}">${agencia.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="titular">CPF do Titular:</label>
                        <input type="text" class="form-control" name="cpf" id="cpf" required>
                    </div>
                    <div id="titulares"></div>
                    <div class="form-group col-md-12">
                        <a href="#" id="add" class="btn btn-success btn-lg btn-xs">+ Adicionar mais titulares</a><br>
                    </div>
                    <div class="form-group col-md-2">
                        <input id="btnCadastrar" type="submit" value="Cadastrar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
