package it.unisa;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
    public AuthFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		
		String loginURI = hrequest.getContextPath() + "/admin/";

		System.out.println("Requested uri: " + hrequest.getRequestURI());
		boolean loginRequest = hrequest.getRequestURI().startsWith(loginURI); //controlli se vuoi entrare alla cartella admin

		if(loginRequest) {
			System.out.println("Check role in the session");
			//check the token from session
			HttpSession session = hrequest.getSession(false);
			boolean loggedIn = (session != null && session.getAttribute("role") != null && session.getAttribute("role").equals("Administrator"));
			
			if(!loggedIn) {
				System.out.println("Access unauthorized: Non sei un amministratore\n");
				hresponse.sendRedirect(hresponse.encodeRedirectURL(hrequest.getContextPath() + "/AccessoNonAutorizzato.jsp"));
			} else {
				// admin resource
				System.out.println("Access authorized : Sei entrato come amministratore\n");
				chain.doFilter(request, response);
			}
		} else {
			hresponse.sendRedirect(hresponse.encodeRedirectURL(hrequest.getContextPath() + "/login.jsp"));
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
