package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conta;
import util.Crypter;

public class ContaDAO extends DAO {
	
	public boolean autenticar(String login, String senha) throws SQLException {
		try {
			super.open();
			PreparedStatement stmt = this.getConnection().prepareStatement(
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
		} finally {
			super.close();
		}
	}
	
	public Conta getByPessoaId(int pessoa_id) {
		try {
			super.open();
			PreparedStatement stmt = this.getConnection().prepareStatement(
					"SELECT * AS quantidade FROM public.\"Conta\" WHERE pessoa_id = ?;");
			stmt.setInt(1, pessoa_id);			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Conta conta = new Conta();
			conta.setLogin(rs.getString("login"));
			conta.setSenha(rs.getString("senha"));
			conta.setTipoConta(rs.getInt("tipo_conta"));
			conta.setPessoa(new PessoaDAO().buscarPorId(pessoa_id));
			close(rs, stmt);
			return conta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
		
	public void add(Conta conta, int pessoa_id) {
		try {
			super.open();
			PreparedStatement stmt = this.getConnection().prepareStatement(
					"INSERT INTO public.\"Conta\" VALUES (?, ?, ?);");
			stmt.setString(1, conta.getLogin());
			stmt.setString(2, Crypter.crypt(conta.getSenha()));
			stmt.setInt(3, pessoa_id);
			stmt.execute();
		    stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
	

	public void editar(Conta conta){
		try {
			super.open();
			String sql = "UPDATE public.\"Conta\" SET login = ?, senha = ? WHERE pessoa_id = ?;";		
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getLogin());			
			stmt.setString(2, conta.getSenha());
			stmt.setInt(3, conta.getPessoa().getId());							
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			super.close();
		}
	}
}
