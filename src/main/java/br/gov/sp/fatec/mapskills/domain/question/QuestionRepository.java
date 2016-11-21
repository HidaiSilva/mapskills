/*
 * @(#)QuestionRepository.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
		
	@Query("SELECT q FROM Question q ORDER BY q.index")
	public List<Question> questionList();
	
	public Question findById(final int id);

	/**
	 * M�todo que recupera todas quest�es de um determinado tema e que n�o esteja desabilitada
	 * @param themeId
	 * @param active
	 * @return
	 */
	public List<Question> findAllByThemeIdAndEnable(final int themeId, final boolean active);
	
	//M�TODO PARA BUSCAR TODAS QUESTOES HABILITADAS E N�O RESPONDIDAS DE UM DETERMINADO ALUNO
	
	/**
	 * M�todo recupera o pr�ximo index valido para uma quest�o de um tema
	 * @param themeId
	 * @return
	 */
	@Query("SELECT (COUNT(*) + 1) FROM Question q INNER JOIN GameTheme t ON q.themeId = t.id WHERE t.id = ?1")
	public int findNextIndex(final int themeId);
	
}
