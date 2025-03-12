package com.julianespinoza.myapp;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.model.LibraryManagement;
import main.java.view.MainLibraryView;
import util.FirebaseInitializer;
import util.FirestoreSetup;

public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        //Initialize firebase data base. 
        FirebaseInitializer.initialize();

        //Set up with initial data firebase DB.
        FirestoreSetup.setupDatabase();

        // Create model
        LibraryManagement model = new LibraryManagement();
        
        // Create view
        MainLibraryView view = new MainLibraryView(model);
        
        // Initialize view
        view.initialize(primaryStage);
        
        // Show the stage
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}