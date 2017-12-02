package model;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private Categoria categoria;
	private float valor_estimado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public float getValor_estimado() {
		return valor_estimado;
	}

	public void setValor_estimado(float valor_estimado) {
		this.valor_estimado = valor_estimado;
	}
}
