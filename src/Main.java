import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        String input;
        ArrayList <Book> books = new ArrayList <Book>();
        
        Book book1 = new Book();
        book1.name = "Harry Potter & The Prison of Azkaban";
        book1.author = "J.K Rowling";
        
        Book book2 = new Book();
        book2.name = "The Hobbit";
        book2.author = "J.R.R Tolkien";
        
        books.add( book1 );
        books.add( book2 );
        
        System.out.println( "Welcome to Fantasy Library! Here you can add, remove and view your books." );
        System.out.println( "Commands: show books, add book, change book read status, remove book, help, exit" );
        
        while ( !Objects.equals( input = scanner.nextLine(), "exit" ) ) {
            switch ( input ) {
                case "show books" -> {
                    loopBooks( books );
                    break;
                }
                case "add book" -> {
                    addNewBook( books );
                    break;
                }
                case "change book read status" -> {
                    changeBooksReadStatus( books );
                    break;
                }
                case "remove book" -> {
                    removeBook( books );
                    break;
                }
                case "help" -> {
                    System.out.println( """
                            Commands:
                            show books\s
                            add book\s
                            change book read status\s
                            remove book \s
                            help \s
                            exit""" );
                    break;
                }
                default -> {
                    System.out.println( "Sorry I didn't quite catch that. Please try again..." );
                }
            }
        }
        System.out.println( "Goodbye" );
        
        
    }
    
    private static void changeBooksReadStatus ( ArrayList <Book> books ) {
        Scanner newScanner = new Scanner( System.in );
        System.out.println("Please enter the number of the book you want to change the status:");
        books.get( (newScanner.nextInt() - 1) ).changeBookReadStatus();
        loopBooks( books );
    }
    
    private static void removeBook ( ArrayList <Book> books ) {
        Scanner newScanner = new Scanner( System.in );
        System.out.println("Please enter the number of the book you want to remove:");
        books.remove( (newScanner.nextInt() - 1) );
        System.out.println("Book removed from library :(");
        loopBooks( books );
        
    }
    
    private static void loopBooks ( ArrayList <Book> books ) {
        System.out.println("Current books on the library:");
        for ( int i = 0; i < books.size(); i++ ) {
            Book book = books.get( i );
            String bookIsRead = book.isRead ? " Is read :)" : " Not read :(";
            System.out.println( ( i + 1 ) + ", " + book.name + ", by " + book.author + "." + bookIsRead);
        }
    }
    
    private static void addNewBook ( ArrayList <Book> books ) {
        Scanner newScanner = new Scanner( System.in );
        Book newBook = new Book();
        
        System.out.println( "Adding new book.." );
        System.out.println( "What is the books name?" );
        newBook.name = newScanner.nextLine();
        System.out.println( "What about the authors name?" );
        newBook.author = newScanner.nextLine();
        books.add( newBook );
        System.out.println( "New book added!" );
        loopBooks( books );
    }
    
}



