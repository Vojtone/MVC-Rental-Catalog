package app.itemsForRent.game;

import app.itemsForRent.item.ItemView;

public class GameView extends ItemView {
    public void printGameDetails(String publisher, Platform platform){
        System.out.println("publisher: " + publisher);
        System.out.println("platform: " + platform);
    }
}
