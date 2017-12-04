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

    <title>Cadastro</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=Constantes.CSS%>bootstrap.min.css" rel="stylesheet">

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
      <script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
<body>
 <div class="container">
	<form class="" id="form_cadastro" method="post" action="cadastrar">
		<h2>Por favor, faça seu cadastro!</h2>
		<div class="form-group">
			<label>Nome: </label>
			<input type="text" id="nome" placeholder="Digite o nome da empresa" class="form-control" name="nome" required autofocus> 
		</div>
		<div class="form-group">
			<label>CNPJ: </label>
			<input type="text" id="cnpj" placeholder="Digite o CNPJ da empresa" class="form-control" name="cnpj" required autofocus> 
		</div>
		<div class="form-group">
			<label>Telefone: </label>
			<input type="text" id="telefone" placeholder="Digite o telefone da empresa" class="form-control" name="telefone" required autofocus>
		</div>
		<div class="form-group">
			<label>E-mail: </label>
			<input type="text" id="email" placeholder="Digite o e-mail da empresa" class="form-control" name="email" required autofocus>
		</div>
		<div class="form-group">
			<label>Endereço: </label>
			<input type="text" id="endereco" placeholder="Digite o endereço da empresa" class="form-control" name="endereco" required autofocus>
		</div>
		<div class="form-group">
			<label>Banco: </label>
			<select name="banco" id="banco" required class="form-control">
				<option value="">--- Selecione um Banco ---</option>
				<option value="BB">Banco do Brasil</option>
				<option value="BRA">Bradesco</option>
				<option value="CA">Caixa</option>
				<option value="SA">Santander</option>
				<option value="IT">Itaú</option>
			</select>
			<label>Tipo de Conta: </label>
			<select name="tipo_conta" required class="form-control">
				<option value="">--- Selecione um Tipo ---</option>
				<option value="CC">Conta Corrente</option>
				<option value="CP">Conta Poupança</option>
			</select>
		</div>
		<div class="form-group">
			<label>Agência Bancária: </label>
			<input type="text" id="agencia" placeholder="Digite o endereço da empresa" class="form-control" name="agencia" disabled required autofocus>
		</div>
		<div class="form-group">
			<label>Conta Bancária: </label>
			<input type="text" id="conta" placeholder="Digite o endereço da empresa" class="form-control" name="conta" disabled required autofocus>
		</div>
		<div class="form-group">
			<label>Login: </label>
			<input type="text" id="login" placeholder="Digite o login de usuário" class="form-control" name="login" required autofocus> 
		</div>
		<div class="form-group">
			<label>Senha: </label>
			<input id="senha" type="password" name="senha" placeholder="Digite a senha" class="form-control" required>
		</div>
		<div class="form-group">
			<label>Confirmação de senha: </label>
			<input id="senha_confirmacao" type="password" name="senha_confirmacao" placeholder="Digite a senha novamente" class="form-control"  required>
		</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-success" >
			<a href="login.jsp"><input type="button" value="Voltar" class="btn btn-primary" ></a>
		</div> 		

	</form>
	</div>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
	<script type="text/javascript" src="<%=Constantes.JS%>mask.js"></script>
	<script type="text/javascript" src="<%=Constantes.JS%>validacao.js"></script>
</body>
</html>
