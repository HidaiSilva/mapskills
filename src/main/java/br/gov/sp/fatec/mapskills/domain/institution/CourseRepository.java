/*
 * @(#)CoursePeriod.java 1.0 14/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
/**
 * A classe <code>CourseRepository</code> tem a fun��o de realizar as persistencias
 * dos cursos no banco de dados.
 * @author Marcelo
 *
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
	
	public List<Course> findAllByInstitutionCode(final String institutionCode);
	public Course findByCode(final String code);

}
