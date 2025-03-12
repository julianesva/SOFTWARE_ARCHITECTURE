package main.java.view;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import main.java.controller.BorrowLibraryController;
import main.java.controller.ReturnLibraryController;
import main.java.controller.SearchLibraryController;
import main.java.model.LibraryManagement;

public class MainLibraryView {
    private BorrowLibraryView borrowView;
    private SearchLibraryView searchView;
    private ReturnLibraryView returnView;
    private main.java.controller.BorrowLibraryController controller1;
    private main.java.controller.SearchLibraryController controller2;
    private main.java.controller.ReturnLibraryController controller3;
    
    
    public MainLibraryView(LibraryManagement model) {
        this.borrowView = new BorrowLibraryView();
        this.searchView = new SearchLibraryView();
        this.returnView = new ReturnLibraryView();
        
        // Set the controller for each view
        // Create controller with view and model
        controller1 = new BorrowLibraryController(borrowView, model);
        controller2 = new SearchLibraryController(searchView, model);
        controller3 = new ReturnLibraryController(returnView, model);
    }
    
    public void initialize(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");
        
        // Create a TabPane for navigation
        TabPane tabPane = new TabPane();
        
        // Create tabs for each view
        Tab borrowTab = new Tab("Borrow a Book");
        borrowTab.setClosable(false);
        
        Tab searchTab = new Tab("Search a Book");
        searchTab.setClosable(false);
        
        Tab returnTab = new Tab("Return a Book");
        returnTab.setClosable(false);
        
        // Initialize each view and get their root nodes
        borrowView.initialize();
        searchView.initialize();
        returnView.initialize();
        
        // Set content for each tab
        borrowTab.setContent(borrowView.getRoot());
        searchTab.setContent(searchView.getRoot());
        returnTab.setContent(returnView.getRoot());
        
        // Add tabs to the tab pane
        tabPane.getTabs().addAll(borrowTab, searchTab, returnTab);
        
        // Create the main scene
        Scene scene = new Scene(tabPane, 500, 400);
        
        // Set the scene to the stage
        primaryStage.setScene(scene);
    }
}
