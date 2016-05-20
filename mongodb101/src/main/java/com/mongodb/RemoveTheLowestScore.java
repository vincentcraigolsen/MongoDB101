package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class RemoveTheLowestScore {
	public static void main(String[] args) {
		MongoClient client = new MongoClient();

		MongoDatabase db = client.getDatabase("students").withReadPreference(ReadPreference.secondary());

		MongoCollection<BsonDocument> coll = db.getCollection("grades", BsonDocument.class);

		System.out.println(coll.count());
//		System.out.println(coll.find().toString());

		Integer prevStudentId = -1;
		Integer currentStudentId = -1;
		for (BsonDocument doc : coll.find(and(eq("type", "homework")))
			.sort(new BasicDBObject("student_id", 1).append("score", -1))) {
			System.out.println(doc);

			currentStudentId = doc.getInt32("student_id").intValue();
			
			if (currentStudentId.equals(prevStudentId)){
				System.out.println("Score to delete" + doc.getDouble("score").toString());
				coll.deleteOne(doc);
			}
			
			prevStudentId = currentStudentId;
		}

		System.out.println(coll.count());
	}
}
