package br.gov.sp.fatec.mapskills.domain.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.domain.institution.StudentRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Component
public class StudentService implements RepositoryService<Student> {
	
	@Autowired
	private StudentRepository repository;
	
	public void save(final Student student) {
		repository.save(student);
	}
	
	public void save(final Collection<Student> student) {
		repository.save(student);
	}


}
