package app.itemsForRent.item;

import app.itemsForRent.Category;
import java.util.Calendar;

public abstract class Item {
    private String title;
    private Category category;
    private int yearOfPublication;

    public Item (String title, Category category, int yearOfPublication) {
        this.title = title;
        this.category = category;
        if (yearOfPublication > 1900 && yearOfPublication <= Calendar.getInstance().get(Calendar.YEAR))
            this.yearOfPublication = yearOfPublication;
        else throw new IllegalArgumentException();
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setCategory (Category category) {
        this.category = category;
    }

    public void setYearOfPublication (int yearOfPublication) {
        if (yearOfPublication > 1900 && yearOfPublication <= Calendar.getInstance().get(Calendar.YEAR)) {
            this.yearOfPublication = yearOfPublication;
        } else throw new IllegalArgumentException();
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
