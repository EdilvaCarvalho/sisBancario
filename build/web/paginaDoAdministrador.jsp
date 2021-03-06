<%-- 
    Document   : PaginaDoAdministrador
    Created on : 12/08/2016, 09:55:50
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <title>Administrador | Banco da Gente</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                        <span class="sr-only">Toggle navigation</span> 
                    </button> 
                    <a class="navbar-brand" href="paginaDoAdministrador.jsp">Banco da Gente - Administrador</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Usuários</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroUsuario.jsp">Cadastrar Usuário</a></li>
                                <li><a href="listarUsuarios.jsp">Buscar Usuários</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Agências</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroAgencia.jsp">Cadastrar Agência</a></li>
                                <li><a href="listarAgencias.jsp">Buscar Agências</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Contas</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroConta.jsp">Abrir Conta</a></li>
                                <li><a href="listarContas.jsp">Buscar Contas</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Movimentações Financeiras</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="sacar.jsp">Registrar Saque</a></li>
                                <li><a href="depositar.jsp">Registrar Depósito</a></li>
                            </ul>
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
