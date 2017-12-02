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

}
