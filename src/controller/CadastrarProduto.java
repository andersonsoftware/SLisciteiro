package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Categoria;
import model.Produto;
import util.Constantes;

public class CadastrarProduto extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = Constantes.SUPERVISORDIR+"cadastroProduto.jsp";
		ProdutoDAO pd = new ProdutoDAO();
		Produto produto = new Produto();
		produto.setNome(request.getParameter("nome"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setCategoria(new Categoria());
		produto.getCategoria().setId(Integer.parseInt(request.getParameter("categoria")));
		produto.setValor_estimado(Float.parseFloat(request.getParameter("valor_estimado")));
		pd.add(produto);
		response.sendRedirect(pagina+"?cadProduto="+request.getParameter("nome"));
	}
}
