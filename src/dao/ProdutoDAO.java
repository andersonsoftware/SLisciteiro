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
			List<Produto> produtos = new ArrayList<Produto>();
			String SQL = "SELECT * FROM public.\"Produto\" WHERE id_categoria = ? LIMIT ? OFFSET ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, categoria.getId());
			ps.setInt(2, fim - inicio);
			ps.setInt(3, inicio);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();				
				produto.setId(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCategoria(new CategoriaDAO().buscarPorId(rs.getInt("id_categoria")));
				produto.setValor_estimado(rs.getFloat("valor_estimado"));
				produtos.add(produto);
			}
			ps.close();
			rs.close();
			return produtos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar produtos", e);

		} finally {
			super.close();
		}
	}
}
