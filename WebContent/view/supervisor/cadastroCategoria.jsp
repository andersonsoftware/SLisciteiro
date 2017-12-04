<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<div class="container">
	<form id="formDoacaoItem" method="post" action="cadastrar_categoria">
		<h2>Cadastro de Categoria</h2>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="Text" id="nome"
					name="nome" class="form-control">
			</div>
		<div class="form-group">
			<input type="submit" value="Cadastrar" class="btn btn-success" >
		</div> 	
	</form>
</div>