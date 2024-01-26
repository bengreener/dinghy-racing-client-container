package com.bginfosys.dinghyracingclientcontainer.security.webfilter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bginfosys.dinghyracingclientcontainer.security.facade.AuthenticationFacade;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class RoleHeaderFilter implements Filter {

	@Autowired
	AuthenticationFacade authenticationFacade;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String roles = authenticationFacade.principalRolesToString(); 
		httpServletResponse.setHeader(
                "DR-Roles-Header", roles);
              chain.doFilter(request, response);
	}
}
