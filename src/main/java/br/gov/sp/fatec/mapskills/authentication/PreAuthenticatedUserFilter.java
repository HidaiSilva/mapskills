/*
 * @(#)PreAuthenticatedUserFilter.java 1.0 26/10/2016
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class PreAuthenticatedUserFilter extends AbstractPreAuthenticatedProcessingFilter {
	
	private static final String AUTHORIZATION = "Authorization";

	/** {@inheritDoc} */
	@Override
	protected String getPreAuthenticatedPrincipal(final HttpServletRequest request) {
		return request.getHeader(AUTHORIZATION) != null ? (String) request.getHeader(AUTHORIZATION) : request.getParameter(AUTHORIZATION);
	}
	
	/** {@inheritDoc} */
	@Override
	protected Object getPreAuthenticatedCredentials(final HttpServletRequest request) {
		return null;
	}
	
	/** {@inheritDoc} */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        try {
            super.doFilter(request, response, chain);
        } finally {
        	SecurityContextHolder.clearContext();
            final HttpSession session = ((HttpServletRequest) request).getSession(false);
            if (session != null) {
                session.removeAttribute("SPRING_SECURITY_CONTEXT");
            }
        }
    }

}
