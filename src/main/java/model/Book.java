package main.java.model;

public class Book {
    private String bookName;
    private boolean borrowed;

    public Book (String bookName, boolean borrowed){
        this.bookName = bookName;
        this.borrowed = borrowed;
    }

    public void setBookid(String bookName){
        this.bookName = bookName;
    }

    public String getbookName(){
        return bookName;
    }

    public void setBorrowedStat(Boolean status){
        this.borrowed = status;
    }

    public Boolean getBorrowedStat(){
        return borrowed;
    }
    
}
