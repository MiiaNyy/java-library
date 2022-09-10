public class Book {
    String name;
    String author;
    boolean isRead = false;
    
    public void changeBookReadStatus () {
        isRead = !isRead;
        if ( isRead ) {
            System.out.println( "Congratulations! You just read a book!" );
        } else {
            System.out.println( "So you unread the book?" );
        }
    };
}
