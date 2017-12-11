<%@page import="java.util.List"%>
<%@page import="model.Setor"%>
<%@page import="dao.SetorDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<div class="container">
	<%
		if (request.getParameter("cadCategoria") != null) {
	%>

	<div class="alert alert-success" role="alert">
		Categoria <%=request.getParameter("cadCategoria")%> cadastrada com sucesso.
	</div>
	<%
		}
	%>
	<form id="formDoacaoItem" method="post" action="cadastrar_categoria">
		<h2>Cadastro de Categoria</h2>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="Text" id="nome"
					name="nome" class="form-control" required>
			</div>
			<label>Setor Responsável: </label> <select name="setor"
				id="setor" required class="form-control">
				<option value="" disabled="disabled" selected="selected">Selecione
					um setor</option>
				<%
					List<Setor> setores = new SetorDAO().listar();
					for (Setor setor : setores) {
				%>
				<option value="<%=setor.getId()%>"><%=setor.getNome()%></option>
				<%
					}
				%>
			</select>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-success" >
		</div> 	
	</form>
</div>