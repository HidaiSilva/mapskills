/*
 * @(#)Alternative.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alternative")
public class Alternative implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_id")
	private Integer id;
	
	@Column(name = "alt_description", nullable = false)
	private String description;
	
	@Column(name = "alt_skillValue", nullable = false)
	private Integer skillValue;
		
	public Alternative() {}
	
	public Alternative(final String description, final Integer skillValue) {
		this.description = description;
		this.skillValue = skillValue;
	}
	
	public String description() {
		return description;
	}
	
	public Integer skillValue() {
		return skillValue;
	}
	
	public void changeDescription(final String newDescription) {
		this.description = newDescription;
	}
	
	public void changeSkillValue(final Integer newSkillValue) {
		this.skillValue = newSkillValue;
	}

}
