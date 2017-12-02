package model;

public class Funcionario extends Pessoa {

	public EnumCargoFuncionario getCargo() {
		return cargo;
	}

	public void setCargo(EnumCargoFuncionario cargo) {
		this.cargo = cargo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
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

	private EnumCargoFuncionario cargo;

	private Conta conta;

	private String rg;

	private String cpf;

	private int matricula;

	public boolean isCargo(EnumCargoFuncionario enumCargoFuncionario) {
		return false;
	}

}
