package main.java.controller;

import main.java.model.Book;
import main.java.model.LibraryManagement; // Your model class that handles data
import main.java.view.SearchLibraryView;

public class SearchLibraryController {
    private SearchLibraryView view;
    private LibraryManagement model;
    
    public SearchLibraryController(SearchLibraryView view, LibraryManagement model) {
        this.view = view;
        this.model = model;
        
        // Set this controller to the view of the MVC model.
        this.view.setController(this);
    }
    
    public void handleSearchAction() {
        try {
            String bookTitle = view.getBookTitle();
            
            // Validate
            if (bookTitle.isEmpty()) {
                view.setStatusMessage("Please fill in all fields");
                return;
            }
            
            Book bookAvailabilty = model.findBookByTitle(bookTitle);
            if (bookAvailabilty != null) {
                view.setStatusMessage("Book in the library");
            } else {
                view.setStatusMessage("We do not have that book, Sorry :((");
            }   
        } catch (Exception e) {
            view.setStatusMessage("Error: " + e.getMessage());
        }
    }
}
