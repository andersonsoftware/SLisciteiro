package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Licitacao;

public class LicitacaoDAO extends DAO {

	public List<Licitacao> listar(int inicio, int fim) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Licitacao\" LIMIT ? OFFSET ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, fim);
			ps.setInt(2, fim - inicio);
			ResultSet rs = ps.executeQuery();
			List<Licitacao> licitacoes = new ArrayList<Licitacao>();
			SetorDAO setorDAO = new SetorDAO();
			if (rs.next()) {
				Licitacao licitacao = new Licitacao();
				licitacao = new Licitacao();
				licitacao.setDescricao(rs.getString("descricao"));
				licitacao.setId(rs.getInt("id"));
				licitacao.setId(rs.getInt("id_categoria"));
				licitacoes.add(licitacao);
			}
			ps.close();
			rs.close();
			return licitacoes;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

}
