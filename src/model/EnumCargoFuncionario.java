package model;

public enum EnumCargoFuncionario {
	GERENTE_COMPRAS(1),
	GERENTE_SETOR(2),
	SUPERVISOR(3);
	
	private int cargo;
	
	private EnumCargoFuncionario(int cargo) {
		this.cargo = cargo;
	}
	
	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	public String toString(){
		if(EnumCargoFuncionario.GERENTE_COMPRAS.equals(this.cargo)){
			return "GERENTE DE COMPRAS";
		}else if(EnumCargoFuncionario.GERENTE_SETOR.equals(this.cargo)){
			return "GERENTE DE SETOR";
		}else if(EnumCargoFuncionario.SUPERVISOR.equals(this.cargo)){
			return "SUPERVISOR";
		}
		return null;
	}

}
