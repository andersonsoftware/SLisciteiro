$(function(){
	$('#add_produto').click(function() {
		var options = '<tr><td>'+$('#produto').val()+'</td><td>'+$('#quantidade_produto').val()+'</td><td> <input type="button" value="Delete" class="btn btn-danger form-control" onclick="deleteRow(this.parentNode.parentNode.rowIndex)"> </td></tr>'
		$('#conteudo_tab_produtos').append(options);
		addListReturn();
		var encoding_uri = encodeURI(document.getElementById('lista_produtos').value);
		$.getJSON('set_session_produtos?jsonProdutos='+encoding_uri);
	});
});

function carregarProdSession(data){
	var produtos = data;
	var options = '';
	for(var i = 0; i < produtos.length; i++){
		 options  += '<tr><td>'+produtos[i].produto+'</td><td>'+produtos[i].quantidade+'</td><td> <input type="button" value="Delete" class="btn btn-danger form-control" onclick="deleteRow(this.parentNode.parentNode.rowIndex)"> </td></tr>'
	};	
	$('#conteudo_tab_produtos').append(options);
}

function deleteRow(i){
    document.getElementById('table_produtos').deleteRow(i)
    addListReturn();
    var encoding_uri = encodeURI(document.getElementById('lista_produtos').value);
    $.getJSON('set_session_produtos?jsonProdutos='+encoding_uri);
}

var produtos = [];

function addListReturn(){
	produtos = [];
	 $('#table_produtos tbody tr').each(function () {
	        var colunas = $(this).children();
	        var produto = {
	            'produto': $(colunas[0]).text(), 
	            'quantidade': $(colunas[1]).text()
	        };
	        produtos.push(produto);
	        var jsonProdutos = JSON.stringify(produtos);
	        document.getElementById('lista_produtos').value = jsonProdutos;
	        return jsonProdutos;
	    });
}

