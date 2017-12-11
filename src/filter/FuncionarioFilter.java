package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import model.EnumTipoConta;
import model.Pessoa;
import util.Constantes;

public class FuncionarioFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = (HttpSession)(((HttpServletRequest)request).getSession());
		Pessoa pessoa = (Pessoa) session.getAttribute("usuario");
		if (pessoa.getConta().isTipoConta(EnumTipoConta.FUNCIONARIO)) {
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse)response).sendRedirect(Constantes.FORNECEDORDIR+"home.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
