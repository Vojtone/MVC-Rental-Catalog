package app.itemsForRent.item;

import app.itemsForRent.Category;

public abstract class ItemView {
    public void printItemDetails(String title, Category category, int yearOfPublication){
        System.out.println("title: " + title);
        System.out.println("category: " + category);
        System.out.println("year of publication: " + yearOfPublication);
    }
}
