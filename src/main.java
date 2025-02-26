import javafx.application.Application;
import javafx.stage.Stage;
import controller.LibraryController;
import model.LibraryManagement;
import view.LibraryView;

public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create model
        LibraryManagement model = new LibraryManagement();
        
        // Create view
        LibraryView view = new LibraryView();
        
        // Create controller with view and model
        LibraryController controller = new LibraryController(view, model);
        
        // Initialize view
        view.initialize(primaryStage);
        
        // Show the stage
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}