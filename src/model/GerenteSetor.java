package model;

import java.util.ArrayList;
import java.util.List;

public class GerenteSetor extends Funcionario{
	private List<Setor> setores;

	public GerenteSetor() {
		this.setSetores(new ArrayList<Setor> ());
	}
	
	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
}
