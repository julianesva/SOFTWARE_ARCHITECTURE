import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreSetup {
    private static final Firestore db = FirestoreClient.getFirestore();

    public static void setupDatabase() {
        String[] bookTitles = {
            "The Gold Rule Of Businesses",
            "The Obstacle is the Way",
            "48 Power Laws",
            "Atomic Habits"
        };

        for (String title : bookTitles) {
            addBookToDatabase(title);
        }
    }

    private static void addBookToDatabase(String title) {
        Map<String, Object> bookData = new HashMap<>();
        bookData.put("title", title);
        bookData.put("borrowed", false); // Default: book is not borrowed

        db.collection("books").document(title).set(bookData)
                .thenRun(() -> System.out.println("📚 Book added: " + title))
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }
}

