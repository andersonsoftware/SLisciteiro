package model;

public class Funcionario extends Pessoa {
	private EnumCargoFuncionario cargo;
	private String rg;
	private String cpf;
	private int matricula;
	
	public EnumCargoFuncionario getCargo() {
		return cargo;
	}
	
	public void setCargo(int cargo) {
		if (EnumCargoFuncionario.GERENTE_COMPRAS.getCargo() == cargo)
			this.cargo = EnumCargoFuncionario.GERENTE_COMPRAS;
		else if (EnumCargoFuncionario.GERENTE_SETOR.getCargo() == cargo)
			this.cargo = EnumCargoFuncionario.GERENTE_SETOR;
		else if (EnumCargoFuncionario.SUPERVISOR.getCargo() == cargo)
			this.cargo = EnumCargoFuncionario.SUPERVISOR;
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
	
	public boolean isCargo(EnumCargoFuncionario enumCargoFuncionario ){
		return this.getCargo().equals(enumCargoFuncionario);		
	}
}
