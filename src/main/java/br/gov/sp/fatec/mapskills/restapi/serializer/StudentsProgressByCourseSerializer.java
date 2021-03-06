/*
 * @(#)StudentsProgressByCourseSerializer.java 1.0 01/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.report.StudentsProgressByCourseWrapper;

public class StudentsProgressByCourseSerializer extends JsonSerializer<StudentsProgressByCourseWrapper> {

	@Override
	public void serialize(final StudentsProgressByCourseWrapper progress, final JsonGenerator generator, 
			final SerializerProvider arg2) throws IOException {
		
		generator.writeStartArray();
		
		for(final Object[] tuple : progress.getResultSet()) {
			generator.writeStartObject();
			
			generator.writeStringField("course", String.valueOf(tuple[4]));
			
			generator.writeArrayFieldStart("values");
			generator.writeNumber(Integer.valueOf(tuple[5] != null ? tuple[5].toString() : "0"));
			generator.writeNumber(Integer.valueOf(tuple[6] != null ? tuple[6].toString() : "0"));
			generator.writeEndArray();
			
			generator.writeEndObject();
		}
		
		generator.writeEndArray();
		
	}

}
