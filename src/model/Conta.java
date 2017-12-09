package model;

public class Conta {
	private String login;
	private String senha;
	private Pessoa pessoa;
	private EnumTipoConta tipoConta;
	
	public Conta(){}
	
	public Conta(String login, String senha, Pessoa pessoa) {
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public EnumTipoConta getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(int tipoConta) {
		if (EnumTipoConta.FUNCIONARIO.getConta() == tipoConta)
			this.tipoConta = EnumTipoConta.FUNCIONARIO;
		else if (EnumTipoConta.FORNECEDOR.getConta() == tipoConta)
			this.tipoConta = EnumTipoConta.FORNECEDOR;
	}
	
	public void setCargo(EnumTipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public boolean isTipoConta(EnumTipoConta enumTipoConta ){
		return this.getTipoConta().equals(enumTipoConta);		
	}
}
