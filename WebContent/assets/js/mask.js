$(document).ready(function() {
	$("#banco").change(function() {
		var banco = $(this).val();
		document.getElementById("agencia").disabled = false;
		document.getElementById("conta").disabled = false;
		if (banco == 'BB') {
			$("#agencia").val('');
			$("#conta").val('');
			$("#agencia").mask('0000-0');
			$("#conta").mask('0000-0');
		} else if (banco == 'BRA') {
			$("#agencia").val('');
			$("#conta").val('');
			$("#agencia").mask('0000');
			$("#conta").mask('0000000-0');
		} else if (banco == 'CA') {
			$("#agencia").val('');
			$("#conta").val('');
			$("#agencia").mask('0000');
			$("#conta").mask('000000000');
		} else if (banco == 'SA') {
			$("#agencia").val('');
			$("#conta").val('');
			$("#agencia").mask('0000');
			$("#conta").mask('0000000000');
		} else if (banco == 'IT') {
			$("#agencia").val('');
			$("#conta").val('');
			$("#agencia").mask('0000');
			$("#conta").mask('00000-0');
		} else {
			$("#agencia").val('');
			$("#conta").val('');
			document.getElementById("agencia").disabled = true;
			document.getElementById("conta").disabled = true;
		}
	})
})
$(document).ready(function() {
	$("#cpf").mask('000.000.000-00');
	$("#telefone").mask('(00)0000-0000');
	$("#cnpj").mask('00.000.000/0000-00');
})

$(document).ready(function($) {
	$("#money").maskMoney({
		decimal : ",",
		thousands : "."
	});
});

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