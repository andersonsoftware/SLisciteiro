$(function(){
	$('#add_produto').click(function() {
		if($('#produto').val() === null || $('#quantidade_produto').val() === null || $('#quantidade_produto').val()<1 ){
				alert('Por favor, selecione um produto e a quantidade!');
				document.getElementById("produto").focus();
		}else{
			var options = '<tr><td>'+$('#produto').val()+'</td><td>'+$('#quantidade_produto').val()+'</td><td> <input type="button" value="Delete" class="btn btn-danger form-control" onclick="deleteRow(this.parentNode.parentNode.rowIndex)"> </td></tr>'
			$('#conteudo_tab_produtos').append(options);
			addListReturn();
			var encoding_uri = encodeURI(document.getElementById('lista_produtos').value);
			$.getJSON('set_session_produtos?jsonProdutos='+encoding_uri);
		}
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

$(function(){
	$('#categoria').change(function() {
		var tam = jQuery("#table_produtos tbody tr").length;
		for(var j = tam-1; j>=0;j--){
			document.getElementById('conteudo_tab_produtos').deleteRow(j);
		}
		addListReturn();
		var encoding_uri = encodeURI(document.getElementById('lista_produtos').value);
		$.getJSON('set_session_produtos?jsonProdutos='+encoding_uri);
		$.getJSON('carregarProdutos?idCategoria='+$('#categoria').val(), function(data){
			if(data !== null){
				var options = '<option value="" disabled="disabled" selected="selected">Selecione um produto</option>';	
				for (var i = 0; i < data.length; i++) {
					options += '<option value="' + data[i].nome+ '">' + data[i].nome + '</option>';
					console.log(options);
				}	
				$('#produto').html(options).show();
			}else{
				$('#produto').html('<option value="" disabled="disabled" selected="selected">Selecione um produto</option>').show();
			}
		});
	});
});

$(function() {
	var $btnDetalhes = $(".btn_detalhes");
	$btnDetalhes.on('click', function($btnDetalhes) {
		$.ajax({
			type : "POST",
			url : "/SLisciteiro/view/fornecedor/detalheLicitacao",
			data : {
				id : $btnDetalhes.currentTarget.attributes[2].nodeValue
			},
			success : function(data) {
				$("#descricao").html('<b>DESC:</b> '+data.descricao);
				$("#valor_estimado").html("<b>VALOR ESTIMADO:</b> "+data.valor_estimado);
				$("#id_licitacao").val(data.id);
			}
		}),
		$.ajax({
			type : "POST",
			url : "/SLisciteiro/view/fornecedor/licitacaoProdutos",
			data : {
				id : $btnDetalhes.currentTarget.attributes[2].nodeValue
			},
			success : function(data) {
				var options = '';	
				for (var i = 0; i < data.length; i++) {
					options += 'NOME: '+data[i].nome +' <br>QUANTIDADE: '+data[i].id+'<br><br>';
					console.log(options);
				}
				options+= '<br>'
				$('#produtos').html(options).show();
			}
		});
	});

});