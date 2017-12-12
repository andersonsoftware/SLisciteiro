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
	
	public List<Produto> buscarPorLicitacao(int id_licitacao) {
		try {
			super.open();
			List<Produto> produtos = new ArrayList<Produto>();
			String SQL = "SELECT * FROM public.\"Produto\" AS p, public.\"LicitacaoProduto\" AS lp WHERE lp.id_licitacao = ? AND p.id_produto = lp.id_produto;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id_licitacao);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();				
				produto.setId(rs.getInt("quantidade"));
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

	
	public Produto buscarPorNome(String nome) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Produto\" WHERE nome = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Produto produto = new Produto();				
			produto.setId(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setCategoria(new CategoriaDAO().buscarPorId(rs.getInt("id_categoria")));
			produto.setValor_estimado(rs.getFloat("valor_estimado"));
			ps.close();
			rs.close();
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar produtos", e);
		} finally {
			super.close();
		}
	}
	
	public void add(Produto produto) {
		try {
			super.open();
			String SQL = "INSERT INTO public.\"Produto\" (nome, descricao, id_categoria, valor_estimado) VALUES (?, ?, ?, ?) ";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getCategoria().getId());
			ps.setFloat(4, produto.getValor_estimado());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
}
