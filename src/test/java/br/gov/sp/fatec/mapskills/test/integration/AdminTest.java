/*
 * @(#)ApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.authentication.DefaultGrantedAuthority;
import br.gov.sp.fatec.mapskills.authentication.PreAuthenticatedAuthentication;
import br.gov.sp.fatec.mapskills.authentication.jwt.JwtAuthenticationManager;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionDetailsWrapper;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class AdminTest extends AbstractApplicationTest {
	
	private static final String BASE_PATH = "/admin";
	
	@Mock
	protected JwtAuthenticationManager jwtAuthenticationManager;
	
	@Autowired
	private InstitutionService institutionService;
		
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private GameThemeService themeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Before
	public void setuUp() {
		super.setUpContext();
		MockitoAnnotations.initMocks(this);
    	filter.setAuthenticationManager(jwtAuthenticationManager); 
	}
	
	@After
	public void cleanTables() {
		super.cleanTables(skillService);
		super.cleanTables(themeService);
		super.cleanTables(institutionService);
	}
	
	@Test
	public void getAllInstitutionsForbidden() throws Exception {
		mockAdminAuthentication();
		
		super.mockMvcPerformGet(BASE_PATH.concat("/institutions"))
			.andExpect(status().isForbidden());
	}
	
	@Test
	public void postSkill() throws Exception {
		mockAdminAuthentication();
		
		final Skill skill = new Skill("lideran�a", "avalia...");
		final String bodyInput = objectMapper.writeValueAsString(skill);

		super.mockMvcPerformPost(BASE_PATH.concat("/skill"), bodyInput)
			.andExpect(status().isOk());
		
		assertEquals(skillService.findById(1).getType(), skill.getType());
	}
	
	@Test
	@WithMockUser(username="admin", authorities={"ADMINISTRATOR"})
	public void AuthenticationIsAdmin() {
		
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final List<DefaultGrantedAuthority> authorities = new ArrayList<>(); 
		for(final GrantedAuthority authority : authentication.getAuthorities()) {
			authorities.add(new DefaultGrantedAuthority(ProfileType.valueOf(authority.getAuthority())));
		}
		assertTrue(authorities.get(0).isAdmin());
	}
	
	@Test
	public void uploadInstitutionFromExcel() throws Exception {
		mockAdminAuthentication();
		
		final InputStream inputStream = getClass().getClassLoader().getResource("institution.xlsx").openStream();
		final String excelBase64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(inputStream));
		
		final String obj = objectMapper.writeValueAsString(String.format("{ base64 : %s }", excelBase64));
		final String json = obj.replace(" ", "\"").substring(1, obj.length()-1);
		
		super.mockMvcPerformPost(BASE_PATH.concat("/upload/institutions"), json)
			.andExpect(status().isOk());
		
		assertEquals(7, institutionService.findAllInstitutions().size());
	}
	
	@Test
	public void saveInstitution() throws Exception {
		mockAdminAuthentication();
		
		final String bodyInput = objectMapper.writeValueAsString(getInstitutionClient());
				
		super.mockMvcPerformPost(BASE_PATH.concat("/institution"), bodyInput)
			.andExpect(status().isOk());
		
		assertNotNull(institutionService.findInstitutionByCode("146"));
		assertEquals(1, institutionService.findInstitutionByCode("146").getMentors().size());
	}
	
	@Test
	public void findAllInstitution() throws Exception {
		mockAdminAuthentication();
		
		institutionService.saveInstitution(getOneInstitution());
		
		final String jsonResponse = super.mockMvcPerformWithMockHeaderGet(BASE_PATH.concat("/institutions"))
										.andReturn().getResponse().getContentAsString();
		
		final Object[] allInstitutionAsArray = objectMapper.readValue(jsonResponse, Object[].class);
		final Collection<Object> allInstitutions = new ArrayList<>(1);
		allInstitutions.addAll(Arrays.asList(allInstitutionAsArray));
		
		assertEquals(1, allInstitutions.size());
	}
	
	@Test
	public void findInstitutionDetailsByCode() throws Exception {
		mockAdminAuthentication();
		
		final Institution fatec = institutionService.saveInstitution(getOneInstitution());
		institutionService.saveCourse(new Course("100", "manuten��o de aeronaves", CoursePeriod.NOTURNO, fatec.getCode()));
		
		final String jsonResponse = super.mockMvcPerformWithMockHeaderGet(BASE_PATH.concat("/institution/" + fatec.getId()))
				.andReturn().getResponse().getContentAsString();
		
		final InstitutionDetailsWrapper institutionReturn = objectMapper.readValue(jsonResponse, InstitutionDetailsWrapper.class);
		
		assertEquals(fatec.getId(), institutionReturn.getInstitution().getId());
		assertEquals(1, institutionReturn.getInstitution().getMentors().size());
	}
	
	@Test
	public void saveGameTheme() throws Exception {
		mockAdminAuthentication();
		
		final GameTheme theme = new GameTheme("pizzaria");
		final String bodyInput = objectMapper.writeValueAsString(theme);
		
		super.mockMvcPerformPost(BASE_PATH.concat("/game/theme"), bodyInput)
			.andExpect(status().isOk());
	}
	
	@Test
	public void updateTheme() throws Exception {
		mockAdminAuthentication();
		
		final List<GameTheme> themes = new ArrayList<>();
		themeService.save(getThemesMock());
		themes.addAll(themeService.findAllThemes());
		
		themes.get(0).enable();
		final String bodyInput = objectMapper.writeValueAsString(new GameThemeListWrapper(themes));
		
		super.mockMvcPerformWithMockHeaderPut(BASE_PATH.concat("/game/themes"), bodyInput)
			.andExpect(status().isOk());
		
		assertTrue(themeService.findById(themes.get(0).getId()).isActive());
	}
	
	@Test
	public void getReportByInstitution() throws Exception {
		mockAdminAuthentication();
		for(final Skill skill : super.getSkillsMock()) {
			skillService.save(skill);
		}
		
		super.mockMvcPerformWithMockHeaderGet(BASE_PATH.concat("/report/146"));
	}
	
	private void mockAdminAuthentication() {
		when(jwtAuthenticationManager.authenticate(Mockito.any(Authentication.class)))
			.thenReturn(getAdminMock());
	}
	
	private Authentication getAdminMock() {
		return new PreAuthenticatedAuthentication(new Administrator("admin", "admin@cps.sp.gov.br", "admin"));
	}
	
	private Collection<GameTheme> getThemesMock() {
		final Collection<GameTheme> themeCollection = new ArrayList<>();
		themeCollection.add(new GameTheme("pizzaria"));
		themeCollection.add(new GameTheme("gravadora"));
		themeCollection.add(new GameTheme("museu"));
		return themeCollection;
	}

}
