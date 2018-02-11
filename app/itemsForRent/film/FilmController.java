package app.itemsForRent.film;

import app.itemsForRent.item.ItemController;

public class FilmController extends ItemController {
    private Film model;
    private FilmView view;

    public FilmController(Film model, FilmView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    public void setDirector(String director){
        model.setDirector(director);
    }

    public void setFormat(Format format){
        model.setFormat(format);
    }

    public void setDuration(int duration){
        model.setDuration(duration);
    }

    public String getDirector(){
        return model.getDirector();
    }

    public Format getFormat(){
        return model.getFormat();
    }

    public int getDuration(){
        return model.getDuration();
    }

    public void updateView(){
        super.updateView();
        view.printFilmDetails(model.getDirector(), model.getFormat(), model.getDuration());
    }
}
