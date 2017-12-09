package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContaDAO;
import dao.PessoaDAO;
import model.Conta;
import model.Funcionario;
import model.Pessoa;
import util.Constantes;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessionVerify = (HttpSession) (((HttpServletRequest) request).getSession());
		String pagina = "";
		if (sessionVerify.getAttribute("usuario") == null) {
			String login_form = request.getParameter("login");
			String senha_form = request.getParameter("senha");
			ContaDAO conta = new ContaDAO();
			try {
				if (conta.autenticar(login_form, senha_form)) {
					PessoaDAO pd = new PessoaDAO();
					Pessoa pessoa = pd.getPessoa(login_form, senha_form);
					HttpSession session = request.getSession();
					session.setAttribute("usuario", pessoa);
					request.setAttribute("sessao", session);
					pagina = Constantes.PUBLICDIR+"home.jsp";
					pd.close();
				}else{
					pagina = Constantes.ERROLOGIN;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conta.close();
			response.sendRedirect(pagina);
		}else{
			pagina = Constantes.PUBLICDIR+"home.jsp";
			response.sendRedirect(pagina);
		}
		
	}

}
