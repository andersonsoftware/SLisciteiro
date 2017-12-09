package model;

public class Categoria {
	private int id;
	private String nome;
	private Setor setor;
	
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

	/**
	 * @return the setor
	 */
	public Setor getSetor() {
		return setor;
	}

	/**
	 * @param setor the setor to set
	 */
	public void setSetor(Setor setor) {
		this.setor = setor;
	}	
	
}
