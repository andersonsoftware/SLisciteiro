package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conta;
import util.Crypter;

public class ContaDAO extends DAO {
	
	public boolean autenticar(String login, String senha) throws SQLException {
		try {
			PreparedStatement stmt = getConn().prepareStatement(
					"SELECT COUNT(*) AS quantidade FROM public.\"Conta\" WHERE login = ? AND senha = ?;");
			stmt.setString(1, login);
			stmt.setString(2, Crypter.crypt(senha));
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int quantidade = rs.getInt("quantidade");
			close(rs, stmt);
			return quantidade == 1;
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	public Conta getByPessoaId(int pessoa_id) {
		try {
			PreparedStatement stmt = getConn().prepareStatement(
					"SELECT * AS quantidade FROM public.\"Conta\" WHERE pessoa_id = ?;");
			stmt.setInt(1, pessoa_id);			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Conta conta = new Conta(rs.getString("login"), rs.getString("senha"), null);
			close(rs, stmt);
			return conta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
	public void add(Conta conta, int pessoa_id) {
		try {
			PreparedStatement stmt = getConn().prepareStatement(
					"INSERT INTO public.\"Conta\" VALUES (?, ?, ?);");
			stmt.setString(1, conta.getLogin());
			stmt.setString(2, conta.getSenha());
			stmt.setInt(3, pessoa_id);
			stmt.execute();
		    stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public void editar(Conta conta){
		try {
			String sql = "UPDATE public.\"Conta\" SET login = ?, senha = ? WHERE pessoa_id = ?;";		
			PreparedStatement stmt = getConn().prepareStatement(sql);
			stmt.setString(1, conta.getLogin());			
			stmt.setString(2, conta.getSenha());
			stmt.setInt(3, conta.getPessoa().getId());							
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
