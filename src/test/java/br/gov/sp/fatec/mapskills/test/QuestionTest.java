package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.gov.sp.fatec.mapskills.domain.Alternative;
import br.gov.sp.fatec.mapskills.domain.Question;
import br.gov.sp.fatec.mapskills.repository.QuestionRepository;

public class QuestionTest implements ApplicationTest {
	
	final QuestionRepository repository = new QuestionRepository();

	@Test
	public void save() {
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question("Quest�o002 Mock", alternatives, 1, 1);
		repository.save(question);
		
		assertEquals("Quest�o002 Mock", repository.findById(question.id()).description());
		repository.close();
		
	}

	@Test
	public void update() {
		final int id = 2;
		final Question question = repository.findById(id);
		question.changeDescription("Quest�o002 Mock alt");
		question.setStatus(false);
		question.changeAlternatives(builderMockAlternatives());
		question.changeIndex(2);
		repository.update(question);
		
		assertEquals("Quest�o002 Mock alt", repository.findById(id).description());
		repository.close();

	}
	
	@Test
	public void desc() {
		List<Question> questions = repository.questionList();
		
		assertEquals(new Integer("1"), questions.get(0).index());
		repository.close();
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
