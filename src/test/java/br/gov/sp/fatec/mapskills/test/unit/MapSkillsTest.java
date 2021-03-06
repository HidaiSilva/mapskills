/*
 * @(#)MapSkillsTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.gov.sp.fatec.mapskills.config.WebConfig;
import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextTestConfiguration.class, WebConfig.class})
@WebAppConfiguration
public abstract class MapSkillsTest {
	
	@Autowired
	protected SkillService skillService;
	
	protected void cleanTables(final RepositoryService... services) {
		for(final RepositoryService service : services) {
			final String serviceName = service.getClass().getSimpleName();
			System.err.println("limpando dados da tabela " + serviceName.replace("Service", "").toUpperCase());
			service.deleteAll();
		}
	}
	
	protected List<Scene> buildMockScenes(final long themeId) {
		final List<Alternative> alternatives = builderMockAlternatives(); 
		final List<Scene> scenes = new ArrayList<>(6);
		final Scene scena1 = new Scene("ol� sente-se", "/scenes/bg001.png", null, themeId);
		final Scene scena2 = new Scene("me diga um qualidade", "/scenes/bg002.png", new Question(alternatives, 1), themeId);
		final Scene scena3 = new Scene("muito bom", "/scenes/bg003.png", null, themeId);
		final Scene scena4 = new Scene("voc� ser� o novo gerente", "/scenes/bg004.png", null, themeId);
		final Scene scena5 = new Scene("qual sua primeira atitude?", "/scenes/bg005.png", new Question(alternatives, 2), themeId);
		final Scene scena6 = new Scene("bem pensado!", "/scenes/bg006.png", null, themeId);
		scenes.add(scena1);
		scenes.add(scena2);
		scenes.add(scena3);
		scenes.add(scena4);
		scenes.add(scena5);
		scenes.add(scena6);
		return scenes;
	}
	
	protected List<Alternative> builderMockAlternatives() {
		final List<Alternative> alternatives = new ArrayList<>();
		final Alternative a = new Alternative("AlternativaMockA", 8);
		final Alternative b = new Alternative("AlternativaMockB", 5);
		final Alternative c = new Alternative("AlternativaMockC", 6);
		final Alternative d = new Alternative("AlternativaMockD", 4);
		alternatives.add(a);
		alternatives.add(b);
		alternatives.add(c);
		alternatives.add(d);
		return alternatives;
	}
	
	protected List<Skill> buildSkillsMock() {
		final List<Skill> skills = new ArrayList<>();
		skills.add(new Skill("Vis�o do futuro", ""));
		skills.add(new Skill("Comunica��o", ""));
		skills.add(new Skill("Gest�o do tempo", ""));
		skills.add(new Skill("Equilibrio emocional", ""));
		return skills;
	}

}
