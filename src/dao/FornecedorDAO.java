package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;
import model.ContaBancaria;
import model.Fornecedor;
import model.Pessoa;

public class FornecedorDAO extends DAO {
	public Fornecedor buscarPorId(int id) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Fornecedor\" WHERE id_fornecedor = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Pessoa pessoa = new PessoaDAO().buscarPorId(id); 
			Fornecedor fornecedor = null;
			if (pessoa != null && rs.next()) {
				fornecedor = new Fornecedor();
				fornecedor.setNome(pessoa.getNome());
				fornecedor.setId(rs.getInt("id_fornecedor"));
				fornecedor.setPontuacao(rs.getFloat("pontuacao"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				ContaBancaria contaBancaria = new ContaBancaria();
				contaBancaria.setAgencia(rs.getString("agencia_bancaria"));
				contaBancaria.setBanco(rs.getString("banco"));
				contaBancaria.setConta(rs.getString("conta_bancaria"));
				contaBancaria.setTipo(rs.getString("tipo_conta"));
				fornecedor.setContaBancaria(contaBancaria);				
				fornecedor.setEmail(pessoa.getEmail());
				fornecedor.setEndereco(pessoa.getEndereco());
				fornecedor.setTelefone(pessoa.getTelefone());
				
			}
			ps.close();
			rs.close();
			return fornecedor;			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

}
