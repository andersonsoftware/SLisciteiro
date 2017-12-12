package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.LicitacaoDAO;
import dao.ProdutoDAO;
import model.Licitacao;
import model.Produto;
import model.ProdutoLicitacao;

public class ProdutosLicitacao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo = request.getParameter("id");
		response.setCharacterEncoding("UTF-8");
		if (codigo != null && !codigo.equals("")) {
			int id = Integer.valueOf(codigo);
			System.out.println("id: " + id);
			try {
				ProdutoDAO pd = new ProdutoDAO();
				List<Produto> produtos = pd.buscarPorLicitacao(id);
				Gson gson = new Gson();
				String json = gson.toJson(produtos);
				System.out.println("json" + json);
				response.setContentType("application/json");
				response.getWriter().write(json);
			} catch (Exception e) {
				response.setStatus(500);
				response.getWriter().write(e.getMessage());
			}
		} else {
			response.setStatus(500);
			response.getWriter().write("Campo código não encontrado");
		}
	}

}
