/*
 * @(#)SkillTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;

@Ignore
public class SkillTest extends MapSkillsTest {
	
	@Autowired
	private SkillService service;
	
	@Before
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void save() {
		final Skill skill = new Skill("Lideran�a", "Breve descri��o da habilidade");
		service.save(skill);
		
		assertEquals("Lideran�a", service.findById(skill.getId()).getType());
		
	}
	
	@Test
	public void testClean() {
		final Collection<Skill> skillList = service.findAll();
		assertTrue(skillList.isEmpty());
		
	}

	@Test
	public void update() {
		final Skill skillSave = new Skill("Lideran�a", "Breve descri��o da habilidade");
		service.save(skillSave);
		
		final Skill skillUpdate = new Skill("for�a", "Breve descri��o da habilidade");
		skillUpdate.setId(skillSave.getId());
		service.update(skillUpdate);
		
		assertEquals("for�a", service.findById(skillSave.getId()).getType());
		
	}

}
