/*
 * @(#)JwtTokenException.java 1.0 27/01/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.authentication.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenException extends AuthenticationException {
	
	private static final long serialVersionUID = 1L;

    public JwtTokenException(final String message) {
        super(message);
    }

}
