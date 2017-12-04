package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constantes;

public class CadastrarLicitacao extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("lista_produtos"));
		String pagina = Constantes.SUPERVISORDIR+"home.jsp";
		response.sendRedirect(pagina+"?licitacaoRealizada=1");
	}
}
