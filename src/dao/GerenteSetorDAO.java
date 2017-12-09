package dao;

import model.EnumCargoFuncionario;
import model.Funcionario;
import model.GerenteSetor;

public class GerenteSetorDAO extends DAO {
	public GerenteSetor buscarPorId(int id) {
		Funcionario funcionario = new FuncionarioDAO().buscarPorId(id);
		GerenteSetor gerenteSetor = null;
		if (funcionario != null && funcionario.getCargo().equals(EnumCargoFuncionario.GERENTE_SETOR)) {
			gerenteSetor = (GerenteSetor) funcionario;
			gerenteSetor.setSetores(new SetorDAO().buscarPorGerente(gerenteSetor));
		}
		return gerenteSetor;
	}
}
