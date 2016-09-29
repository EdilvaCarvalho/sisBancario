<%-- 
    Document   : paginaDoCliente
    Created on : 05/09/2016, 20:37:08
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <link href="css/estilo.css" rel="stylesheet">
        <title>Cliente | Banco da Gente</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                        <span class="sr-only">Toggle navigation</span> 
                    </button> 
                    <a class="navbar-brand" href="paginaDoCliente.jsp">Banco da Gente - Cliente</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="transferencia.jsp">Realizar Trasferência</a>
                        </li>
                        <li class="dropdown">
                            <a href="Controller?command=ListarContasDeClientes" >Conta</a>
                        </li>
                        <li>
                            <a href="Controller?command=Sair">Sair</a>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>
        <br><br><br>
        <div><jsp:include page="footer.html"/></div>
    </body>
</html>
