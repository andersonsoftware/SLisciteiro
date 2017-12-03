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
		HttpSession sessionVerify = (HttpSession)(((HttpServletRequest)request).getSession());
		String pagina = Constantes.PUBLICDIR+"home.jsp";
		HttpSession session = request.getSession();
		Funcionario pessoa = new Funcionario();
		pessoa.setCargo(1);
		pessoa.setCpf("000.000.000-00");
		pessoa.setRg("000000000-0");
		pessoa.setEmail("d@adsa.com");
		pessoa.setEndereco("Tv 15 de Novembro, nº79");
		pessoa.setId(1);
		pessoa.setMatricula(371541);
		pessoa.setNome("Matheus de Souza Oliveira");
		pessoa.setTelefone("(88)98803-3133");
		pessoa.setConta(new Conta("matheus", "matheus", pessoa));
		session.setAttribute("usuario", pessoa);
		request.setAttribute("sessao", session);
//		if (sessionVerify.getAttribute("usuario") == null) {					
//			String pagina = Constantes.ERROLOGIN;
//			String login_form = request.getParameter("login");
//			String senha_form = request.getParameter("senha");
//			ContaDAO conta = new ContaDAO();
//			try {
//				if (conta.autenticar(login_form, senha_form)) {
//					PessoaDAO pd = new PessoaDAO();
//					Pessoa pessoa = pd.getPessoa(login_form, senha_form);
//					HttpSession session = request.getSession();
//					session.setAttribute("usuario", pessoa);
//					request.setAttribute("sessao", session);
//					pagina = Constantes.PUBLICDIR+"home.jsp";
//					pd.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			conta.close();
//			response.sendRedirect(pagina);
//		}
		response.sendRedirect(pagina);
	}
	
}
