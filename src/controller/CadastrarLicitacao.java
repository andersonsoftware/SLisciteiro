package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
import dao.ProdutoDAO;
import model.Categoria;
import model.Funcionario;
import model.Licitacao;
import model.Pessoa;
import model.Produto;
import model.ProdutoLicitacao;
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
		float valor_estimado = Float.parseFloat(request.getParameter("valor_estimado"));
		Funcionario funcionario = new Funcionario();
		funcionario.setId(((Pessoa) request.getSession().getAttribute("usuario")).getId());
		List<ProdutoLicitacao> prodLic = new Gson().fromJson((String) request.getSession().getAttribute("listaProdutos"), new TypeToken<ArrayList<ProdutoLicitacao>>(){}.getType());
		System.out.println(prodLic.size());
		for(ProdutoLicitacao pl : prodLic){
			Produto p = new ProdutoDAO().buscarPorNome(pl.getProduto());
			pl.setProd(p);
		}
		Date dataInicio = Date.valueOf(LocalDate.now());
		Date dataFim = Date.valueOf(request.getParameter("data_fim"));
		Categoria categoria = new Categoria();
		categoria.setId(Integer.parseInt(request.getParameter("categoria")));
		Licitacao licitacao = new Licitacao(descricao, valor_estimado, funcionario, prodLic, dataInicio, dataFim, categoria);
		licitacao.setProdutos(prodLic);
		ld.cadastrar(licitacao);
		response.sendRedirect(Constantes.SUPERVISORDIR+"cadastroLicitacao.jsp?licitacaoRealizada=1");
	}
}
