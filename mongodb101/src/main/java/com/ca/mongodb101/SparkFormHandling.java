package com.ca.mongodb101;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkFormHandling {
	public static void main(String[] args) {

		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandling.class, "/fruit_form");

		Spark.get("/fruit", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					Map<String, Object> fruitsMap = new HashMap<String, Object>();
					fruitsMap.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));

					Template fruitPickerTemplate = configuration.getTemplate("fruitpicker.ftl");
					StringWriter writer = new StringWriter();
					fruitPickerTemplate.process(fruitsMap, writer);
					return writer;

				} catch (Exception ex) {
//					halt(500);
					return null;
				}
			}
		});

		Spark.post("/favorit_fruit", new Route() {

			@Override
			public Object handle(final Request request, final Response response) {
				final String fruit = request.queryParams("fruit");
				if (fruit == null) {
					return "Why don't you pick one?";
				} else {
					return "Hey, your facorite fruit is " + fruit;
				}
			}
		});
	}
}
