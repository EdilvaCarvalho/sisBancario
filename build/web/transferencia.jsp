<%-- 
    Document   : transferencia
    Created on : 18/09/2016, 11:23:27
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
        <script src="js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoCliente.jsp"/></div>
        <div class="container text-center">
            <h2>Dados da Transferência</h2><br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="formTransferencica" action="Controller?command=RealizarMovimentacao&tipo=transferência&numeroConta=${requestScope.numeroConta}&cpf=${sessionScope.usuario.cpf}">
                    <div class="form-group col-md-3">
                        <label for="numeroContaDest">Conta de destino: </label>
                        <input type="text" class="form-control" name="numeroContaDest" id="numeroContaDest" autofocus required>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="valor">Valor do depósito: </label>
                        <input type="text" class="form-control" name="valor" id="valor" required>
                    </div><br>
                    <div class="form-group col-md-3">
                        <input id="btnCadastrar" type="submit" value="Registrar Transferência" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>