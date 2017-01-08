package br.gov.sp.fatec.mapskills.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.UserRepository;

@Configuration
public class MapSkillsMockBeans {
	
	private static final String MESSAGE = "SUCCESS"; 
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private InstitutionService institutionService;
	
	@Autowired
	private GameThemeService themeService;
	
	@Autowired
	private SceneService sceneService;
	
	@Bean
	public String saveAdmin() {
		final Administrator admin = new Administrator("Administrador", "admin@cps.sp.gov.br", "admin");
		userRepo.save(admin);
		return MESSAGE;
	}
	
	@Bean
	public String saveInstitution() {
		final Collection<Institution> institutions = new ArrayList<>(2);
		final Mentor mentorA = new Mentor("Marquinhos", "146", "marquinhos@cps.sp.gov.br", "mudar@123");
		final Institution fatecA = new Institution("146", "60565187000100", "Jessen Vidal", "S�o Jos�", mentorA);
		institutions.add(fatecA);
		final Mentor mentorB = new Mentor("Dona Violeta", "147", "violeta@cps.sp.gov.br", "mudar@123");
		final Institution fatecB = new Institution("147", "64533377000199", "Fatec Pinda", "Pindamonhangaba", mentorB);
		institutions.add(fatecB);
		institutionService.saveInstitutions(institutions);
		
		return MESSAGE;
	}
	
	@Bean
	public String saveStudent() {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), "Student MockE", "1289003400", "student@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(student);
		return MESSAGE;
	}
	
	@Bean
	public String saveGameTheme() {
		final GameTheme themeA = new GameTheme("pizzaria, aplicado em 2016/2");
		themeService.save(themeA);
		final GameTheme themeB = new GameTheme("empresa de musica, aplicado em 2017/1");
		themeService.save(themeB);
		return MESSAGE;
	}
	
	@Bean
	public String saveScenes() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question(alternatives, SKILL_ID);
		
		final Scene scene0 = new Scene("introdu��o", "url://site/img001.png", null, THEME_ID);
		sceneService.save(scene0);
		
		final Scene scene1 = new Scene("quest�o", "url://site/img002.png", question, THEME_ID);
		sceneService.save(scene1);
		
		final Scene scene2 = new Scene("conclus�o", "url://site/img003.png", null, THEME_ID);
		sceneService.save(scene2);
		
		return MESSAGE;
	}
	
	private List<Alternative> builderMockAlternatives() {
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

}
