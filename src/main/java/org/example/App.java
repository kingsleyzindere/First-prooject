package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {

        // Connect to MongoDB running in Docker
        try (MongoClient mongoClient =
                     MongoClients.create("mongodb://mongo-dbserver")) {

            // Select the database
            MongoDatabase database = mongoClient.getDatabase("mydb");

            // Select the collection (similar to a table in SQL)
            MongoCollection<Document> collection =
                    database.getCollection("test");

            // Create a document to store
            Document doc = new Document("name", "Kevin Sim")
                    .append("class", "DevOps")
                    .append("year", "2024")
                    .append("result",
                            new Document("CW", 95)
                                    .append("EX", 85));

            // Insert the document into MongoDB
            collection.insertOne(doc);

            // Get the first document from the collection
            Document myDoc = collection.find().first();

            // Print it
            System.out.println(myDoc.toJson());
        }
    }
}