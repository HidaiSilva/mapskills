package br.gov.sp.fatec.mapskills.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillRepository;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;

@Configuration
public class SetupApplicationToInitializeGame {
	
	private static final String SUCCESS_CREATE_BEAN = "SUCCESS";
	private static final String URL_SERVER = "http://localhost:8080/mapskills/images/";
	private static final long GAME_THEME_ID = 1;
	
	private final Map<Integer, Question> mapQuestion = new HashMap<>(26);
	private final Map<Integer, Collection<Alternative>> mapAlternatives = new HashMap<>(26);
	private final Map<Integer, String> mapText = new HashMap<>(75);
	
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private SceneService sceneService;
	@Autowired
	private GameThemeService themeService;
	
	public SetupApplicationToInitializeGame() {
		this.generateText();
		this.generateAlternatives();
		this.generateQuestions();
		//this.generateScenes();
	}
	
	@Bean
	public String generateGameTheme() {
		themeService.save(new GameTheme("PIZZARIA"));
		return SUCCESS_CREATE_BEAN;
	}
	
	@Bean
	public String generateScenes() {
		final Collection<Scene> allScenes = new LinkedList<>();
		allScenes.add(new Scene(getText(1), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(2), URL_SERVER.concat("scene1.jpg"), getQuestion(1), GAME_THEME_ID));
		allScenes.add(new Scene(getText(3), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(4), URL_SERVER.concat("scene3.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(5), URL_SERVER.concat("scene3.jpg"), getQuestion(2), GAME_THEME_ID));
		allScenes.add(new Scene(getText(6), URL_SERVER.concat("scene3.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(7), URL_SERVER.concat("scene4.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(8), URL_SERVER.concat("scene4.jpg"), getQuestion(3), GAME_THEME_ID));
		allScenes.add(new Scene(getText(9), URL_SERVER.concat("scene4.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(10), URL_SERVER.concat("scene5.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(11), URL_SERVER.concat("scene6.jpg"), getQuestion(4), GAME_THEME_ID));
		allScenes.add(new Scene(getText(12), URL_SERVER.concat("scene6.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(13), URL_SERVER.concat("scene7.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(14), URL_SERVER.concat("scene7.jpg"), getQuestion(5), GAME_THEME_ID));
		allScenes.add(new Scene(getText(15), URL_SERVER.concat("scene7.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(16), URL_SERVER.concat("scene8.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(17), URL_SERVER.concat("scene8.jpg"), getQuestion(6), GAME_THEME_ID));
		allScenes.add(new Scene(getText(18), URL_SERVER.concat("scene9.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(19), URL_SERVER.concat("scene10.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(20), URL_SERVER.concat("scene11.jpg"), getQuestion(7), GAME_THEME_ID));
		allScenes.add(new Scene(getText(21), URL_SERVER.concat("scene11.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(22), URL_SERVER.concat("scene12.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(23), URL_SERVER.concat("scene12.jpg"), getQuestion(8), GAME_THEME_ID));
		allScenes.add(new Scene(getText(24), URL_SERVER.concat("scene12.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(25), URL_SERVER.concat("scene13.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(26), URL_SERVER.concat("scene14.jpg"), getQuestion(9), GAME_THEME_ID));
		allScenes.add(new Scene(getText(27), URL_SERVER.concat("scene14.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(28), URL_SERVER.concat("scene15.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(29), URL_SERVER.concat("scene15.jpg"), getQuestion(10), GAME_THEME_ID));
		allScenes.add(new Scene(getText(30), URL_SERVER.concat("scene15.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(31), URL_SERVER.concat("scene16.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(32), URL_SERVER.concat("scene16.jpg"), getQuestion(11), GAME_THEME_ID));
		allScenes.add(new Scene(getText(33), URL_SERVER.concat("scene16.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(34), URL_SERVER.concat("scene18.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(35), URL_SERVER.concat("scene18.jpg"), getQuestion(12), GAME_THEME_ID));
		allScenes.add(new Scene(getText(36), URL_SERVER.concat("scene18.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(37), URL_SERVER.concat("scene19.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(38), URL_SERVER.concat("scene19.jpg"), getQuestion(13), GAME_THEME_ID));
		allScenes.add(new Scene(getText(39), URL_SERVER.concat("scene19.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(40), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(41), URL_SERVER.concat("scene20.jpg"), getQuestion(14), GAME_THEME_ID));
		allScenes.add(new Scene(getText(42), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(43), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(44), URL_SERVER.concat("scene22.jpg"), getQuestion(15), GAME_THEME_ID));
		allScenes.add(new Scene(getText(45), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(46), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(47), URL_SERVER.concat("scene22.jpg"), getQuestion(16), GAME_THEME_ID));
		allScenes.add(new Scene(getText(48), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(49), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(50), URL_SERVER.concat("scene23.jpg"), getQuestion(17), GAME_THEME_ID));
		allScenes.add(new Scene(getText(51), URL_SERVER.concat("scene23.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(52), URL_SERVER.concat("scene24.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(53), URL_SERVER.concat("scene25.jpg"), getQuestion(18), GAME_THEME_ID));
		allScenes.add(new Scene(getText(54), URL_SERVER.concat("scene24.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(55), URL_SERVER.concat("scene26.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(56), URL_SERVER.concat("scene26.jpg"), getQuestion(19), GAME_THEME_ID));
		allScenes.add(new Scene(getText(57), URL_SERVER.concat("scene26.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(58), URL_SERVER.concat("scene27.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(59), URL_SERVER.concat("scene27.jpg"), getQuestion(20), GAME_THEME_ID));
		allScenes.add(new Scene(getText(60), URL_SERVER.concat("scene27.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(61), URL_SERVER.concat("scene28.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(62), URL_SERVER.concat("scene28.jpg"), getQuestion(21), GAME_THEME_ID));
		allScenes.add(new Scene(getText(63), URL_SERVER.concat("scene28.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(64), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(65), URL_SERVER.concat("scene1.jpg"), getQuestion(22), GAME_THEME_ID));
		allScenes.add(new Scene(getText(66), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(67), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(68), URL_SERVER.concat("scene1.jpg"), getQuestion(23), GAME_THEME_ID));
		allScenes.add(new Scene(getText(69), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(70), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(71), URL_SERVER.concat("scene20.jpg"), getQuestion(24), GAME_THEME_ID));
		allScenes.add(new Scene(getText(72), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(73), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		allScenes.add(new Scene(getText(74), URL_SERVER.concat("scene1.jpg"), getQuestion(25), GAME_THEME_ID));
		allScenes.add(new Scene(getText(75), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		
		sceneService.save(allScenes);
		
		return SUCCESS_CREATE_BEAN;
	}
	
	@Bean
	public String generateSkills() {
		skillRepository.save(new Skill("Vis�o do futuro", "Avalia proje��o de perspectiva."));
		skillRepository.save(new Skill("Comunica��o", "Avalia dic��o dos assuntos em grupo."));
		skillRepository.save(new Skill("Gest�o do tempo", "Avalia��o a situa��o sob press�o no trabalho."));
		skillRepository.save(new Skill("Equilibrio emocional", "Avalia o comportamento em situa��o de stress."));
		skillRepository.save(new Skill("Trabalho em equipe", "Avalia a gest�o do trablho em equipe."));
		skillRepository.save(new Skill("Resiliencia", "Avalia a facilidade de se adaptar �s mudan�as."));
		return SUCCESS_CREATE_BEAN;
	}
	
	private void generateQuestions() {
		mapQuestion.put(1, new Question(getAlternatives(1), 1));
		mapQuestion.put(2, new Question(getAlternatives(2), 2));
		mapQuestion.put(3, new Question(getAlternatives(3), 3));
		mapQuestion.put(4, new Question(getAlternatives(4), 5));
		mapQuestion.put(5, new Question(getAlternatives(5), 3));
		mapQuestion.put(6, new Question(getAlternatives(6), 4));
		mapQuestion.put(7, new Question(getAlternatives(7), 1));
		mapQuestion.put(8, new Question(getAlternatives(8), 4));
		mapQuestion.put(9, new Question(getAlternatives(9), 4));
		mapQuestion.put(10, new Question(getAlternatives(10), 6));
		mapQuestion.put(11, new Question(getAlternatives(11), 2));
		mapQuestion.put(12, new Question(getAlternatives(12), 6));
		mapQuestion.put(13, new Question(getAlternatives(13), 1));
		mapQuestion.put(14, new Question(getAlternatives(14), 3));
		mapQuestion.put(15, new Question(getAlternatives(15), 5));
		mapQuestion.put(16, new Question(getAlternatives(16), 6));
		mapQuestion.put(17, new Question(getAlternatives(17), 5));
		mapQuestion.put(18, new Question(getAlternatives(18), 1));
		mapQuestion.put(19, new Question(getAlternatives(19), 6));
		mapQuestion.put(20, new Question(getAlternatives(20), 5));
		mapQuestion.put(21, new Question(getAlternatives(21), 2));
		mapQuestion.put(22, new Question(getAlternatives(22), 5));
		mapQuestion.put(23, new Question(getAlternatives(23), 4));
		mapQuestion.put(24, new Question(getAlternatives(24), 3));
		mapQuestion.put(25, new Question(getAlternatives(25), 2));
	}
	
	private Question getQuestion(final int id) {
		return this.mapQuestion.get(id);
	}
	
	private Collection<Alternative> getAlternatives(final long id) {
		Collection<Alternative> alternatives = new ArrayList<>(4);
		alternatives = mapAlternatives.get(id);
		return alternatives;
	}
	
	private String getText(final int id) {
		return mapText.get(id);
	}
	
	private void generateAlternatives() {
		
		this.mapAlternatives.clear();
				
		for(int i = 1; i < 26; i++) {
			this.mapAlternatives.put(i, new ArrayList<>(4));
		}
		
		final Alternative question1a = new Alternative("Me tornar presidente desta Rede.", 3);
		final Alternative question1b = new Alternative("Abrir minha propria franquia.", 2);
		final Alternative question1c = new Alternative("Planejo continuar gerenciando esta pizzaria.", 1);
		final Alternative question1d = new Alternative("Usar as experi�ncias adquiridas aqui para abrir o pr�prio neg�cio", 4);
		mapAlternatives.get(1).add(question1a);
		mapAlternatives.get(1).add(question1b);
		mapAlternatives.get(1).add(question1c);
		mapAlternatives.get(1).add(question1d);
		
		final Alternative question2a = new Alternative("Deixar os sabores mais simples, por�m aumentar a quantidade de recheio.", 1);
		final Alternative question2b = new Alternative("Fazer uma pesquisa local entre os cidad�os locais.", 3);
		final Alternative question2c = new Alternative("Seguir o padr�o da concorrencia.", 2);
		final Alternative question2d = new Alternative("Usar o feedback dos clientes para decidir.", 4);
		mapAlternatives.get(2).add(question2a);
		mapAlternatives.get(2).add(question2b);
		mapAlternatives.get(2).add(question2c);
		mapAlternatives.get(2).add(question2d);
		
		final Alternative question3a = new Alternative("Renegociar os pre�os com os fornecedores.", 3);
		final Alternative question3b = new Alternative("Pesquisar novos fornecedores de n�vel superior", 4);
		final Alternative question3c = new Alternative("Pesquisar fornecedores mais baratas.", 2);
		final Alternative question3d = new Alternative("Diminuir tamanho da pizza", 1);
		mapAlternatives.get(3).add(question3a);
		mapAlternatives.get(3).add(question3b);
		mapAlternatives.get(3).add(question3c);
		mapAlternatives.get(3).add(question3d);
		mapAlternatives.put(3, mapAlternatives.get(3));
		
		final Alternative question4a = new Alternative("Contrata um atendente experiente, para suprir a demanda e coordenar a equipe.", 3);
		final Alternative question4b = new Alternative("Faz um programa de treinamento, supervisionado pessoalmente.", 4);
		final Alternative question4c = new Alternative("Discutir o problema pessoalmente com cada atendente.", 2);
		final Alternative question4d = new Alternative("Implementar um sistema de cotas de vendas di�rias com bonifica��o.", 1);
		mapAlternatives.get(4).add(question4a);
		mapAlternatives.get(4).add(question4b);
		mapAlternatives.get(4).add(question4c);
		mapAlternatives.get(4).add(question4d);
		mapAlternatives.put(4, mapAlternatives.get(4));
		
		final Alternative question5a = new Alternative("Contratar mais um motoboy.", 3);
		final Alternative question5b = new Alternative("Aumentar o tempo de entrega.", 1);
		final Alternative question5c = new Alternative("Comprar outra moto mais potente.", 4);
		final Alternative question5d = new Alternative("Agilizar a cozinha dando o tempo necess�rio ao motoboy.", 2);
		mapAlternatives.get(5).add(question5a);
		mapAlternatives.get(5).add(question5b);
		mapAlternatives.get(5).add(question5c);
		mapAlternatives.get(5).add(question5d);
		mapAlternatives.put(5, mapAlternatives.get(5));
		
		final Alternative question6a = new Alternative("(Cutuca)N�o � bom dormir em servi�o.", 4);
		final Alternative question6b = new Alternative("(Bate na mesa)N�o quero que isso se repita.", 3);
		final Alternative question6c = new Alternative("Cutuca o funcion�rio.", 2);
		final Alternative question6d = new Alternative("Acorde, v� dormir na sua casa, quero que venha trabalhar direito amanh�", 1);
		mapAlternatives.get(6).add(question6a);
		mapAlternatives.get(6).add(question6b);
		mapAlternatives.get(6).add(question6c);
		mapAlternatives.get(6).add(question6d);
		mapAlternatives.put(6, mapAlternatives.get(6));
		
		final Alternative question7a = new Alternative("Criar um servi�o de entregas online.", 4);
		final Alternative question7b = new Alternative("Criar promo��es para pedidos espec�ficos.", 2);
		final Alternative question7c = new Alternative("Baratear o pre�o da entrega.", 3);
		final Alternative question7d = new Alternative("Aumentar os pre�os.", 1);
		mapAlternatives.get(7).add(question7a);
		mapAlternatives.get(7).add(question7b);
		mapAlternatives.get(7).add(question7c);
		mapAlternatives.get(7).add(question7d);
		mapAlternatives.put(7, mapAlternatives.get(7));
		
		final Alternative question8a = new Alternative("Observar a situa��o a dist�ncia", 0);
		final Alternative question8b = new Alternative("Perguntar o que est� acontecendo", 0);
		final Alternative question8c = new Alternative("Pedir para outro funcion�rio verificar a situa��o", 0);
		final Alternative question8d = new Alternative("Ignora e vai tratar de outro assunto", 0);
		mapAlternatives.get(8).add(question8a);
		mapAlternatives.get(8).add(question8b);
		mapAlternatives.get(8).add(question8c);
		mapAlternatives.get(8).add(question8d);
		mapAlternatives.put(8, mapAlternatives.get(8));
		
		final Alternative question9a = new Alternative("Desculpe senhor, gostaria de trocar a pizza?", 1);
		final Alternative question9b = new Alternative("Por favor senhor, poderia sair da fila, podemos conversar em outro lugar.", 2);
		final Alternative question9c = new Alternative("(chama um funcion�rio) tente resolver isso para mim.", 3);
		final Alternative question9d = new Alternative("Desculpe senhor, o que podemos fazer para nos desculpar.", 4);
		mapAlternatives.get(9).add(question9a);
		mapAlternatives.get(9).add(question9b);
		mapAlternatives.get(9).add(question9c);
		mapAlternatives.get(9).add(question9d);
		mapAlternatives.put(9, mapAlternatives.get(9));
		
		final Alternative question10a = new Alternative("Manter a posi��o e continuar investindo no projeto", 4);
		final Alternative question10b = new Alternative("Reduzir o or�amento do projeto", 3);
		final Alternative question10c = new Alternative("Abortar o projeto", 1);
		final Alternative question10d = new Alternative("Postergar o projeto", 2);
		mapAlternatives.get(10).add(question10a);
		mapAlternatives.get(10).add(question10b);
		mapAlternatives.get(10).add(question10c);
		mapAlternatives.get(10).add(question10d);
		mapAlternatives.put(10, mapAlternatives.get(10));
		
		final Alternative question11a = new Alternative("Teu aumento j� est� agendado para uma data futura, no momento isto � invi�vel.", 3);
		final Alternative question11b = new Alternative("Talvez em uma data futura possamos negociar um aumento mais condizente com a situa��o da empresa.", 2);
		final Alternative question11c = new Alternative("Me desculpe, mas n�o ser� poss�vel com a situa��o atual da empresa.", 1);
		final Alternative question11d = new Alternative("As �ltimas mudan�as na empresa tornaram dif�cil a entrega de tal beneficio sem um planejamento pr�vio.", 4);
		mapAlternatives.get(11).add(question11a);
		mapAlternatives.get(11).add(question11b);
		mapAlternatives.get(11).add(question11c);
		mapAlternatives.get(11).add(question11d);
		mapAlternatives.put(11, mapAlternatives.get(11));
		
		final Alternative question12a = new Alternative("Compre mais ingredientes, vamos improvisar at� voc� chegar!", 4);
		final Alternative question12b = new Alternative("Digam que vamos servir as sobremesas (� o que ainda est� com uma boa quantidade)", 3);
		final Alternative question12c = new Alternative("Vamos improvisar com o que temos mesmo.", 1);
		final Alternative question12d = new Alternative("Pe�a para os fornecedores trazerem os ingredientes o mais r�pido possivel!", 2);
		mapAlternatives.get(12).add(question12a);
		mapAlternatives.get(12).add(question12b);
		mapAlternatives.get(12).add(question12c);
		mapAlternatives.get(12).add(question12d);
		mapAlternatives.put(12, mapAlternatives.get(12));
		
		final Alternative question13a = new Alternative("Vamos abaixar o pre�o das pizzas", 2);
		final Alternative question13b = new Alternative("Vamos dominar a entrega de pizzas, fazendo promo��es acima de pre�o X", 4);
		final Alternative question13c = new Alternative("Extras para quem comprar pizzas por um tempo predeterminado.", 1);
		final Alternative question13d = new Alternative("Contratar um servi�o de publicidade.", 3);
		mapAlternatives.get(13).add(question13a);
		mapAlternatives.get(13).add(question13b);
		mapAlternatives.get(13).add(question13c);
		mapAlternatives.get(13).add(question13d);
		mapAlternatives.put(13, mapAlternatives.get(13));
		
		final Alternative question14a = new Alternative("Planeje as entrevistas para o s�bado �s 15h", 3);
		final Alternative question14b = new Alternative("Espalhe pela cidade informa��es sobre as vagas de emprego, conforme chegarem faremos as entrevistas", 2);
		final Alternative question14c = new Alternative("Coloque no panfleto: marquem hora para as entrevistas", 1);
		final Alternative question14d = new Alternative("Marque no panfleto que estarei esperando entrevistas �s 15h todos os dias.", 4);
		mapAlternatives.get(14).add(question14a);
		mapAlternatives.get(14).add(question14b);
		mapAlternatives.get(14).add(question14c);
		mapAlternatives.get(14).add(question14d);
		mapAlternatives.put(14, mapAlternatives.get(14));
		
		final Alternative question15a = new Alternative("Ampliar a �rea f�sica do estoque reduzindo a �rea de lazer dos funcion�rios", 2);
		final Alternative question15b = new Alternative("Criar um estoque secund�rio externo a instala��o principal.", 4);
		final Alternative question15c = new Alternative("Comprar ingredientes de acordo com a sua rotatividade para diminuir espa�o f�sico ocupado", 3);
		final Alternative question15d = new Alternative("Chamar os fornecedores duas vezes por dia", 1);
		mapAlternatives.get(15).add(question15a);
		mapAlternatives.get(15).add(question15b);
		mapAlternatives.get(15).add(question15c);
		mapAlternatives.get(15).add(question15d);
		mapAlternatives.put(15, mapAlternatives.get(15));
		
		final Alternative question16a = new Alternative("Coloco mais recheio nas pizzas", 3);
		final Alternative question16b = new Alternative("Diminui o pre�o da pizza por um tempo para ter menos preju�zo.", 4);
		final Alternative question16c = new Alternative("Aumenta o tamanho da pizza por um tempo.", 3);
		final Alternative question16d = new Alternative("Promo��o! Ganhe um brotinho na compra de uma pizza grande.", 1);
		mapAlternatives.get(16).add(question16a);
		mapAlternatives.get(16).add(question16b);
		mapAlternatives.get(16).add(question16c);
		mapAlternatives.get(16).add(question16d);
		mapAlternatives.put(16, mapAlternatives.get(16));
		
		final Alternative question17a = new Alternative("(Sussurro no telefone) Fa�am o poss�vel, agora estou em uma reuni�o.(desliga o telefone)<br /> Parece que houve um assalto na pizzaria, providencias est�o sendo tomadas", 2);
		final Alternative question17b = new Alternative("(Sussurra no telefone) Depois eu cubro as despezas", 1);
		final Alternative question17c = new Alternative("(Sussurra no telefone) Fa�am o B.O., depois da reuni�o eu resolvo o resto<br />(Continua a reuniao...)", 4);
		final Alternative question17d = new Alternative("Parece que houve um assalto na pizzaria, Tenho que fazer o B.O. o mais r�pido possivel. Podemos remarcar a Reuni�o?", 3);
		mapAlternatives.get(17).add(question17a);
		mapAlternatives.get(17).add(question17b);
		mapAlternatives.get(17).add(question17c);
		mapAlternatives.get(17).add(question17d);
		mapAlternatives.put(17, mapAlternatives.get(17));
		
		final Alternative question18a = new Alternative("Vou contratar seguran�as para que n�o se repita.", 4);
		final Alternative question18b = new Alternative("Instalarei cameras por todas as partes.", 3);
		final Alternative question18c = new Alternative("Colocarei alarmes.", 2);
		final Alternative question18d = new Alternative("Vou incrementar a seguran�a com tudo possivel, cameras, alarmes e seguran�as.", 1);
		mapAlternatives.get(18).add(question18a);
		mapAlternatives.get(18).add(question18b);
		mapAlternatives.get(18).add(question18c);
		mapAlternatives.get(18).add(question18d);
		mapAlternatives.put(18, mapAlternatives.get(18));
		
		final Alternative question19a = new Alternative("Aproveitaremos o ocorrido para fazer reformas que ajudar�o na seguran�a de todos.", 4);
		final Alternative question19b = new Alternative("De jeito nenhum, nossa equipe estar� a servi�o assim que forem feitas reformas.", 3);
		final Alternative question19c = new Alternative("Ap�s um breve descanso da equipe, voltaremos com for�a total.", 2);
		final Alternative question19d = new Alternative("N�o necessariamente.", 1);
		mapAlternatives.get(19).add(question19a);
		mapAlternatives.get(19).add(question19b);
		mapAlternatives.get(19).add(question19c);
		mapAlternatives.get(19).add(question19d);
		mapAlternatives.put(19, mapAlternatives.get(19));
		
		final Alternative question20a = new Alternative("Aviso: reforma, voltamos em breve.", 3);
		final Alternative question20b = new Alternative("Fechado para reforma.", 2);
		final Alternative question20c = new Alternative("Retornamos em breve.", 1);
		final Alternative question20d = new Alternative("REFORMA! voltamos dia X.", 4);
		mapAlternatives.get(20).add(question20a);
		mapAlternatives.get(20).add(question20b);
		mapAlternatives.get(20).add(question20c);
		mapAlternatives.get(20).add(question20d);
		mapAlternatives.put(20, mapAlternatives.get(20));
		
		final Alternative question21a = new Alternative("Reuniao geral)- Mostrar a todos as mudan�as implementadas.", 3);
		final Alternative question21b = new Alternative("Avisar a todos que o bandido est� preso.", 2);
		final Alternative question21c = new Alternative("O que acham das Altera��es?", 1);
		final Alternative question21d = new Alternative("(Fingir que nada aconteceu)", 4);
		mapAlternatives.get(21).add(question21a);
		mapAlternatives.get(21).add(question21b);
		mapAlternatives.get(21).add(question21c);
		mapAlternatives.get(21).add(question21d);
		mapAlternatives.put(21, mapAlternatives.get(21));
		
		final Alternative question22a = new Alternative("Implementar trabalho transacional de 3 dias para se adequar aos poucos a rotina.", 3);
		final Alternative question22b = new Alternative("(Acompanha-lo e auxilia-lo de perto algumas horas por dia.)", 4);
		final Alternative question22c = new Alternative("(D� um descan�o para ele.)", 2);
		final Alternative question22d = new Alternative("(Pedir para que ele se recomponha.)", 1);
		mapAlternatives.get(22).add(question22a);
		mapAlternatives.get(22).add(question22b);
		mapAlternatives.get(22).add(question22c);
		mapAlternatives.get(22).add(question22d);
		mapAlternatives.put(22, mapAlternatives.get(22));
		
		final Alternative question23a = new Alternative("Comprar materiais novos para o(a) sucessor(a).", 3);
		final Alternative question23b = new Alternative("Deixar o dinheiro como fundo emergencial para a pizzaria.", 4);
		final Alternative question23c = new Alternative("Pagar alguem para fazer um relatorio completo sobre o periodo.", 2);
		final Alternative question23d = new Alternative("Continuar na rotina normal, e entregar um relatorio padr�o.", 1);
		mapAlternatives.get(23).add(question23a);
		mapAlternatives.get(23).add(question23b);
		mapAlternatives.get(23).add(question23c);
		mapAlternatives.get(23).add(question23d);
		mapAlternatives.put(23, mapAlternatives.get(23));
		
		final Alternative question24a = new Alternative("Organiza a equipe para receber o novo gerente.", 4);
		final Alternative question24b = new Alternative("Deixa uma lista de afazeres preparada para o sucessor.", 3);
		final Alternative question24c = new Alternative("Se foca no dia a dia para manter a pizzaria funcionando normalmente at� a sucess�o.", 1);
		final Alternative question24d = new Alternative("Deixa todo o ambiente pronto para a sucess�o sozinho, para evitar despedidas.", 1);
		mapAlternatives.get(24).add(question24a);
		mapAlternatives.get(24).add(question24b);
		mapAlternatives.get(24).add(question24c);
		mapAlternatives.get(24).add(question24d);
		mapAlternatives.put(24, mapAlternatives.get(24));
		
		final Alternative question25a = new Alternative("Os funcion�rios estavam completamente desfocados sem ninguem no comando.", 3);
		final Alternative question25b = new Alternative("N�o havia administra��o competente dos recursos.", 4);
		final Alternative question25c = new Alternative("Mau aproveitamento do espa�o e d� equipe.", 2);
		final Alternative question25d = new Alternative("Acomoda��o dos funcion�rios.", 1);
		mapAlternatives.get(25).add(question25a);
		mapAlternatives.get(25).add(question25b);
		mapAlternatives.get(25).add(question25c);
		mapAlternatives.get(25).add(question25d);
		mapAlternatives.put(25, mapAlternatives.get(25));
	}
	
	private void generateText() {
		mapText.put(1, "sente-se.");
		mapText.put(2, "Me diga!<br /> O que planeja daqui a 3 anos?");
		mapText.put(3, "Hum... Interessante<br/>(o grupo conversa entre si)<br />Voc� � exatamente o tipo de pessoa que precisamos no momento. O cargo de Gerente � seu. Voc� pode come�ar amanh� mesmo."); 
		mapText.put(4, "Bom dia, voc� deve ser o novo gerente.<br /> Estamos com um problema, nossas receitas n�o est�o agradando muitos clientes, precisamos fazer algo."); 
		mapText.put(5, "Voc� tem alguma ideia de o que podemos fazer?");
		mapText.put(6, "Realmente isso deve resolver o problema.");
		mapText.put(7, "Mas tamb�m precisaremos comprar mais ingredientes, e temos um pequeno problema com isso tambem. A verba n�o est� muito grande e precisamos fazer algo.");
		mapText.put(8, "Estes s�o os fornecedores dispon�veis. o que deseja fazer?");
		mapText.put(9, "Ok, j� liguei para estes, pela manha os ingredientes devem chegar.");
		mapText.put(10, "parece que as pizzas voltaram a vender como antes, mas nossa equipe de atendentes � muito inexperiente.");
		mapText.put(11, "o que planeja fazer a respeito?");
		mapText.put(12, "OK. Vamos por em pratica imediatamente.");
		mapText.put(13,"parece que temos um probleminha com as entregas.<br /> elas est�o chegando muito atrasadas.");
		mapText.put(14, "Mas � por culpa dessa moto que fica dando problema toda hora! <br /> temos que dar um jeito nisso.");
		mapText.put(15, "Opa! beleza, isso deve ajudar muito.<br /> daqui a pouco eu volto, tenho entregas a fazer!");
		mapText.put(16, "(voc� v� um funcion�rio dormindo durante o expediente)");
		mapText.put(17, "(voc� v� um funcion�rio dormindo durante o expediente)");
		mapText.put(18, "Hein?!.... Me desculpe chefe");
		mapText.put(19, "hey! ta vendo o que ta acontecendo?<br /> parece que a crise economica est� bem complicada.<br /> isso � ruim pros neg�cios, crise � igual a menos clientes. e agora?");
		mapText.put(20, "Chefe! n�o vimos voc� por aqui, o conselho superior ligou alertando sobre a crise.<br /> querem que voc� tome alguma atitude preventiva...");
		mapText.put(21, "imediatamente!");
		mapText.put(22, "QUE PORCARIA � ESSA!? Eu n�o vou comer isso aqui!<br />Mas senhor, � exatamente o que voc� pediu.");
		mapText.put(23, "(O que fazer?)");
		mapText.put(24, "EU QUERO FALAR COM O GERENTE! AGORA!");
		mapText.put(25, "AI EST� VOC�!!<br /> PODE ME DIZER O QUE � ISSO?<br />ISSO N�O � MU�ARELA! A VERDADEIRA MU�ARELA DE B�FALA N�O SE COMPARA COM ESTA PORCARIA<BR /> N�O VOU PAGAR POR UMA PIZZA HORRIVEL DESSAS.");
		mapText.put(26, "TENTE SABOREAR UM POUCO ESTA PORCARIA. Eae? gostou?");
		mapText.put(27, "Humpf... to vendo que n�o vai sair nada de bom daqui, eu vou embora.");
		mapText.put(28, "Os investimentos recentes n�o est�o dando retorno, e ainda por cima, as despezas tem aumentado.");
		mapText.put(29, "Tem certeza que � uma boa ideia manter o projeto em andamento?");
		mapText.put(30, "Certo,");
		mapText.put(31, "Ol� chefe. Sabe estive pensando um pouco e meio que..... estou precisando de um aumento.");
		mapText.put(32, "Ser� que � possivel?");
		mapText.put(33, "Entendo, desculpe por te incomodar.");
		mapText.put(34, "Hey chefe, A demanda est� muito grande! Os ingredientes est�o acabando!");
		mapText.put(35, "O que faremos?!");
		mapText.put(36, "Uffa, essa foi por pouco hein.");
		mapText.put(37, "Parece que abriu uma nova pizzaria na vizinhan�a?<br /> talvez seja por isso que as vendas tem ca�do.");
		mapText.put(38, "se n�o fizermos nada, pode ser que eles comprometam nosso crescimento.<br /> Tem algum plano?");
		mapText.put(39, "Est� certo! vamos mostrar do que somos capazes!");
		mapText.put(40, "Os clientes est�o voltando. A demanda est� maior do que nunca, mas agora s�o muitos pedidos de entrega, e durante os hor�rios de pico, n�o estamos dando conta.");
		mapText.put(41, "(a necessidade de mais funcion�rios � ineg�vel, mas quando fazer as entrevistas?)");
		mapText.put(42, "Certo, colocarei avisos pela cidade.(A nova equipe come�ara o mais r�pido possivel)");
		mapText.put(43, "Nunca imaginei que diria isso, mas nosso estoque est� pequeno demais para suportar a quantidade de ingredientes que usamos semanalmente.");
		mapText.put(44, "Vamos deixar do jeito que est�? ou faremos alguma modifica��o local?");
		mapText.put(45, "Vamos ver o que podemos fazer ent�o");
		mapText.put(46, "Mas o que vamos fazer com esse excesso de igredientes que temos no momento?");
		mapText.put(47, "Eles v�o perecer logo.");
		mapText.put(48, "E n�o � que � uma otima ideia!");
		mapText.put(49, "Ouvimos muita coisa da....<br />(celular toca com o n�mero de emerg�ncia.)<br />Pode atender.");
		mapText.put(50, "(Atende) TEMOS UM PROBLEMA SERIO, ACABAMOS DE SER ASSALTADOS. O pessoal est� em choque, o que devemos fazer agora?");
		mapText.put(51, "Certo!<br />Remarcaremos a reuni�o para uma data futura.<br />deixe o relat�rio e discutiremos sobre ele na proxima reuni�o.");
		mapText.put(52, "(chegando no servi�o, voc� v� o local bem destruido  e a equipe toda de cabe�a baixa)<br /> Eis que aparece um Policial: Jovem, me disseram que � a pessoa responsavel por este local.<br /> Estamos fazendo tudo o possivel para achar o ladr�o.");
		mapText.put(53, "Mas aconcelhamos aumentar a seguran�a do local.");
		mapText.put(54, "Certo, Vamos te atualizar sobre o caso assim que poss�vel.");
		mapText.put(55, "Ol�, sou reporter do Jornal X.<br /> J� conversei com seus funcion�rios, mas ser� que poderia me responder uma pergunta?");
		mapText.put(56, "A sua pizzaria se tornou a mais popular na regi�o. mas voc� acha que o incidente pode acarretar algum problema para os negocios?");
		mapText.put(57, "Muito obrigado pela breve entrevista, retornarei em breve.");
		mapText.put(58, "Aproveitando a destrui��o, o estabelecimento ter� uma reconstru��o.");
		mapText.put(59, "Que mensegem deixaremos para os clientes at� que voltemos?");
		mapText.put(60, "Pronto! j� est� tudo em ordem");
		mapText.put(61, "(Voc� recebe a informa��o de que o ladr�o foi preso.)<br /> Mas ao voltar o funcionamento da pizzaria, voc� percebe que a equipe n�o est� muito animada.");
		mapText.put(62, "(como evitar o desanimo geral?)");
		mapText.put(63, "A equipe entende seu esfor�o, e tenta melhorar o humor");
		mapText.put(64, "O atendente que estava sendo feito de ref�m durante o assalto n�o est� tendo um bom rendimento.");
		mapText.put(65, "Ao ver esta situa��o, voc�...");
		mapText.put(66, "Obrigado.(O atendende muda sua postura.  e em alguns dias ele) Desculpe!, vou me concentrar mais.");
		mapText.put(67, "Parabens! sua filial foi considerada a de maior rendimento este m�s, mesmo com os contratempos<br />apresentados. Mas lembre-se, seu contrato acaba no final do m�s que vem.");
		mapText.put(68, "Estamos aumentando o seu or�amento para que fa�a os preparativos. Use bem estes recursos.");
		mapText.put(69, "Aguardaremos o relat�rio no final do per�odo.");
		mapText.put(70, "Est� preocupado com alguma coisa? Voc� n�o parece estar muito bem.");
		mapText.put(71, "(ninguem est� ciente de sua saida)Precisa de alguma coisa?");
		mapText.put(72, "Pode contar conosco sempre que precisar. Afinal somos amigos.");
		mapText.put(73, "Bom dia. Parece que hoje � o dia da sucess�o.");
		mapText.put(74, "Quais foram as dificuldades enfrentadas durante estes 6 meses?");
		mapText.put(75, "Foi bom trabalhar contigo, Obrigado por seu servi�o.");
	}

}
