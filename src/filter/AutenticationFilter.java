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
import util.Constantes;

public class AutenticationFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = (HttpSession)(((HttpServletRequest)request).getSession());
		
		if (session.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse)response).sendRedirect(Constantes.ERRONOTLOG);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
