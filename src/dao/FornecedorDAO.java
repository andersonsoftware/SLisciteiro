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
				fornecedor.setPontuacao(rs.getInt("pontuacao"));
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

	public void cadastrar(Fornecedor fornecedor) {
		try {
			super.open();
			Pessoa pessoa = (Pessoa) fornecedor;
			int id = new PessoaDAO().addAndGetId(pessoa);
			new ContaDAO().add(fornecedor.getConta(), id);
			String SQL = "INSERT INTO public.\"Fornecedor\"(id_fornecedor, cnpj, pontuacao, conta_bancaria, agencia_bancaria, tipo_conta, banco) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ps.setString(2, fornecedor.getCnpj());
			ps.setInt(3, 50);
			ps.setString(4, fornecedor.getContaBancaria().getConta());
			ps.setString(5, fornecedor.getContaBancaria().getAgencia());
			ps.setString(6, fornecedor.getContaBancaria().getTipo());
			ps.setString(7, fornecedor.getContaBancaria().getBanco());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

}
