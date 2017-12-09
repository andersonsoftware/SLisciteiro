package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Produto;
import model.Setor;

public class CategoriaDAO extends DAO {
	public void cadastrar(Categoria categoria) {
		try {
			super.open();
			String SQL = "INSERT INTO public.\"Categoria\"(nome, id_setor) VALUES (?, ?);";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, categoria.getNome());
			ps.setInt(2, categoria.getSetor().getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
	
	public Categoria buscarPorId(int id) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Categoria\" WHERE id_categoria = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Categoria categoria = null;
			if (rs.next()) {
				categoria = new Categoria();
				categoria.setNome(rs.getString("nome"));
				categoria.setSetor(new SetorDAO().buscarPorId(rs.getInt("id_setor")));
				categoria.setId(rs.getInt("id_categoria"));
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
