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
import main.java.controller.SearchLibraryController;


public class SearchLibraryView {
    // UI components accessible by the controller
    private TextField nameField;
    private TextField idField;
    private TextField bookField;
    private Button borrowButton;
    private Label statusLabel;
    
    // Reference to the controller
    private SearchLibraryController controller;
    
    public void setController(SearchLibraryController controller) {
        this.controller = controller;
    }
    
    public void initialize(Stage primaryStage) {
        // Set the title of the window
        primaryStage.setTitle("Library Search System");
        
        // Create UI components
        Label bookLabel = new Label("Book Title:");
        bookField = new TextField();

        
        SearchButton = new Button("Search Book");
        // The controller will handle the action
        SearchButton.setOnAction(e -> controller.handleSearchAction());
        
        statusLabel = new Label("Enter information and click Search Book");
        
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
            new Label("Library Book Search System"),
            grid,
            buttonBox,
            statusLabel
        );
        
        // Create a scene
        Scene scene = new Scene(mainLayout, 400, 250);
        
        // Set the scene to the stage and show
        primaryStage.setScene(scene);
    }
    
    public String getBookTitle() {
        return bookField.getText();
    }
    
    // Methods for the controller to manipulate the view
    public void clearForm() {
        bookField.clear();
    }
    
    public void setStatusMessage(String message) {
        statusLabel.setText(message);
    }
}
