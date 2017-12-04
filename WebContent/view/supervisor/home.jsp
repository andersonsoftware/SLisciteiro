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
			<label>Categoria de Produtos: </label> <select name="categoria"
				id="categoria" required class="form-control">
				<option value="">--- Selecione uma categoria ---</option>
			</select>
		</div>
		<div class="form-group">
			<table class="table table-striped table-bordered table-hover table-condensed" id="table_produtos">
				<thead id="cab_tab">
					<th>Produto</th>
					<th>Quantidade</th>
					<th>Ação</th>		
				</thead>
				<tbody id="conteudo_tab_produtos">					
				</tbody>
			</table>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-xs-6">
					<label>Produto: </label> <select name="produto"
						id="produto" required class="form-control">
						<option value="">--- Selecione um produto ---</option>
					</select>
				</div>
				<div class="col-xs-6">
					<label for="quantidade_produto">Quantidade:</label> <input
						type="number" id="quantidade_produto" name="quantidade_produto"
						class="form-control ">
				</div>
			</div>
			<input type="button" value="Adicionar Produtos" id="add_produto" class="btn btn-primary form-control">
		</div>
		<div class="form-group">
			<label>Valor Estimado: </label> <input type="text"
				id="money" value=20000
				placeholder="Digite a descrição da liscitação" class="form-control"
				name="valor_estimado" disabled autofocus>
		</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-success" >
		</div> 	
	</form>
</div>
