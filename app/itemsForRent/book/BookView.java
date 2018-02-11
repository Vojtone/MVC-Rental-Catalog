package app.itemsForRent.book;

import app.itemsForRent.item.ItemView;

public class BookView extends ItemView {
    public void printBookDetails(String author, String isbn, int numberOfPages){
        System.out.println("author: " + author);
        System.out.println("isbn: " + isbn);
        System.out.println("number of pages: " + numberOfPages);
    }
}
