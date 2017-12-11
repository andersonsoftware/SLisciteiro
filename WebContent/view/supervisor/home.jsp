<%@page import="dao.CategoriaDAO"%>
<%@page import="model.Categoria"%>
<%@page import="dao.LicitacaoDAO"%>
<%@page import="model.Licitacao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
	int pagina = request.getParameter("pagina") == null ? 1	: Math.abs(Integer.valueOf(request.getParameter("pagina")));
	int fim = pagina * Constantes.QNTD_ITENS_PAGINA;
	int inicio = fim - Constantes.QNTD_ITENS_PAGINA;
	LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
	int quantidadeDeItensPaginacao = licitacaoDAO.buscarQntdDeLicitacoes() / Constantes.QNTD_ITENS_PAGINA;
%>
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
	</div>
	<div class="row">
		<div class="col-md-3">
			<ul>
				<%
					List<Categoria> categorias = new CategoriaDAO().listar();
					for (Categoria categoria : categorias) {
				%>
				<li><input type="checkbox" name="categorias"
					value="<%=categoria.getId()%>"> <%=categoria.getNome()%></li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="col-md-9">
			<strong>Lista de Licitações</strong>
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<th>Descrição</th>
						<th>Solicitante</th>
						<th>Data Fim</th>
						<th>Categoria</th>
					</thead>
					<tbody>
						<%
							List<Licitacao> licitacoes = licitacaoDAO.listar(inicio, fim);
							for (Licitacao licitacao : licitacoes) {
								
						%>
						<tr>
							<td><%=licitacao.getDescricao()%></td>
							<td><%=licitacao.getFuncionario().getNome()%></td>
							<td><%=licitacao.getDataFim()%></td>
							<td><%=licitacao.getCategoria().getNome()%></td>
						</tr>
						<%	
							}
						%>
					</tbody>
				</table>
			</div>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<%
						if (pagina == 0) {
					%>
					<li class="page-item"><a class="page-link" href="#">Anterior</a></li>
					<%
						}
						for (int i = 1; i <= quantidadeDeItensPaginacao; i++) {
					%>
					<li class="page-item <%=i == pagina ? "active" : ""%>"><a
						class="page-link" href="?pagina=<%=i%>"><%=i%></a></li>
					<%
						}
						if (pagina == quantidadeDeItensPaginacao) {
					%>
					<li class="page-item"><a class="page-link" href="#">Próximo</a></li>
					<%
						}
					%>
				</ul>
			</nav>
		</div>
	</div>
</div>