package model;

import java.util.List;

public class Licitacao {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor_estimado() {
		return valor_estimado;
	}

	public void setValor_estimado(float valor_estimado) {
		this.valor_estimado = valor_estimado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	private int id;

	private String descricao;

	private float valor_estimado;

	private Funcionario funcionario;

	private List<Produto> produtos;

}
