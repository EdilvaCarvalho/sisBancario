<%-- 
    Document   : contasFiltradas
    Created on : 22/09/2016, 08:33:25
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
            <h2>Informe os dados</h2><br>
        </div>
        <div class="container" style="width:60%">
            <div class="row">
                <form method="post" id="filtrar" action="Controller?command=Filtrar">
                    <div class="form-group col-md-4">
                        <label for="valor1">Valor 1: </label>
                        <input type="text" class="form-control" name="valor1" id="valor1" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="valor2">Valor 2: </label>
                        <input type="text" class="form-control" name="valor2" id="valor2" required>
                    </div><br>
                    <div class="form-group col-md-2">
                        <input id="btnFiltrar" type="submit" value="Filtrar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
