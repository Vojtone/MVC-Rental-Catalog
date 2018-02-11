package app.itemsForRent.item;

import app.itemsForRent.Category;

public abstract class ItemController {
    private Item model;
    private ItemView view;

    public ItemController(Item model, ItemView view){
        this.model = model;
        this.view = view;
    }

    public void setTitle(String title) {
        model.setTitle(title);
    }

    public void setCategory(Category category) {
        model.setCategory(category);
    }

    public void setYearOfPublication(int yearOfPublication) {
        model.setYearOfPublication(yearOfPublication);
    }

    public String getTitle(){
        return model.getTitle();
    }

    public Category getCategory(){
        return model.getCategory();
    }

    public int getYearOfPublication(){
        return model.getYearOfPublication();
    }

    public void updateView(){
        view.printItemDetails(model.getTitle(), model.getCategory(), model.getYearOfPublication());
    }
}
