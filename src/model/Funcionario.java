package Diagrama de Classe;

public class Funcionario extends PessoaFisica, Pessoa {

	private EnumCargoFuncionario cargo;

	private Conta conta;

	private String rg;

	private String cpf;

	private int matricula;

	public boolean isCargo(EnumCargoFuncionario enumCargoFuncionario) {
		return false;
	}

}
