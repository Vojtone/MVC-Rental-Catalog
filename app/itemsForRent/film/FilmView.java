package app.itemsForRent.film;

import app.itemsForRent.item.ItemView;

public class FilmView extends ItemView {
    public void printFilmDetails(String director, Format format, int duration){
        System.out.println("director: " + director);
        System.out.println("format: " + format);
        System.out.println("duration: " + duration + " min");
    }
}
