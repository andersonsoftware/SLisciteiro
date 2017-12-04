package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constantes;

public class CadastrarCategoria extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = Constantes.SUPERVISORDIR+"cadastroCategoria.jsp";
		response.sendRedirect(pagina+"?cadCategoria="+request.getParameter("nome"));
	}
}
