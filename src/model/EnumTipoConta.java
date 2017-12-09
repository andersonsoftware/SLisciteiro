package model;

public enum EnumTipoConta {
	FUNCIONARIO(1),
	FORNECEDOR(2);
	
	private int conta;
	
	private EnumTipoConta(int conta) {
		this.conta = conta;
	}
	
	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public String toString(){
		if(EnumTipoConta.FUNCIONARIO.equals(this.conta)){
			return "FUNCIONARIO";
		}else if(EnumTipoConta.FORNECEDOR.equals(this.conta)){
			return "FORNECEDOR";
		}
		return null;
	}

}
