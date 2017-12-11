<%@page import="util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=Constantes.CSS%>bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<%=Constantes.CSS%>ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=Constantes.CSS%>signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="<%=Constantes.JS%>ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<%=Constantes.JS%>ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<%=Constantes.JS%>html5shiv.min.js"></script>
      <script src="<%=Constantes.JS%>respond.min.js"></script>
    <![endif]-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<script type="text/javascript" src="<%=Constantes.JS%>jquery-3.0.0.min.js"></script>


</head>
<body>
 <div class="container">
	<form class="form-signin" id="form_login" method="post" action="login">
		<h2 class="form-signin-heading">Por favor, entre!</h2>
		<div class="form-group">
			<label for="login" class="sr-only">Login</label><br> 
			<input type="text" id="login" placeholder="Login" class="form-control" name="login" required autofocus><br> 
		</div>
		<div class="form-group">
			<input id="senha" type="password" name="senha" placeholder="Senha" class="form-control" required><br>
		</div>
		<div class="form-group">
			<input type="submit" value="Entrar" class="btn btn-success" >
			<a href="cadastro.jsp"><input type="button" value="Seja um Fornecedor" class="btn btn-primary" ></a>
		</div> 		
			
		<%
			if (request.getParameter("deslog") == null) {						
				if (request.getParameter("erroLogInvalid") != null) {
		%>
		
		<div class="alert alert-danger" role="alert">
		  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		  <span class="sr-only">Erro:</span>
		  Login inválido, tente novamente.
		</div> 
		<%
		 		} else if (request.getParameter("erroNotLog") != null) {
		 %>
 		<div class="alert alert-danger" role="alert">
		  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		  <span class="sr-only">Erro:</span>
		  Você não está logado: Faça o login para acessar o sistema.
		</div> 		 
		<%
 				} else if (request.getParameter("cadastrado") != null) {
		 %>
			 		<div class="alert alert-success" role="alert">
						  Seu cadastro foi realizado e está aguardando aprovação!
					</div> 		 
		<%
 				}
 			}else{ 				
 		%>
 		<script>
			parent.window.location.href="login.jsp";
		</script>
 		<%
 			}
 %>
	</form>
	</div>
</body>
</html>
