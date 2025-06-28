package dev.akira.arkanoid.mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoSaveExample {

    public static void main(String[] args) {
        String uri = "mongodb+srv://rodrigoakirakira:Boru43524139@arkanoid.p7p4qeh.mongodb.net/?retryWrites=true&w=majority&appName=Arkanoid";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Arkanoid");
            MongoCollection<Document> collection = database.getCollection("Placing");

            // Cria um documento com nome e pontos
            Document resultado = new Document()
                    .append("nome", "Rodrigo")
                    .append("pontos", 12345);

            // Insere o documento na coleção
            collection.insertOne(resultado);

            System.out.println("Resultado salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}