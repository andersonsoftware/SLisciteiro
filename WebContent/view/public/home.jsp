
<%@page import="model.Funcionario"%>
<%
	Funcionario user = (Funcionario) request.getSession().getAttribute("usuario");
%>
<div class="table-responsive">
	<table
		class="table table-striped table-bordered table-hover table-condensed">
		<thead>
			<th>Nome</th>
			<th>CPF</th>
			<th>E-mail</th>
			<th>Cargo</th>
		</thead>
		<tbody>
			<tr>
				<td><%=user.getNome()%></td>
				<td><%=user.getCpf()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getCargo().toString()%></td>
			</tr>
		</tbody>
	</table>
</div>