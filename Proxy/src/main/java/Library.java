import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(RealDocument doc) {
        documents.put(doc.getId(), doc);
    }

    public void addProtectedDocument(RealDocument doc) {
        DocumentProxy proxy = new DocumentProxy(doc);
        documents.put(doc.getId(), proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}