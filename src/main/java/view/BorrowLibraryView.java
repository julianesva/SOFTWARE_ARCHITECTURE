package main.java.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import main.java.controller.BorrowLibraryController;


public class BorrowLibraryView {
    // UI components accessible by the controller
    private TextField nameField;
    private TextField idField;
    private TextField bookField;
    private Button borrowButton;
    private Label statusLabel;
    
    // Reference to the controller
    private BorrowLibraryController controller;
    
    public void setController(BorrowLibraryController controller) {
        this.controller = controller;
    }
    
    public void initialize(Stage primaryStage) {
        // Set the title of the window
        primaryStage.setTitle("Library System");
        
        // Create UI components
        Label nameLabel = new Label("Student Name:");
        nameField = new TextField();
        
        Label idLabel = new Label("Student ID:");
        idField = new TextField();
        
        Label bookLabel = new Label("Book Title:");
        bookField = new TextField();

        
        borrowButton = new Button("Borrow Book");
        // The controller will handle the action
        borrowButton.setOnAction(e -> controller.handleBorrowAction());
        
        statusLabel = new Label("Enter information and click Borrow Book");
        
        // Create a layout container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        // Add components to grid layout
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(idLabel, 0, 1);
        grid.add(idField, 1, 1);
        grid.add(bookLabel, 0, 2);
        grid.add(bookField, 1, 2);
        
        // Create button layout
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));
        buttonBox.getChildren().add(borrowButton);
        
        // Create main layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(
            new Label("Library Book Borrowing System"),
            grid,
            buttonBox,
            statusLabel
        );
        
        // Create a scene
        Scene scene = new Scene(mainLayout, 400, 250);
        
        // Set the scene to the stage and show
        primaryStage.setScene(scene);
    }

    // Getters for the controller to access form data
    public String getStudentName(){
        return nameField.getText();
    }
    
    public String getStudentId() {
        return idField.getText();
    }
    
    public String getBookTitle() {
        return bookField.getText();
    }
    
    // Methods for the controller to manipulate the view
    public void clearForm() {
        nameField.clear();
        idField.clear();
        bookField.clear();
    }
    
    public void setStatusMessage(String message) {
        statusLabel.setText(message);
    }
}