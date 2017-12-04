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
function addListToSessoin(){
	 $('#table_produtos tbody tr').each(function () {
	        // Recuperar todas as colunas da linha percorida
	        var colunas = $(this).children();
	        
	        // Criar objeto para armazenar os dados (com JSON essa tarefa fica mais simples)
	        var pedido = {
	            'produto': $(colunas[0]).text(), // valor da coluna Produto
	            'quantidade': $(colunas[1]).text() // Valor da coluna Quantidade
	        };
	        pedidos.push(pedido);
	        document.getElementById('lista_produtos').value = JSON.stringify(pedidos); 
	        console.log(JSON.stringify(pedidos));
	        //$('#conteudo_tab_produtos').append(options);
	    });
}


