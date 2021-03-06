/*
 * @(#)GameThemeService.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.theme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class GameThemeService implements RepositoryService {
	
	private GameThemeRepository themeRepo;
	private SceneRepository sceneRepo;
	
	@Override
	public void deleteAll() {
		themeRepo.deleteAll();
	}
	/**
	 * Realiza busca de um tema por seu id
	 * @param id
	 * @return
	 */
	public GameTheme findById(final long id) {
		return themeRepo.findById(id);
	}
	/**
	 * Realiza persistencia de um tema
	 * caso n�o exista.
	 * @param theme
	 */
	public void save(final GameTheme theme) {
		themeRepo.save(theme);			
	}
	/**
	 * Realiza persistencia de uma lista de temas
	 * verificando se ja est�o cadastrados.
	 * @param themes
	 */
	public void save(final Collection<GameTheme> themes) {
		themeRepo.save(themes);
	}
	/**
	 * Metodo que retorna todos temas cadastrados na aplicacao
	 * @return lista
	 */
	public Collection<GameTheme> findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		for(final GameTheme theme : themeRepo.findAll()) {
			themes.add(theme);
		}
		return themes;
	}
	/**
	 * M�todo que retorna todas as cenas que est�o ativas de um determinado tema
	 * de uma determinada instituicao.
	 * @param themeId
	 * @return lista
	 */
	public Collection<Scene> findAllScenesByThemeId(final long themeId) {
		return sceneRepo.findAllByGameThemeIdOrderByIndexAsc(themeId);
	}
	
	public Collection<GameTheme> findAllThemesActivated() {
		return themeRepo.findAllByActive(true);
	}
		
	
	//=== Dependecy Inject ===

	@Autowired
	public void setGameThemeRepository(final GameThemeRepository repository) {
		this.themeRepo = repository;
	}
	
	@Autowired
	public void setSceneRepository(final SceneRepository repository) {
		this.sceneRepo = repository;
	}
	
}
