package app.itemsForRent.book;

import app.itemsForRent.item.ItemController;

public class BookController extends ItemController {
    private Book model;
    private BookView view;

    public BookController(Book model, BookView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    public void setAuthor(String author){
        model.setAuthor(author);
    }

    public void setIsbn(String isbn){
        model.setIsbn(isbn);
    }

    public void setNumberOfPages(int numberOfPages){
        model.setNumberOfPages(numberOfPages);
    }

    public String getAuthor(){
        return model.getAuthor();
    }

    public String getIsbn(){
        return model.getIsbn();
    }

    public int getNumberOfPages(){
        return model.getNumberOfPages();
    }

    public void updateView(){
        super.updateView();
        view.printBookDetails(model.getAuthor(), model.getIsbn(), model.getNumberOfPages());
    }

}
