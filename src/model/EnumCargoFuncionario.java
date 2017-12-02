package model;

public enum EnumCargoFuncionario {

	;

	public int GERENTE_COMPRAS = 1;

	public int GERENTE_SETOR = 2;

	public int SUPERVISOR = 3;

	private int cargo;

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

}
