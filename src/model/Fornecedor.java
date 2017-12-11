package model;

import java.util.List;

public class Fornecedor extends Pessoa {
	private String cnpj;
	private int pontuacao;
	private ContaBancaria contaBancaria;
	private List<Categoria> categorias;

	public Fornecedor() {
		super();
	}
	
	public Fornecedor(String nome, String telefone, String email, String endereco, Conta conta, String cnpj, int pontuacao, ContaBancaria contaBancaria, List<Categoria> categorias) {
		super(nome, telefone, email, endereco, conta);
		this.cnpj = cnpj;
		this.pontuacao = pontuacao;
		this.contaBancaria = contaBancaria;
		this.categorias = categorias;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
