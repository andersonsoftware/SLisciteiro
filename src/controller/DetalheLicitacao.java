package controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LicitacaoDAO;
import model.Licitacao;

public class DetalheLicitacao extends HttpServlet {

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
				Licitacao licitacao = new LicitacaoDAO().buscarPorId(id);
				Gson gson = new Gson();
				String json = gson.toJson(licitacao);
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
