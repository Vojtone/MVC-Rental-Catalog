package app;

import app.catalog.Catalog;
import app.itemsForRent.Category;
import app.itemsForRent.film.Format;
import app.itemsForRent.game.Platform;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static void initWithDummyData(Catalog catalog) {
        catalog.addNewBook("Thinking in Java", Category.C, 1999,
                "Bruce Eckel", "893-332-22-3-222-1", 1248);
        catalog.addNewFilm("Interstellar", Category.A, 2014,
                "Christopher Nolan", Format.DVD, 123);
        catalog.addNewGame("Skyrim", Category.A, 2011, "Bethesda",
                Platform.PC);
    }

    private static int inputInt () {
        int input;
        while(true) {
            try {
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please try again.");
            }
        }
        return input;
    }

    private static String inputString () {
        String input;
        while(true) {
            try {
                Scanner s = new Scanner(System.in);
                input = s.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please try again.");
            }
        }
        return input;
    }

    private static Category inputCategory () {
        Category input;
        while(true) {
            try {
                Scanner s = new Scanner(System.in);
                input = Category.valueOf(s.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input. Please try again.");
            }
        }
        return input;
    }

    private static Platform inputPlatform () {
        Platform input;
        while(true) {
            try {
                Scanner s = new Scanner(System.in);
                input = Platform.valueOf(s.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input. Please try again.");
            }
        }
        return input;
    }

    private static Format inputFormat () {
        Format input;
        while(true) {
            try {
                Scanner s = new Scanner(System.in);
                input = Format.valueOf(s.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input. Please try again.");
            }
        }
        return input;
    }

    private static void addBook(Catalog catalog) {
        System.out.print("Title: ");
        String title = inputString();
        System.out.print("Category (A-D): ");
        Category category = inputCategory();
        System.out.print("Year of publication: ");
        int yearOfPublication = inputInt();
        System.out.print("Author: ");
        String author = inputString();
        System.out.print("ISBN: ");
        String isbn = inputString();
        System.out.print("Number of pages: ");
        int numberOfPages = inputInt();

        try {
            if (catalog.addNewBook(title, category, yearOfPublication,
                    author, isbn, numberOfPages))
                System.out.println("Book added.");
            else
                System.out.println("Given book already exists in catalog.");
        } catch(IllegalArgumentException e) {
            System.out.println("Year of publication must be between 1900 and current year " +
                    "and number of pages must be greater than 0.");
        }
    }

    private static void addFilm(Catalog catalog) {
        System.out.print("Title: ");
        String title = inputString();
        System.out.print("Category (A-D): ");
        Category category = inputCategory();
        System.out.print("Year of publication: ");
        int yearOfPublication = inputInt();
        System.out.print("Director: ");
        String director = inputString();
        System.out.print("Format (DVD, BluRay, VHS): ");
        Format format = inputFormat();
        System.out.print("Duration (min): ");
        int duration = inputInt();

        try {
            if (catalog.addNewFilm(title, category, yearOfPublication,
                    director, format, duration))
                System.out.println("Film added.");
            else
                System.out.println("Given film already exists in catalog.");
        } catch (IllegalArgumentException e) {
            System.out.println("Year of publication must be between 1900 and current year " +
                    "and duration must be greater than 0.");
        }
    }

    private static void addGame(Catalog catalog) {
        System.out.print("Title: ");
        String title = inputString();
        System.out.print("Category (A-D): ");
        Category category = inputCategory();
        System.out.print("Year of publication: ");
        int yearOfPublication = inputInt();
        System.out.print("Publisher: ");
        String publisher = inputString();
        System.out.print("Platform (PC, XBOX, PS2, PS3, PS4, PSP): ");
        Platform platform = inputPlatform();

        try {
            if (catalog.addNewGame(title, category, yearOfPublication,
                    publisher, platform))
                System.out.println("Game added.");
            else
                System.out.println("Given game already exists in catalog.");
        } catch (IllegalArgumentException e) {
            System.out.println("Year of publication must be between 1900 and current year.");
        }
    }

    private static void deleteBook(Catalog catalog) {
        System.out.println("Please insert ISBN of book you want to delete.");
        System.out.print("ISBN: ");
        String isbn = inputString();

        if (catalog.deleteBook(isbn))
            System.out.println("Book deleted.");
        else
            System.out.println("There is no book with given ISBN in the catalog.");
    }

    private static void deleteFilm(Catalog catalog) {
        System.out.println("Please insert title, director and format of film you want to delete.");
        System.out.print("Title: ");
        String title = inputString();
        System.out.print("Director: ");
        String director = inputString();
        System.out.print("Format: ");
        Format format = inputFormat();

        if (catalog.deleteFilm(title, director, format))
            System.out.println("Film deleted.");
        else
            System.out.println("There is no film with given title, " +
                    "director and format in the catalog.");
    }

    private static void deleteGame(Catalog catalog) {
        System.out.println("Please insert title, publisher and platform of game you want to delete.");
        System.out.print("Title: ");
        String title = inputString();
        System.out.print("Publisher: ");
        String publisher = inputString();
        System.out.print("Platform: ");
        Platform platform = inputPlatform();

        if (catalog.deleteGame(title, publisher, platform))
            System.out.println("Game deleted.");
        else
            System.out.println("There is no game with given title, " +
                    "publisher and platform in the catalog.");
    }

    public static void main(String[] args) {

        Catalog catalog = new Catalog();
        boolean programRunning = true;

        initWithDummyData(catalog);

        while(programRunning){
            System.out.println("| 1 - show items | 2 - add item | 3 - delete item | 0 - exit |" );

            int choiceLvl0 = inputInt();
            switch (choiceLvl0) {
                case 0: { //exit
                    programRunning = false;
                    break;
                }
                case 1: { //show
                    System.out.println("What do you want to see?");
                    System.out.println("| 1 - everything | 2 - books | 3 - films | 4 - games " +
                            "| 5 - search by title | 9 - back | 0 - exit |");
                    int choiceLvl1 = inputInt();
                    switch (choiceLvl1) {
                        case 0: {
                            programRunning = false;
                            break;
                        }
                        case 1: {
                            catalog.printAll();
                            break;
                        }
                        case 2: {
                            catalog.printBooks();
                            break;
                        }
                        case 3: {
                            catalog.printFilms();
                            break;
                        }
                        case 4: {
                            catalog.printGames();
                            break;
                        }
                        case 5: {
                            System.out.println("What title are you looking for?");
                            String title = inputString();
                            catalog.searchByTitle(title);
                            break;
                        }
                        case 9: {
                            break;
                        }
                        default: {
                            System.out.println("Wrong input. Please try again.");
                        }
                    }
                    break;
                }
                case 2: { //add new item
                    System.out.println("What do you want to add?");
                    System.out.println("| 1 - book | 2 - film | 3 - game | 9 - back | 0 - exit |");
                    int choiceLvl1 = inputInt();
                    switch (choiceLvl1) {
                        case 0: {
                            programRunning = false;
                            break;
                        }
                        case 1: {
                            addBook(catalog);
                            break;
                        }
                        case 2: {
                            addFilm(catalog);
                            break;
                        }
                        case 3: {
                            addGame(catalog);
                            break;
                        }
                        case 9: {
                            break;
                        }
                        default: {
                            System.out.println("Wrong input. Please try again.");
                        }
                    }
                    break;
                }
                case 3: { //delete item
                    System.out.println("What do you want to delete?");
                    System.out.println("| 1 - book | 2 - film | 3 - game | 9 - back | 0 - exit |");
                    int choiceLvl1 = inputInt();
                    switch (choiceLvl1) {
                        case 0: {
                            programRunning = false;
                            break;
                        }
                        case 1: {
                            deleteBook(catalog);
                            break;
                        }
                        case 2: {
                            deleteFilm(catalog);
                            break;
                        }
                        case 3: {
                            deleteGame(catalog);
                            break;
                        }
                        case 9: {
                            break;
                        }
                        default: {
                            System.out.println("Wrong input. Please try again.");
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Wrong input. Please try again.");
                }
            }
        }
    }
}
