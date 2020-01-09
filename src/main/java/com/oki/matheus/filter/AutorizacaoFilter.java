package com.oki.matheus.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oki.matheus.model.Usuario;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter {

	@Inject
	private Usuario usuario;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resposta = (HttpServletResponse) response;
		HttpServletRequest requisicao = (HttpServletRequest) request;
		
		if (!usuario.isLogado() 
				&& !requisicao.getRequestURI().endsWith("/Login.xhtml")
				&& !requisicao.getRequestURI().contains("/javax.faces.resource/")) {
			
		
			resposta.sendRedirect(requisicao.getContextPath() + "/Login.xhtml");
		} else {
			
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
