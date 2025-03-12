package main.java.controller;

import main.java.model.Book;
import main.java.model.Student;
import main.java.model.LibraryManagement; // Your model class that handles data
import main.java.view.ReturnLibraryView;

public class ReturnLibraryController {
    private ReturnLibraryView view;
    private LibraryManagement model;
    
    public ReturnLibraryController(ReturnLibraryView view, LibraryManagement model) {
        this.view = view;
        this.model = model;
        
        // Set this controller to the view of the MVC model.
        this.view.setController(this);
    }
    
    public void handleReturnAction() {
        try {
            // Get data from view
            String name = view.getStudentName();
            String id = view.getStudentId();
            String bookTitle = view.getBookTitle();
            
            // Validate
            if (name.isEmpty() || id.isEmpty() || bookTitle.isEmpty()) {
                view.setStatusMessage("Please fill in all fields");
                return;
            }
            
            if (!id.matches("\\d+")) {
                view.setStatusMessage("ID must contain only numbers");
                return;
            }
            
            // Use model to process data
            Student student = new Student(name, id);
            Book returnBook = model.findBookByTitle(bookTitle);
            if (returnBook != null) {
                view.setStatusMessage("Book in the library, proceed to return!");
            } else {
                view.setStatusMessage("We do not have that book, Sorry :((");
            }  
            if (returnBook != null){
            boolean currentCondition = model.bookreturn(returnBook); 
            if (currentCondition == true) {
                view.setStatusMessage("Successfull book return!");
                view.clearForm();
            } else {
                view.setStatusMessage("Something is wrong with the return process.");
            }  
            } 
        } catch (Exception e) {
            view.setStatusMessage("Error: " + e.getMessage());
        }
    }
}

