package model;

public class Setor {
	private int id;
	private String nome;
	private GerenteSetor gerente;
	private float teto_gastos;
	
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

	public GerenteSetor getGerente() {
		return gerente;
	}

	public void setGerente(GerenteSetor gerente) {
		this.gerente = gerente;
	}

	public float getTeto_gastos() {
		return teto_gastos;
	}

	public void setTeto_gastos(float teto_gastos) {
		this.teto_gastos = teto_gastos;
	}

}
