package com.ca.mongodb101;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreemarkerStyle {
	public static void main(String[] args) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

		Spark.get("/name", new Route() {
			@Override
			public Object handle(spark.Request rqst, spark.Response rspns) throws Exception {
				StringWriter writer = new StringWriter();
				try {
					Template helloTemplate = configuration.getTemplate("hello.ftl");
					Map<String, Object> helloMap = new HashMap<>();
					helloMap.put("name", "Freemarker");

					helloTemplate.process(helloMap, writer);					
				} catch (Exception e) {
//					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});

	}
}
