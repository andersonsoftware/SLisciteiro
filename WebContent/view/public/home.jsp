<%@page import="dao.LicitacaoDAO"%>
<%@page import="model.Licitacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
	<div class="row">
		<div class="col-md-3">
			<form method="get" action="">
				<div class="row">
					<div class="form-group col-md-9">
						<input class="form-control" name="descricao_licitacao" type="text"
							placeholder="Descrição da Licitação ...">
					</div>
					<div class="form-group col-md-3">
						<input class="form-control" type="submit" value="Pesquisar">
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3">
			<a href="#" class="btn btn-info btn-block">Nova Licitação</a>
		</div>
		<div class="col-md-3">
			<a href="#" class="btn btn-info btn-block">Licitações</a>
		</div>
		<div class="col-md-3">
			<a href="#" class="btn btn-info btn-block">Perfil</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-9">
			<strong>Lista de Licitações</strong>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<th>ID</th>
						<th>Descrição</th>
						<th>Fornecedor</th>
						<th>Solicitante</th>
						<th>Status</th>
					</thead>
					<tbody>
						<%
							List<Licitacao> licitacao = LicitacaoDAO.listar();;
							for (Licitacao categoria : categorias) {
						%>
						<tr>
							<td><%=categoria.getId() %></td>
							<td><%=categoria.get %></td>
							<td>HOME</td>
							<td>HOME</td>
						</tr>
						<option class="carregarProdCategoria"
							value=""><%=categoria.getNome()%></option>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>