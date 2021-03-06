/*
 * @(#)InstitutionDetailsWrapper.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.restapi.serializer.InstitutionDeserializer;
import br.gov.sp.fatec.mapskills.restapi.serializer.InstitutionDetailsSerializer;

@JsonDeserialize(using = InstitutionDeserializer.class)
@JsonSerialize(using = InstitutionDetailsSerializer.class)
public class InstitutionDetailsWrapper {
	
	private final Institution institution;
	
	public InstitutionDetailsWrapper(final Institution institution) {
		this.institution = institution;
	}
	
	public Institution getInstitution() {
		return institution;
	}

}
