package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class InstitutionTest extends MapSkillsTest {
	
	@Autowired
	private InstitutionService institutionService;
	
	@After
	public void cleanTables() {
		super.cleanTables(institutionService);
	}
	
	@Test
	public void saveInstitution() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("146", "123456789000", "Jessen Vidal", "S�o Jos�", mentor);
		institutionService.saveInstitution(fatec);
		
		assertEquals("123456789000", institutionService.findInstitutionByCode(fatec.getCode()).getCnpj());
	}
	
	@Test
	public void saveInstitutions() {
		final List<Institution> fatecList = new ArrayList<>();
		final Mentor mentorA = new Mentor("Mentor Responsavel OURINHOS", "valdez@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution("147", "123456789001", "Fatec Ourinhos", "S�o Jos�", mentorA);
		
		final Mentor mentorB = new Mentor("Mentor Responsavel PINDA", "paulo@fatec", "Mudar@123");
		final Institution fatecPINDA = new Institution("148", "123456789002", "Fatec Pinda", "Pindamonhangaba", mentorB);
		
		final Mentor mentorC = new Mentor("Mentor Responsavel SP", "fagundez@fatec", "Mudar@123");
		final Institution fatecSP = new Institution("149", "123456789003", "Fatec SP", "S�o Paulo", mentorC);
		
		fatecList.add(fatecOURINHOS);
		fatecList.add(fatecPINDA);
		fatecList.add(fatecSP);
		institutionService.saveInstitutions(fatecList);
		
		assertEquals(3, institutionService.findAllInstitutions().size());
	}
	
	@Test
	public void saveAndFindAllCoursesByInstitution() {
		final List<Course> coursesList = new ArrayList<>();
		final Course courseA = new Course("28", "Banco de dados", CoursePeriod.NOTURNO, "146");
		final Course courseB = new Course("29", "Logistica", CoursePeriod.NOTURNO, "146");
		final Course courseC = new Course("30", "Estruturas Leves", CoursePeriod.NOTURNO, "146");
		final Course courseD = new Course("31", "Manuten��o de Aeronaves", CoursePeriod.NOTURNO, "146");
		coursesList.add(courseA);
		coursesList.add(courseB);
		coursesList.add(courseC);
		coursesList.add(courseD);
		
		institutionService.saveCourses(coursesList);
		
		assertEquals(4, institutionService.findAllCoursesByInstitution("146").size());
	}
		
	@Test /** TERMINAR OS TESTES */
	public void findAllStudentsByCourseByInstitution() throws MapSkillsException {
		final Mentor mentorA = new Mentor("Victor Responsavel OURINHOS", "victor@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution("146", "123456909001", "Fatec Ourinhos", "Ourinhos", mentorA);
		institutionService.saveInstitution(fatecOURINHOS);
		
		institutionService.saveStudents(mockStudents());
		final List<Student> students = new ArrayList<>();
		students.addAll(institutionService.findAllStudentsByCourseAndInstitution("028", "146"));
		
		assertEquals(4, students.size());
	}
	
	@Test
	public void updateInstitution() {
		final Mentor mentorA = new Mentor("Victor Responsavel OURINHOS", "victor@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution("200", "123456909001", "Fatec Ourinhos", "Ourinhos", mentorA);
		final Mentor mentorB = new Mentor("Regina", "regina@fatec", "Mudar@123");
		final Institution fatecSAMPA = new Institution("156", "123445789001", "Fatec Sampa", "S�o Paulo", mentorB);
		final List<Institution> institutions = new ArrayList<>(2);
		institutions.add(fatecSAMPA);
		institutions.add(fatecOURINHOS);
		institutionService.saveInstitutions(institutions);
		
		final Institution institution = institutionService.findInstitutionByCode("156");
		institution.changeMentorName("Ragina_Simi�es");
		institution.changeCnpj("71461173000155");
		institution.changeCity("Jacarei");
		institution.changeCompany("Fatec Jacarei");
		institutionService.saveInstitution(institution);
		
		assertEquals("Ragina_Simi�es", institutionService.findInstitutionByCode(institution.getCode()).getMentor());
	}
	
	@Test
	public void saveCourses() throws MapSkillsException {
		final Mentor mentorA = new Mentor("Victor Responsavel OURINHOS", "victor@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution("144", "123456909001", "Fatec Ourinhos", "Ourinhos", mentorA);
		institutionService.saveInstitution(fatecOURINHOS);
		
		final Course courseA = new Course("200", "Estruturas Leves", CoursePeriod.NOTURNO, "144");
		final Course courseB = new Course("201", "Manuten��o de Aeronaves", CoursePeriod.NOTURNO, "144");
		final Course courseC = new Course("202", "Logistica", CoursePeriod.NOTURNO, "144");
		final List<Course> courses = new ArrayList<>(3);
		courses.add(courseA);
		courses.add(courseB);
		courses.add(courseC);
		institutionService.saveCourses(courses);
		
		assertEquals(3, institutionService.findAllCoursesByInstitution("144").size());
	}
	
	private List<Student> mockStudents() throws MapSkillsException {
		final List<Student> students = new ArrayList<>();
		final Student studentA = new Student(new AcademicRegistry("1460281423023", "146", "028"), "Student MockA", "1289003400", "studentA@fatec.sp.gov.br", "mudar@123");
		final Student studentB = new Student(new AcademicRegistry("1460281423024", "146", "028"), "Student MockB", "1289003500", "studentB@fatec.sp.gov.br", "mudar@123");
		final Student studentC = new Student(new AcademicRegistry("1460281423025", "146", "028"), "Student MockC", "1289003600", "studentC@fatec.sp.gov.br", "mudar@123");
		final Student studentD = new Student(new AcademicRegistry("1460281423026", "146", "028"), "Student MockD", "1289003700", "studentD@fatec.sp.gov.br", "mudar@123");
		students.add(studentA);
		students.add(studentB);
		students.add(studentC);
		students.add(studentD);
		return students;
	}
	

}
