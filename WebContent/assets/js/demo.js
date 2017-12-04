var qtd_linha = 0;
$(function(){
	$('#add_produto').click(function() {
		qtd_linha++;
		var options = '<tr><td>'+$('#produto').val()+'</td><td>'+$('#quantidade_produto').val()+'</td><td> <input type="button" value="Delete" class="btn btn-danger form-control" onclick="deleteRow(this.parentNode.parentNode.rowIndex)"> </td></tr>'
		$('#conteudo_tab_produtos').append(options);
	});
});


function deleteRow(i){
    document.getElementById('table_produtos').deleteRow(i)
}

var pedidos = [];
function addListReturn(){
	 $('#table_produtos tbody tr').each(function () {
	        var colunas = $(this).children();
	        var pedido = {
	            'produto': $(colunas[0]).text(), 
	            'quantidade': $(colunas[1]).text()
	        };
	        pedidos.push(pedido);
	        document.getElementById('lista_produtos').value = JSON.stringify(pedidos); 
	    });
}


