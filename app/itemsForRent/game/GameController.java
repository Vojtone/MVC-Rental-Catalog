package app.itemsForRent.game;

import app.itemsForRent.item.ItemController;

public class GameController extends ItemController {
    private Game model;
    private GameView view;

    public GameController(Game model, GameView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    public void setPublisher(String publisher){
        model.setPublisher(publisher);
    }

    public void setPlatform(Platform platform){
        model.setPlatform(platform);
    }

    public String getPublisher(){
        return model.getPublisher();
    }

    public Platform getPlatform(){
        return model.getPlatform();
    }

    public void updateView(){
        super.updateView();
        view.printGameDetails(model.getPublisher(), model.getPlatform());
    }
}
