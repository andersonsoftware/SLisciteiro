<%@page import="dao.CategoriaDAO"%>
<%@page import="model.Categoria"%>
<%@page import="dao.LicitacaoDAO"%>
<%@page import="model.Licitacao"%>
<%@page import="java.util.List"%>
<div class="container">

<div class="row">
		<div class="col-md-3">
			<form method="get" action="">
				<div class="row">
					<div class="form-group col-md-9">
						<input class="form-control" name="descricao_licitacao" type="text"
							placeholder="Descrição da Licitação ...">
					</div>
					<div class="form-group col-md-9">
						<input class="form-control" type="submit" value="Pesquisar">
					</div>
				</div>
			</form>
		</div>
			<strong>Lista de Licitações</strong>
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<th>Descrição</th>
						<th>Solicitante</th>
						<th>Data Fim</th>
						<th>Categoria</th>
					</thead>
					<tbody>
						<%
							List<Categoria> categorias = new CategoriaDAO().listar();
							List<Licitacao> licitacoes = new LicitacaoDAO().listar(0, 10);
							for (Licitacao licitacao : licitacoes) {
								if(licitacao.getDescricao().contains("")){
						%>
						<tr>
							<td><%=licitacao.getDescricao() %></td>
							<td><%=licitacao.getFuncionario().getNome() %></td>
							<td><%=licitacao.getDataFim() %></td>
							<td><%=licitacao.getCategoria().getNome() %></td>
						</tr>
						<%
							
								}
							}
						%>
					</tbody>
				</table>
		</div>
	</div>
</div>