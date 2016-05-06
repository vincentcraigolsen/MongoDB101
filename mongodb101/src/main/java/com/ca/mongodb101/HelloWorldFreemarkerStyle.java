/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ca.mongodb101;

import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author volsen
 */
public class HelloWorldFreemarkerStyle {
	public static void main(String[] args) throws MalformedTemplateNameException{
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
		
		try {
			Template helloTemplate = configuration.getTemplate("hello.ftl");
			StringWriter writer = new StringWriter();
			Map<String, Object> helloMap = new HashMap<>();
			helloMap.put("name", "Freemarker");

			helloTemplate.process(helloMap, writer);

			System.out.println(writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
