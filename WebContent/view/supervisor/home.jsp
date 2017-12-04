<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
	<%
		if (request.getParameter("licitacaoRealizada") != null) {
	%>

	<div class="alert alert-success" role="alert">
		Licitação Cadastrada com sucesso.
	</div>
	<%
		}
	%>
	<h3>
		<a type="button" class="btn btn-lg btn-default" href="cadastroProduto.jsp">Cadastrar Novo Produto</a>
	</h3>

	<form class="" id="form_cadastro_liscitacao" method="post"
		action="cadastrar_liscitacao">
		<h2>Cadastro de Liscitações</h2>
		<input type="hidden" name="lista_produtos" id="lista_produtos"/> 
		<div class="form-group">
			<label>Descrição: </label> <input type="text" id="descricao"
				placeholder="Digite a descrição da liscitação" class="form-control"
				name="descricao" required autofocus>
		</div>
		<div class="form-group">
			<label>Categoria de Produtos: </label> <select name="categoria"
				id="categoria" required class="form-control">
				<option value="">--- Selecione uma categoria ---</option>
				<option value="xxxx">--- Categoria ---</option>
			</select>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-xs-6">
					<label>Produto: </label> <select name="produto"
						id="produto" required class="form-control">
						<option value="Sem Nome">--- Selecione um produto ---</option>
						<option value="xxx">--- produto ---</option>
					</select>
				</div>
				<div class="col-xs-6">
					<label for="quantidade_produto">Quantidade:</label> <input
						type="number" min=1 id="quantidade_produto" name="quantidade_produto"
						class="form-control ">
				</div>
			</div>
			<input type="button" value="Adicionar Produtos" id="add_produto" class="btn btn-primary form-control">
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
			<label>Valor Estimado: </label> <input type="text"
				id="money" 
				placeholder="Digite a descrição da liscitação" class="form-control"
				name="valor_estimado"  autofocus>
		</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" onclick="addListReturn();" class="btn btn-success" >
		</div> 	
	</form>
</div>
