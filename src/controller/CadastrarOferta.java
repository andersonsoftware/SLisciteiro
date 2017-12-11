package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FornecedorDAO;
import dao.LicitacaoDAO;
import dao.OfertaDAO;
import model.Fornecedor;
import model.Licitacao;
import model.Oferta;
import model.Pessoa;
import util.Constantes;

/**
 * Servlet implementation class CadastrarOferta
 */
public class CadastrarOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionVerify = request.getSession();
		Pessoa pessoa = (Pessoa) sessionVerify.getAttribute("usuario");		
		int id_fornecedor = pessoa.getId();
		int id_licitacao = Integer.valueOf(request.getParameter("id_licitacao"));
		float valor = Float.valueOf(request.getParameter("valor"));
		OfertaDAO ofertaDAO = new OfertaDAO();
		Licitacao licitacao = new LicitacaoDAO().buscarPorId(id_licitacao);
		Fornecedor fornecedor = new FornecedorDAO().buscarPorId(id_fornecedor);
		if (ofertaDAO.buscarPorLicitacaoEFornecedor(licitacao, fornecedor) == null) {
			Oferta oferta = new Oferta();
			oferta.setFornecedor(fornecedor);
			oferta.setLicitacao(licitacao);
			oferta.setValor(valor);
			ofertaDAO.cadastrar(oferta);
		}else {
			//msg erro
		}
		response.sendRedirect(Constantes.FORNECEDORDIR+"home.jsp");
	}

}
