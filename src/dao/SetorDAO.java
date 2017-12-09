package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.GerenteSetor;
import model.Setor;

public class SetorDAO extends DAO {

	public Setor buscarPorId(int id) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Setor\" WHERE id_setor = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Setor setor = null;
			if (rs.next()) {
				setor = new Setor();
				setor.setNome(rs.getString("nome"));
				setor.setTeto_gastos(rs.getFloat("teto_gastos"));
				setor.setGerente(new GerenteSetorDAO().buscarPorId(rs.getInt("id_gerente")));
			}
			super.close(rs, ps);
			return setor;			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
	
	public List<Setor> buscarPorGerente(GerenteSetor gerenteSetor) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Setor\" WHERE id_gerente = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, gerenteSetor.getId());
			ResultSet rs = ps.executeQuery();
			List<Setor> setores = new ArrayList<Setor> ();
			while (rs.next()) {
				Setor setor = new Setor();
				setor.setNome(rs.getString("nome"));
				setor.setTeto_gastos(rs.getFloat("teto_gastos"));
				setor.setGerente(new GerenteSetorDAO().buscarPorId(rs.getInt("id_gerente")));
				setores.add(setor);
			}
			super.close(rs, ps);
			return setores;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

}
