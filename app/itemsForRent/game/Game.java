package app.itemsForRent.game;

import app.itemsForRent.item.Item;
import app.itemsForRent.Category;

public class Game extends Item {
    private String publisher;
    private Platform platform;

    public Game(String title, Category category, int yearOfPublication, String publisher,
                Platform platform) {
        super(title, category, yearOfPublication);
        this.publisher = publisher;
        this.platform = platform;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public Platform getPlatform() {
        return platform;
    }
}
