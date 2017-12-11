package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FornecedorDAO;
import model.Categoria;
import model.Conta;
import model.ContaBancaria;
import model.EnumTipoConta;
import model.Fornecedor;
import util.Constantes;

public class CadastrarFornecedor extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = Constantes.URL+"login.jsp";
		FornecedorDAO fd = new FornecedorDAO();
		String nome = request.getParameter("nome"); 
		String cnpj = request.getParameter("cnpj"); 
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		ContaBancaria contaBancaria = new ContaBancaria();
		contaBancaria.setBanco(request.getParameter("banco"));
		contaBancaria.setTipo(request.getParameter("tipo_conta"));
		contaBancaria.setAgencia(request.getParameter("agencia"));
		contaBancaria.setConta(request.getParameter("conta"));
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Fornecedor fornecedor = new Fornecedor(nome, telefone, email, endereco, new Conta(login, senha, EnumTipoConta.FORNECEDOR), cnpj, 50, contaBancaria, null);
		fd.cadastrar(fornecedor);
		response.sendRedirect(pagina+"?cadastrado="+1);
	}
}
