package model;

public class Setor {

	private int id;

	private int nome;

	private GerenteSetor gerente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
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

	private float teto_gastos;

}
