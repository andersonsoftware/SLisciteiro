package model;

public class Funcionario extends Pessoa {
	private EnumCargoFuncionario cargo;
	private String rg;
	private String cpf;
	private int matricula;
	
	public EnumCargoFuncionario getCargo() {
		return cargo;
	}

	public void setCargo(EnumCargoFuncionario cargo) {
		this.cargo = cargo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
