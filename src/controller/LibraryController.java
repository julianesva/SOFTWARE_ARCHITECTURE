package controller;

import model.Book;
import model.Student;
import model.LibraryManagement; // Your model class that handles data
import view.LibraryView;

public class LibraryController {
    private LibraryView view;
    private LibraryManagement model;
    
    public LibraryController(LibraryView view, LibraryManagement model) {
        this.view = view;
        this.model = model;
        
        // Set this controller to the view
        this.view.setController(this);
    }
    
    public void handleBorrowAction() {
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
            //Book book = model.findBookByTitle(bookTitle);
            Book returnBook = model.findBookByTitle(bookTitle);
            if (returnBook != null) {
                //model.borrowBook(student, returnBook);
                view.setStatusMessage("Book in the library");
            } else {
                view.setStatusMessage("We do not have that book, Sorry :((");
            }  
            if (returnBook != null){
            boolean availavilty = model.bookAvailability(returnBook); 
            if (availavilty == true) {
                //model.borrowBook(student, returnBook);
                view.setStatusMessage("Book borrowed successfully!");
                view.clearForm();
            } else {
                view.setStatusMessage("Not available book for the moment.");
            }  
            } 
        } catch (Exception e) {
            view.setStatusMessage("Error: " + e.getMessage());
        }
    }
}
