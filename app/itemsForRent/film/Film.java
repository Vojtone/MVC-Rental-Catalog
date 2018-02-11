package app.itemsForRent.film;

import app.itemsForRent.item.Item;
import app.itemsForRent.Category;

public class Film extends Item {
    private String director;
    private Format format;
    private int duration;

    public Film(String title, Category category, int yearOfPublication, String director,
                Format format, int duration) {
        super(title, category, yearOfPublication);
        this.director = director;
        this.format = format;
        if (duration >= 0)
            this.duration = duration;
        else
            throw new IllegalArgumentException();
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setDuration(int duration) {
        if (duration >= 0)
            this.duration = duration;
        else throw new IllegalArgumentException();
    }

    public String getDirector() {
        return director;
    }

    public Format getFormat() {
        return format;
    }

    public int getDuration() {
        return duration;
    }
}