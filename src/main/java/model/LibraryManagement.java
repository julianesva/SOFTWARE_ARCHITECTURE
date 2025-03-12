package main.java.model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class LibraryManagement {
    private List<Book> bookList;
    private Firestore db;

    public LibraryManagement() {
        this.bookList = new ArrayList<>();
        this.db = FirestoreClient.getFirestore();
        loadBooksFromFirebase();  // Load books on initialization
    }

    // Load books from Firebase
    private void loadBooksFromFirebase() {
        ApiFuture<QuerySnapshot> future = db.collection("books").get();
        try {
            for (DocumentSnapshot doc : future.get().getDocuments()) {
                String title = doc.getString("title");
                boolean borrowed = doc.getBoolean("borrowed");
                bookList.add(new Book(title, borrowed));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Find book in Firebase
    public Book findBookByTitle(String bookTitle) {
        for (Book book : bookList) {
            if (book.getbookName().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Check availability from Firebase
    public boolean bookAvailability(Book book) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("books").document(book.getbookName());
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            boolean isBorrowed = document.getBoolean("borrowed");
            if (!isBorrowed) {
                docRef.update("borrowed", true); // Mark as borrowed
                book.setBorrowedStat(true);
                return true;
            }
        }
        return false;
    }

    // Return a book in Firebase
    public boolean bookreturn(Book book) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("books").document(book.getbookName());
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            boolean isBorrowed = document.getBoolean("borrowed");
            if (isBorrowed) {
                docRef.update("borrowed", false); // Mark as returned
                book.setBorrowedStat(false);
                return true;
            }
        }
        return false;
    }

    //Add a new book to the data base
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
