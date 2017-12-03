package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;
import util.Crypter;

public class PessoaDAO extends DAO{
	public int addAndGetId(Pessoa pessoa){
		try {			
			String sql = "INSERT INTO public.\"Pessoa\" (nome, cpf, rg) VALUES (?, ?, ?) RETURNING id;";
			PreparedStatement stmt = getConn().prepareStatement(sql);	
			stmt.setString(1, pessoa.getNome());
//			stmt.setString(2, pessoa.getCpf());
//			stmt.setString(3, pessoa.getRg());			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");		
			close(rs, stmt);
			return id;					
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public int getIdByCpfAndRg(String cpf, String rg){
		try {
			String sql = "SELECT id FROM public.\"Pessoa\" WHERE cpf = ? OR rg = ?;";			
			PreparedStatement stmt = getConn().prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setString(2, rg);			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			close(rs, stmt);
			return id;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pessoa getById(int id){
		try {
			String sql = "SELECT * FROM public.\"Pessoa\" WHERE id = ? LIMIT 1;";			
			PreparedStatement stmt = getConn().prepareStatement(sql);
			stmt.setInt(1, id);					
			ResultSet rs = stmt.executeQuery();
			rs.next();		
			Pessoa pessoa = new Pessoa();
			close(rs, stmt);			
			return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar(Pessoa pessoa){
		try {
			String sql = "UPDATE public.\"Pessoa\" SET nome = ?, cpf = ?, rg = ? WHERE id = ?;";
			PreparedStatement stmt = getConn().prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
//			stmt.setString(2, pessoa.getCpf());
//			stmt.setString(3, pessoa.getRg());
			stmt.setInt(4, pessoa.getId());			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(int pessoa_id){
		try {			
			String sql = "DELETE FROM public.\"Pessoa\" WHERE id = ?;";
			PreparedStatement stmt = getConn().prepareStatement(sql);
			stmt.setInt(1, pessoa_id);					
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Pessoa getPessoa(String login, String senha) {
		try {
			PreparedStatement stmt = getConn().prepareStatement(
					"SELECT * FROM public.\"Pessoa\" as P CROSS JOIN public.\"Conta\" as C WHERE P.id = C.pessoa_id AND login = ? AND senha = ?;");
			stmt.setString(1, login);			
			stmt.setString(2, Crypter.crypt(senha));
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(rs.getString("nome"));
			pessoa.getConta().setLogin(rs.getString("login"));
			pessoa.getConta().setSenha(rs.getString("senha"));
			close(rs, stmt);
			return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
