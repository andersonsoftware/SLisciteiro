package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import model.Categoria;
import model.Setor;
import util.Constantes;

public class CadastrarCategoria extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = Constantes.SUPERVISORDIR+"cadastroCategoria.jsp";
		CategoriaDAO cd =  new CategoriaDAO();
		Categoria categoria = new Categoria();
		categoria.setNome(request.getParameter("nome"));
		Setor setor = new Setor();
		setor.setId(Integer.parseInt(request.getParameter("setor")));
		categoria.setSetor(setor);
		cd.cadastrar(categoria);
		response.sendRedirect(pagina+"?cadCategoria="+request.getParameter("nome"));
	}
}
