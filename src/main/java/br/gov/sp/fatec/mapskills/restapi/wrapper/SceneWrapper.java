/*
 * @(#)QuestionWrapper.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.serializer.SceneDeserializer;

@JsonDeserialize(using = SceneDeserializer.class)
public class SceneWrapper {
	
	private final Scene scene;
	private final String base64;
	private final String filename;
	
	public SceneWrapper(final Scene scene, final String base64, final String filename) {
		this.scene = scene;
		this.base64 = base64;
		this.filename = filename;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public String getFileName() {
		return filename;
	}
	
	public String getBase64() {
		return base64;
	}

}
