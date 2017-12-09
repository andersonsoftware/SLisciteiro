package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao.CategoriaDAO;
import dao.ProdutoDAO;

public class CarregarProdutosCategoria extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		ProdutoDAO pd = new ProdutoDAO();
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		System.out.println(idCategoria);
		String result = gson.toJson(pd.buscarPorCategoria(new CategoriaDAO().buscarPorId(idCategoria), 0, 100));
		System.out.println(result);
		response.setContentType("application/json");
		response.getWriter().print(result);
	}
}
