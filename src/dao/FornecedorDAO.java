package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;
import model.Fornecedor;

public class FornecedorDAO extends DAO {
	public Fornecedor buscarPorId(int id) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Fornecedor\" WHERE id_fornecedor = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Fornecedor fornecedor = null;
			if (rs.next()) {
				fornecedor = new Fornecedor();
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setId(rs.getInt("id_fornecedor"));
				fornecedor.setPontuacao(rs.getFloat("pontuacao"));
				fornecedor.setContaBancaria(rs.getString("conta_bancaria"));
			}
			ps.close();
			rs.close();
			return categoria;			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

}
