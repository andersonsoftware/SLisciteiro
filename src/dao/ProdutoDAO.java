package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Produto;

public class ProdutoDAO extends DAO {
	public List<Produto> buscarPorCategoria(Categoria categoria, int inicio, int fim) {
		try {
			super.open();
			List<Produto> disciplinas = new ArrayList<Produto>();
			String SQL = "SELECT * FROM produto WHERE id_categoria = ? LIMIT ? OFFSET ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, fim - inicio);
			ps.setInt(2, inicio);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();				
				produto.setId(rs.getInt("id_disciplina"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCategoria(new CategoriaDAO().buscarPorId(rs.getInt("id_categoria")));
				produto.setValor_estimado(rs.getFloat("valor_estimado"));
			}
			ps.close();
			rs.close();
			return disciplinas;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar disciplinas em JDBCDisciplinaDAO", e);

		} finally {
			super.close();
		}
	}
}
