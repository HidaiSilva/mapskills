/*
 * @(#)UserSerilizerStrategy.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.user.User;

@FunctionalInterface
public interface UserSerilizerStrategy {
	
	public void serialize(final User user, final JsonGenerator generator) throws IOException;

}
