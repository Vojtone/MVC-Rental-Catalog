package app.catalog;

import java.util.*;
import app.itemsForRent.Category;
import app.itemsForRent.book.Book;
import app.itemsForRent.book.BookController;
import app.itemsForRent.book.BookView;
import app.itemsForRent.film.Film;
import app.itemsForRent.film.FilmController;
import app.itemsForRent.film.FilmView;
import app.itemsForRent.film.Format;
import app.itemsForRent.game.Game;
import app.itemsForRent.game.GameController;
import app.itemsForRent.game.GameView;
import app.itemsForRent.game.Platform;


public class Catalog {
    private List<BookController> books;
    private List<FilmController> films;
    private List<GameController> games;

    public Catalog(){
        this.books = new ArrayList<BookController>();
        this.films = new ArrayList<FilmController>();
        this.games = new ArrayList<GameController>();
    }

    private boolean equalBooks(BookController bc1, BookController bc2) {
        return (bc1.getTitle().equals(bc2.getTitle()) && bc1.getCategory() == bc2.getCategory() &&
                bc1.getYearOfPublication() == bc2.getYearOfPublication() &&
                bc1.getAuthor().equals(bc2.getAuthor()) && bc1.getIsbn().equals(bc2.getIsbn()) &&
                bc1.getNumberOfPages() == bc2.getNumberOfPages());
    }

    private boolean equalFilms(FilmController fc1, FilmController fc2) {
        return (fc1.getTitle().equals(fc2.getTitle()) && fc1.getCategory() == fc2.getCategory() &&
                fc1.getYearOfPublication() == fc2.getYearOfPublication() &&
                fc1.getDirector().equals(fc2.getDirector()) && fc1.getFormat() == fc2.getFormat() &&
                fc1.getDuration() == fc2.getDuration());
    }

    private boolean equalGames(GameController gc1, GameController gc2) {
        return (gc1.getTitle().equals(gc2.getTitle()) && gc1.getCategory() == gc2.getCategory() &&
                gc1.getYearOfPublication() == gc2.getYearOfPublication() &&
                gc1.getPublisher().equals(gc2.getPublisher()) &&
                gc1.getPlatform() == gc2.getPlatform());
    }

    public boolean addNewBook(String title, Category category, int yearOfPublication, String author,
                           String isbn, int numberOfPages) {
        Book b = new Book(title, category, yearOfPublication, author, isbn, numberOfPages);
        BookView bv = new BookView();
        BookController bc = new BookController(b, bv);
        for (BookController bCtrl: books) {
            if (equalBooks(bCtrl, bc))
                return false;
        }
        books.add(bc);
        return true;
    }

    public boolean addNewFilm(String title, Category category, int yearOfPublication, String director,
                           Format format, int duration) {
        Film f = new Film(title, category, yearOfPublication, director, format, duration);
        FilmView fv = new FilmView();
        FilmController fc = new FilmController(f, fv);
        for (FilmController fCtrl: films) {
            if (equalFilms(fCtrl, fc))
                return false;
        }
        films.add(fc);
        return true;
    }

    public boolean addNewGame(String title, Category category, int yearOfPublication, String publisher,
                           Platform platform) {
        Game g = new Game(title, category, yearOfPublication, publisher, platform);
        GameView gv = new GameView();
        GameController gc = new GameController(g, gv);
        for (GameController gCtrl: games) {
            if (equalGames(gCtrl, gc))
                return false;
        }
        games.add(gc);
        return true;
    }

    public boolean deleteBook(String isbn) {
        for (BookController bCtrl: books) {
            if (bCtrl.getIsbn().equals(isbn)) {
                books.remove(bCtrl);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFilm(String title, String director, Format format) {
        for (FilmController fCtrl: films) {
            if (fCtrl.getTitle().toUpperCase().equals(title.toUpperCase()) &&
                    fCtrl.getDirector().toUpperCase().equals(director.toUpperCase()) &&
                    fCtrl.getFormat() == format) {
                films.remove(fCtrl);
                return true;
            }
        }
        return false;
    }

    public boolean deleteGame(String title, String publisher, Platform platform) {
        for (GameController gCtrl: games) {
            if (gCtrl.getTitle().toUpperCase().equals(title.toUpperCase()) &&
                    gCtrl.getPublisher().toUpperCase().equals(publisher.toUpperCase()) &&
                    gCtrl.getPlatform() == platform) {
                games.remove(gCtrl);
                return true;
            }
        }
        return false;
    }

    public void printBooks() {
        for (BookController b: books) {
            b.updateView();
            System.out.println("------------------");
        }
    }

    public void printFilms() {
        for (FilmController f: films) {
            f.updateView();
            System.out.println("------------------");
        }
    }

    public void printGames() {
        for (GameController g: games) {
            g.updateView();
            System.out.println("------------------");
        }
    }

    public void printAll(){
        printBooks();
        printFilms();
        printGames();
    }

    public void searchByTitle(String title) {
        int counter = 0;
        for (BookController b: books) {
            if (b.getTitle().toUpperCase().contains(title.toUpperCase())) {
                b.updateView();
                counter++;
                System.out.println("------------------");
            }
        }
        for (GameController g: games) {
            if (g.getTitle().toUpperCase().contains(title.toUpperCase())) {
                g.updateView();
                counter++;
                System.out.println("------------------");
            }
        }
        for (FilmController f: films) {
            if (f.getTitle().toUpperCase().contains(title.toUpperCase())) {
                f.updateView();
                counter++;
                System.out.println("------------------");
            }
        }
        if (counter == 0) System.out.println("No matches found.");
    }
}
