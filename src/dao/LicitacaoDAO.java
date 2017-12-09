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
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			if (rs.next()) {
				Licitacao licitacao = new Licitacao();
				licitacao.setDescricao(rs.getString("descricao"));
				licitacao.setId(rs.getInt("id_licitacao"));
				licitacao.setFuncionario(funcionarioDAO.buscarPorId(rs.getInt("id_funcionario")));
				licitacao.setCategoria(categoriaDAO.buscarPorId(rs.getInt("id_categoria")));
				licitacao.setValor_estimado(rs.getFloat("valor_estimado"));
				licitacao.setLancado(rs.getBoolean("lancado"));
				licitacao.setDataInicio(rs.getDate("data_inicio").toLocalDate());
				licitacao.setDataFim(rs.getDate("data_fim").toLocalDate());
				licitacao.setFornecedor(fornecedorDAO.);rs.getDate("id_fornecedor");
				licitacao.setEstado(rs.getBoolean("estado"));
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
