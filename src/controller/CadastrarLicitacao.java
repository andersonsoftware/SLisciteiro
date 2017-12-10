package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.GapContent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dao.LicitacaoDAO;
import model.Categoria;
import model.Fornecedor;
import model.Funcionario;
import model.Pessoa;
import model.Produto;
import util.Constantes;

public class CadastrarLicitacao extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LicitacaoDAO ld = new LicitacaoDAO();
		String descricao = request.getParameter("descricao");
		//float valor_estimado = Float.parseFloat(request.getParameter("valor_estimado"));
		Funcionario funcionario = new Funcionario();
		funcionario.setId(((Pessoa) request.getSession().getAttribute("usuario")).getId());
		//Object produtos  = new Object(){String produto; float quantidade;};
		List<Object> produto = new Gson().fromJson((String) request.getSession().getAttribute("listaProdutos"), new TypeToken<ArrayList<Object>>(){}.getType());
		System.out.println(produtos.get(0));
		//Date dataInicio = request.getParameter("");
		//Date dataFim = request.getParameter("");
		System.out.println(produtos.size());
		Categoria categoria = new Categoria();
		categoria.setId(Integer.parseInt(request.getParameter("categoria")));
	}
}
