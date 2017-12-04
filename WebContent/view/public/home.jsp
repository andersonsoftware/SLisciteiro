<div class="container">
	<%
		if (request.getParameter("produtoCadastrado") != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Produto</span> Cadastrado com sucesso.
	</div>
	<%
		}
	%>
	<h3>
		<a type="button" class="btn btn-lg btn-default" href="cadastroProduto.jsp">Cadastrar Novo Produto</a>
		<a type="button" class="btn btn-lg btn-default" href="cadastroCategoria.jsp">Cadastrar Nova Categoria</a>
	</h3>

	<form class="" id="form_cadastro_liscitacao" method="post"
		action="cadastrar_liscitacao">
		<h2>Cadastro de Liscitações</h2>
		<div class="form-group">
			<label>Descrição: </label> <input type="text" id="descricao"
				placeholder="Digite a descrição da liscitação" class="form-control"
				name="descricao" required autofocus>
		</div>
		<div class="form-group">
			<label>Categoria de Produtos: </label> <select name="banco"
				id="banco" required class="form-control">
				<option value="">--- Selecione uma categoria ---</option>
			</select>
		</div>
		<div class="form-group">
			<label>Valor Estimado: </label> <input type="text"
				id="money" value=000
				placeholder="Digite a descrição da liscitação" class="form-control"
				name="valor_estimado" disabled autofocus>
		</div>
	</form>
</div>
