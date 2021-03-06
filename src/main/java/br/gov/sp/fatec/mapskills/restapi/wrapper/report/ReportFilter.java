/*
 * @(#)ReportFilter.java 1.0 18/03/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
/**
 * A classe <code>ReportFilter</code> representa os filtros
 * possiveis para geracao de relatorio.
 * 
 * @author Marcelo
 *
 */
@JsonDeserialize(using = ReportFilterDeserializer.class)
public class ReportFilter {
	
	private final InstitutionLevel levelInstitution;
	private final String institutionCode;
	private final String courseCode;
	private final String startDate;
	private final String endDate;
	
	public ReportFilter(final String levelInstitution, final String institutionCode,
			final String courseCode, final String startDate, final String endDate) {
		
		this.levelInstitution = verifyEnum(levelInstitution);
		this.institutionCode = institutionCode;
		this.courseCode = courseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}

	public InstitutionLevel getLevelInstitution() {
		return levelInstitution;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	
	private InstitutionLevel verifyEnum(final String level) {
		return StringUtils.isEmpty(level) ? null : InstitutionLevel.valueOf(level);
	}
	

}
