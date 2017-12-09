package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conta;
import model.Pessoa;
import util.Crypter;

public class PessoaDAO extends DAO{
	public int addAndGetId(Pessoa pessoa){
		try {
			super.open();
			String sql = "INSERT INTO public.\"Pessoa\" (nome, email, endereco, telefone) VALUES (?, ?, ?, ?) RETURNING id_pessoa;";
			PreparedStatement stmt = getConnection().prepareStatement(sql);	
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getEndereco());
			stmt.setString(4, pessoa.getTelefone());
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");		
			close(rs, stmt);
			return id;					
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			super.close();
		}		
	}
	
	public int getIdByEmail(String email){
		try {
			super.open();
			String sql = "SELECT id FROM public.\"Pessoa\" WHERE email = ?;";			
			PreparedStatement stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			close(rs, stmt);
			return id;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			super.close();
		}
	}
	
	public Pessoa buscarPorId(int id){
		try {
			super.open();
			String sql = "SELECT * FROM public.\"Pessoa\" WHERE id_pessoa = ?;";			
			PreparedStatement stmt = super.getConnection().prepareStatement(sql);
			stmt.setInt(1, id);					
			ResultSet rs = stmt.executeQuery();					
			Pessoa pessoa = null;
			if (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(id);
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setTelefone(rs.getString("telefone"));
			}			
			super.close(rs, stmt);			
			return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			super.close();
		}
	}
	
	public void editar(Pessoa pessoa){
		try {
			super.open();
			String sql = "UPDATE public.\"Pessoa\" SET nome = ?, email = ?, endereco = ?, telefone = ? WHERE id_pessoa = ?;";
			PreparedStatement stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getEndereco());
			stmt.setString(4, pessoa.getTelefone());
			stmt.setInt(5, pessoa.getId());			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			super.close();
		}
	}
	
	public void excluir(int pessoa_id){
		try {			
			super.open();
			String sql = "DELETE FROM public.\"Pessoa\" WHERE id_pessoa = ?;";
			PreparedStatement stmt = getConnection().prepareStatement(sql);
			stmt.setInt(1, pessoa_id);					
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			super.close();
		}
	}

	public Pessoa getPessoa(String login, String senha) {
		try {
			super.open();
			PreparedStatement stmt = getConnection().prepareStatement(
					"SELECT * FROM public.\"Pessoa\" as P CROSS JOIN public.\"Conta\" as C WHERE P.id_pessoa = C.id_pessoa AND login = ? AND senha = ?;");
			stmt.setString(1, login);			
			stmt.setString(2, Crypter.crypt(senha));
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id_pessoa"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setEndereco(rs.getString("endereco"));
			pessoa.setTelefone(rs.getString("telefone"));
			pessoa.setConta(new Conta());
			pessoa.getConta().setLogin(rs.getString("login"));
			pessoa.getConta().setSenha(rs.getString("senha"));
			pessoa.getConta().setTipoConta(rs.getInt("tipo_usuario"));
			close(rs, stmt);
			return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			super.close();
		}
	}
	
}
