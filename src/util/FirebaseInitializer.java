package util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {
    
    private static boolean initialized = false;
    
    public static void initialize() {
        if (initialized) {
            return; // Already initialized
        }
        
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://library-management-syste-ba261-default-rtdb.firebaseio.com") 
                .build();
            
            FirebaseApp.initializeApp(options);
            initialized = true;
            System.out.println("Firebase has been initialized successfully.");
            
        } catch (IOException e) {
            System.err.println("Error initializing Firebase: " + e.getMessage());
            e.printStackTrace();
        }
    }
}