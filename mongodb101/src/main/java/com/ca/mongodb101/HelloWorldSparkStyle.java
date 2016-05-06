package com.ca.mongodb101;

import spark.Route;
import spark.Spark;

public class HelloWorldSparkStyle {
	public static void main(String[] args) {
		Spark.get("/", new Route() {
			@Override
			public Object handle(spark.Request rqst, spark.Response rspns) throws Exception {
				return "Hello world from spark";
			}
		});
	}
}
