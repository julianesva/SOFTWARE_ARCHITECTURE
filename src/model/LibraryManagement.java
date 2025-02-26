package model;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {

    private List<Book> bookList;

    public LibraryManagement(){
        this.bookList = new ArrayList<>();
        bookList.add(new Book("The Gold Rule Of Businesses", false));
        bookList.add(new Book("The Obstacle is the Way", false));
        bookList.add(new Book("48 Power Laws", false));
        bookList.add(new Book("Atomic Habits", false));
    }

    public Book findBookByTitle(String booktitle){
        for (Book book : bookList) {
            if (book.getbookName().equalsIgnoreCase(booktitle)){
                return book;
            }
        }
        return null;
    }

    public boolean bookAvailability(Book book){

        if (!book.getBorrowedStat()){
            book.setBorrowedStat(true);
            return true;
        }
        return false;

    }

    //public void borrowBook(Student student, Book book){}

    

}
