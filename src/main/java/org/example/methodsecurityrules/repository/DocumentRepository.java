package org.example.methodsecurityrules.repository;

import org.example.methodsecurityrules.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository {

    private Map<String, Document> documents =
            Map.of("abc123", new Document("john"),
            "qwe123", new Document("john"),
            "asd555", new Document("emma"));

    public Document findDocument(String code){
        return documents.get(code);
    }
}
