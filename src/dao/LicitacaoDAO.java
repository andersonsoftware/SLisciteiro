package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Licitacao;
import model.Produto;
import model.ProdutoLicitacao;

public class LicitacaoDAO extends DAO {

	public List<Licitacao> listar(int inicio, int fim) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Licitacao\" LIMIT ? OFFSET ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, fim);
			ps.setInt(2, inicio);
			ResultSet rs = ps.executeQuery();
			List<Licitacao> licitacoes = new ArrayList<Licitacao>();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			while (rs.next()) {
				Licitacao licitacao = new Licitacao();
				licitacao.setDescricao(rs.getString("descricao"));
				licitacao.setId(rs.getInt("id_licitacao"));
				licitacao.setFuncionario(funcionarioDAO.buscarPorId(rs.getInt("id_funcionario")));
				licitacao.setCategoria(categoriaDAO.buscarPorId(rs.getInt("id_categoria")));
				licitacao.setValor_estimado(rs.getFloat("valor_estimado"));
				licitacao.setLancado(rs.getBoolean("lancado"));
				licitacao.setDataInicio(rs.getDate("data_inicio"));
				licitacao.setDataFim(rs.getDate("data_fim"));
				licitacao.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
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

	public int cadastrar(Licitacao licitacao) {
		try {
			super.open();
			String SQL = "INSERT INTO public.\"Licitacao\" (descricao, id_funcionario, id_categoria, valor_estimado, lancado, data_inicio,"
					+ " data_fim, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_licitacao;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, licitacao.getDescricao());
			ps.setInt(2, licitacao.getFuncionario().getId());
			ps.setInt(3, licitacao.getCategoria().getId());
			ps.setFloat(4, licitacao.getValor_estimado());
			ps.setBoolean(5, false);
			ps.setDate(6, licitacao.getDataInicio());
			ps.setDate(7, licitacao.getDataFim());
			ps.setBoolean(8, false);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("id_licitacao");
			for(ProdutoLicitacao pl : licitacao.getProdutos()){
				cadastrarProdLicitacao(pl, id);
			}
			close(rs, ps);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public int buscarQntdDeLicitacoes() {
		try {
			super.open();
			String SQL = "SELECT COUNT(*) AS quantidade FROM public.\"Licitacao\";";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int quantidade = rs.getInt("quantidade");
			super.close(rs, ps);
			return quantidade;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
	
	public void cadastrarProdLicitacao(ProdutoLicitacao produto, int idLicitacao) {
		try {
			super.open();
			String SQL = "INSERT INTO public.\"LicitacaoProduto\" (id_licitacao, id_produto, quantidade) VALUES (?, ?, ?);";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, idLicitacao);
			ps.setInt(2, produto.getProd().getId());
			ps.setInt(3, produto.getQuantidade());
			ResultSet rs = ps.executeQuery();
			super.close(rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public void editar(Licitacao licitacao) {
		try {
			super.open();
			String SQL = "UPDATE public.\"Licitacao\" SET descricao = ?, id_funcionario = ?, id_categoria = ?, valor_estimado = ?, lancado = ?, data_inicio = ?,"
					+ " data_fim = ?, estado = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, licitacao.getDescricao());
			ps.setInt(2, licitacao.getFuncionario().getId());
			ps.setInt(3, licitacao.getCategoria().getId());
			ps.setFloat(4, licitacao.getValor_estimado());
			ps.setBoolean(5, licitacao.isLancado());
			ps.setDate(6, licitacao.getDataInicio());
			ps.setDate(7, licitacao.getDataFim());
			ps.setBoolean(8, licitacao.isEstado());
			ResultSet rs = ps.executeQuery();
			super.close(rs, ps);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public void removerProduto(Licitacao licitacao, Produto produto) {
		try {
			super.open();
			String SQL = "DELETE FROM public.\"LicitacaoProduto\" WHERE id_licitacao = ? AND id_produto = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, licitacao.getId());
			ps.setInt(2, produto.getId());
			ResultSet rs = ps.executeQuery();
			super.close(rs, ps);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public Licitacao buscarPorId(int id) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Licitacao\" WHERE id_licitacao = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Licitacao licitacao = null;
			if (rs.next()) {
				licitacao = new Licitacao();
				licitacao.setDescricao(rs.getString("descricao"));
				licitacao.setId(rs.getInt("id_licitacao"));
				licitacao.setFuncionario(new FuncionarioDAO().buscarPorId(rs.getInt("id_funcionario")));
				licitacao.setCategoria(new CategoriaDAO().buscarPorId(rs.getInt("id_categoria")));
				licitacao.setValor_estimado(rs.getFloat("valor_estimado"));
				licitacao.setLancado(rs.getBoolean("lancado"));
				licitacao.setDataInicio(rs.getDate("data_inicio"));
				licitacao.setDataFim(rs.getDate("data_fim"));
				licitacao.setFornecedor(new FornecedorDAO().buscarPorId(rs.getInt("id_fornecedor")));
				licitacao.setEstado(rs.getBoolean("estado"));
			}
			super.close(rs, ps);
			return licitacao;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
	
}
