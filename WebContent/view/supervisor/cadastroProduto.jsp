<%@page import="dao.CategoriaDAO"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<div class="container">
	<%
		if (request.getParameter("cadProduto") != null) {
	%>

	<div class="alert alert-success" role="alert">
		Categoria <%=request.getParameter("cadProduto")%> cadastrada com sucesso.
	</div>
	<%
		}
	%>
	<h3>
		<a type="button" class="btn btn-lg btn-default" href="cadastroCategoria.jsp">Cadastrar Nova Categoria</a>
	</h3>
	<form id="formDoacaoItem" method="post" action="cadastrar_produto">
		<h2>Cadastro de Produto</h2>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="Text" id="nome"
					name="nome" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="descricao">Descrição:</label> <input type="Text" id="descircao"
					name="descricao" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="valor_estimado">Valor Estimado:</label> <input
					type="Text" id="money" name="valor_estimado"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>Categoria de Produtos: </label> <select name="categoria"
				id="categoria" required class="form-control">
				<option value="" disabled="disabled" selected="selected">Selecione
					uma categoria</option>
				<%
					List<Categoria> categorias = new CategoriaDAO().listar();
					for (Categoria categoria : categorias) {
				%>
				<option value="<%=categoria.getId()%>"><%=categoria.getNome()%></option>
				<%
					}
				%>
				</select>
			</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-success" >
		</div> 	
	</form>
</div>