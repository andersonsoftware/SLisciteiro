<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<div class="container">
	<h3>
		<a type="button" class="btn btn-lg btn-default" href="cadastroCategoria.jsp">Cadastrar Nova Categoria</a>
	</h3>
	<form id="formDoacaoItem" method="post" action="cadastrar_produto">
		<h2>Cadastro de Produto</h2>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="Text" id="nome"
					name="nome" class="form-control">
			</div>
			<div class="form-group">
				<label for="valor_estimado">Valor Estimado:</label> <input
					type="Text" id="money" name="valor_estimado"
					class="form-control">
			</div>
			<div class="form-group">
				<label>Categoria do Produto: </label> <select name="categoria"
					id="categoria" required class="form-control">
					<option value="">--- Selecione uma categoria ---</option>
				</select>
			</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-success" >
		</div> 	
	</form>
</div>