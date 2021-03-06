/*
 * @(#)QuestionDeserializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneWrapper;

public class SceneDeserializer extends JsonDeserializer<SceneWrapper> {
	
	private static final String IP_SERVER = "http://localhost:8585/mapskills/";

	@Override
	public SceneWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {

		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final String[] background = verifyBackground(node);    
        final String fileImageBase64 = background[0];
        final String filename = background[1];
        
		
        final Question question = this.buildQuestion(node.get("question"));
        final long gameThemeId = node.get("gameThemeId").asLong();
        final Scene scene = new Scene(node.get("text").asText(), IP_SERVER + "images/" + filename, question, gameThemeId);
        if(node.has("id")) {
        	scene.setId(node.get("id").asLong());
        }
        if(node.has("index")) {
        	scene.putIndex(node.get("index").asInt());
        }
        
		return new SceneWrapper(scene, fileImageBase64, filename);
	}
	
	private Question buildQuestion(final JsonNode node) {
		if(node == null || node.isNull()) {
			return null;
		}
		final List<Alternative> alternatives = buildAlternatives(node.get("alternatives"));
		return new Question(alternatives, node.get("skillId").asLong());
	}
	
	private List<Alternative> buildAlternatives(final JsonNode node) {
		final List<Alternative> alternatives = new ArrayList<>(4);
		for(int i = 0; i < 4; i++ ) {
			final String position = String.valueOf(i);
			if(node.has(position)) {
				alternatives.add(new Alternative(node.get(position).get("description").asText(),
						node.get(position).get("skillValue").asInt()));
			} else {
				alternatives.add(new Alternative(node.get(i).get("description").asText(),
						node.get(i).get("skillValue").asInt()));
			}
			
		}
		return alternatives;
	}
	
	private String[] verifyBackground(final JsonNode node) {
		final String[] background = new String[2];
		if(!node.has("background")) {
			return null;
		}
		if(node.get("background").has("base64")) {
			background[0] = node.get("background").get("base64").asText();
        }
        if(node.get("background").has("filename")) {
        	final String filename = node.get("background").get("filename").asText();
        	final int lastIndex = filename.lastIndexOf("/");
        	background[1] = filename.substring(lastIndex + 1);
        }
        return background;
	}
	
}
