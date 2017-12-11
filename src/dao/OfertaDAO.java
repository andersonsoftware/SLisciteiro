/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Fornecedor;
import model.Licitacao;
import model.Oferta;

/**
 * @author matheus
 *
 */
public class OfertaDAO extends DAO {

	public List<Oferta> listar(int inicio, int fim) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Oferta\" LIMIT ? OFFSET ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, fim);
			ps.setInt(2, inicio);
			ResultSet rs = ps.executeQuery();
			List<Oferta> ofertas = new ArrayList<Oferta>();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setId(rs.getInt("id_oferta"));
				oferta.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
				oferta.setLicitacao(licitacaoDAO.buscarPorId(rs.getInt("id_liscitacao")));
				oferta.setValor(rs.getFloat("valor"));
				ofertas.add(oferta);
			}
			super.close(rs, ps);
			return ofertas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public int cadastrar(Oferta oferta) {
		try {
			super.open();
			String SQL = "INSERT INTO public.\"Oferta\" (id_fornecedor, id_liscitacao, valor) VALUES (?, ?, ?) RETURNING id_oferta;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, oferta.getFornecedor().getId());
			ps.setInt(2, oferta.getLicitacao().getId());
			ps.setFloat(3, oferta.getValor());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("id_oferta");
			super.close(rs, ps);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public List<Oferta> buscarPorLicitacao(Licitacao licitacao) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Oferta\" WHERE id_liscitacao = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, licitacao.getId());
			ResultSet rs = ps.executeQuery();
			List<Oferta> ofertas = new ArrayList<Oferta>();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setId(rs.getInt("id_oferta"));
				oferta.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
				oferta.setLicitacao(licitacaoDAO.buscarPorId(rs.getInt("id_liscitacao")));
				oferta.setValor(rs.getFloat("valor"));
				ofertas.add(oferta);
			}
			super.close(rs, ps);
			return ofertas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public List<Oferta> buscarPorFornecedor(Fornecedor fornecedor) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Oferta\" WHERE id_fornecedor = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, fornecedor.getId());
			ResultSet rs = ps.executeQuery();
			List<Oferta> ofertas = new ArrayList<Oferta>();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setId(rs.getInt("id_oferta"));
				oferta.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
				oferta.setLicitacao(licitacaoDAO.buscarPorId(rs.getInt("id_liscitacao")));
				oferta.setValor(rs.getFloat("valor"));
				ofertas.add(oferta);
			}
			super.close(rs, ps);
			return ofertas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public List<Oferta> buscarPorCategoriaLicitacao(Categoria categoria) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Oferta\" AS oferta, public.\"Licitacao\" AS licitacao "
					+ "WHERE oferta.id_liscitacao = licitacao.id_licitacao AND licitacao.id_categoria = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, categoria.getId());
			ResultSet rs = ps.executeQuery();
			List<Oferta> ofertas = new ArrayList<Oferta>();
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setId(rs.getInt("id_oferta"));
				oferta.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
				oferta.setLicitacao(licitacaoDAO.buscarPorId(rs.getInt("id_liscitacao")));
				oferta.setValor(rs.getFloat("valor"));
				ofertas.add(oferta);
			}
			super.close(rs, ps);
			return ofertas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public Oferta buscarPorId(int id) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Oferta\" WHERE id_oferta = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Oferta oferta = null;
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
			if (rs.next()) {
				oferta = new Oferta();
				oferta.setId(rs.getInt("id_oferta"));
				oferta.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
				oferta.setLicitacao(licitacaoDAO.buscarPorId(rs.getInt("id_liscitacao")));
				oferta.setValor(rs.getFloat("valor"));
			}
			super.close(rs, ps);
			return oferta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

	public Oferta buscarPorLicitacaoEFornecedor(Licitacao licitacao, Fornecedor fornecedor) {
		try {
			super.open();
			String SQL = "SELECT * FROM public.\"Oferta\" WHERE id_liscitacao = ? AND id_fornecedor = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, licitacao.getId());
			ps.setInt(2, fornecedor.getId());
			ResultSet rs = ps.executeQuery();
			Oferta oferta = null;
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
			if (rs.next()) {
				oferta = new Oferta();
				oferta.setId(rs.getInt("id_oferta"));
				oferta.setFornecedor(fornecedorDAO.buscarPorId(rs.getInt("id_fornecedor")));
				oferta.setLicitacao(licitacaoDAO.buscarPorId(rs.getInt("id_liscitacao")));
				oferta.setValor(rs.getFloat("valor"));
			}
			super.close(rs, ps);
			return oferta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
	
	public void editar(Oferta oferta) {
		try {
			super.open();
			String SQL = "UPDATE public.\"Oferta\" SET id_fornecedor = ?, id_liscitacao = ?, valor = ? WHERE id_oferta = ?;";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, oferta.getFornecedor().getId());
			ps.setInt(2, oferta.getLicitacao().getId());
			ps.setFloat(3, oferta.getValor());
			ps.setInt(4, oferta.getId());
			ps.executeQuery();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}

}
