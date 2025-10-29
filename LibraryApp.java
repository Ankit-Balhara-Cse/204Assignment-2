class BookNode {
    int bookID;
    String title;
    String author;
    String status;
    BookNode next;

    public BookNode(int bookID, String title, String author, String status) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.status = status;
        this.next = null;
    }
}

class BookList {

    private BookNode head;

    public void insertBook(int bookID, String title, String author, String status) {

        BookNode newBook = new BookNode(bookID, title, author, status);
        newBook.next = head;
        head = newBook;
        System.out.println("Book added: " + title);
    }

    public void deleteBook(int bookID) {

        BookNode current = head;
        BookNode previous = null;

        while (current != null && current.bookID != bookID) {

            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book with ID " + bookID + " not found.");
            return;
        }

        if (previous == null) {

            head = current.next;
        } else {
            previous.next = current.next;
        }

        System.out.println("Book deleted: " + current.title);
    }

    public BookNode searchBook(int bookID) {

        BookNode current = head;

        while (current != null) {
            if (current.bookID == bookID) {
                System.out.println("Book found: " + current.title);
                return current;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
        return null;
    }

    public void displayBooks() {

        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("Current Library Collection:");
        BookNode current = head;
        while (current != null) {

            System.out.println("ID: " + current.bookID +", Title: " + current.title +", Author: " + current.author +", Status: " + current.status);
            current = current.next;
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {

        BookList library = new BookList();

        library.insertBook(101, "Book1", "Ankit", "Available");
        
        library.insertBook(102, "book2", "Ankit", "Available");
        library.insertBook(103, "book3", "Ankit", "Issued");

        library.displayBooks();

        library.searchBook(102);
        library.deleteBook(103);
        library.displayBooks();
    }
}