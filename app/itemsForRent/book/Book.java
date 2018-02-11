package app.itemsForRent.book;

import app.itemsForRent.item.Item;
import app.itemsForRent.Category;

public class Book extends Item {
    private String author;
    private String isbn;
    private int numberOfPages;

    public Book (String title, Category category, int yearOfPublication, String author,
                 String isbn, int numberOfPages) {
        super(title, category, yearOfPublication);
        this.author = author;
        this.isbn = isbn;
        if (numberOfPages > 0)
            this.numberOfPages = numberOfPages;
        else throw new IllegalArgumentException();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages > 0)
            this.numberOfPages = numberOfPages;
        else throw new IllegalArgumentException();
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
