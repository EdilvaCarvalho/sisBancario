<%-- 
    Document   : sacar
    Created on : 16/09/2016, 18:23:07
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h2>Dados do Saque</h2><br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="formSaque" action="Controller?command=RealizarMovimentacao&tipo=saque">
                    <div class="form-group col-md-4">
                        <label for="numeroConta">Número da conta: </label>
                        <input type="text" class="form-control" name="numeroConta" id="numeroConta" autofocus required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="titular">CPF do Titular:</label>
                        <input type="text" class="form-control" name="cpf" id="cpf" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="valor">Valor do saque:</label>
                        <input type="text" class="form-control" name="valor" id="valor" required>
                    </div>
                    <div class="form-group col-md-4">
                        <input id="btnCadastrar" type="submit" value="Registrar Saque" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
