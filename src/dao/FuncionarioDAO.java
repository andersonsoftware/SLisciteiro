package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;
import model.Pessoa;

public class FuncionarioDAO extends DAO {
	public Funcionario buscarPorId(int id) {
		try {
			super.open();
			String sql = "SELECT * FROM public.\"Funcionario\" WHERE id_funcionario = ?;";
			PreparedStatement stmt = super.getConnection().prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Funcionario funcionario = null;
			Pessoa pessoa = new PessoaDAO().buscarPorId(id);
			if (pessoa != null && rs.next()) {
				funcionario = new Funcionario();
				funcionario.setConta(pessoa.getConta());
				funcionario.setEmail(pessoa.getEmail());
				funcionario.setEndereco(pessoa.getEndereco());
				funcionario.setId(id);
				funcionario.setNome(pessoa.getNome());
				funcionario.setTelefone(pessoa.getTelefone());
				funcionario.setCargo(rs.getInt("cargo"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setRg(rs.getString("rg"));
			}
			super.close(rs, stmt);
			return funcionario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
}
