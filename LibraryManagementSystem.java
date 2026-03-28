package Project1;
import java.util.Scanner;

class Library {
    String[]books;
    int no_of_books;

    Library () {
        this.books = new String[100];
        this.no_of_books = 0;
    }

    //Add Book
    void addBook(String book) {
        this.books[no_of_books] = book;
        no_of_books++;
        System.out.println(book+ " has been added!");
    }

    //Show Book
    void showAvailableBooks () {
        System.out.println("Available books are:");
        for (String book:this.books) {
            if (book ==null) {
                continue;
            }
            System.out.println("*" + book);
        }
    }

    //Issue Book
    void issueBook (String book) {
        for (int i=0; i<this.books.length; i++) {
            if (this.books[i].equals(book)) {
                System.out.println("The book has been issued!");
                this.books[i] = null;
                return;
            }
        }
        System.out.println("This book does not exist");
    }

    // Return Book
    void returnBook (String book) {
        addBook(book);
        System.out.println("The book has been returned");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library centralLibrary =new Library();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n---LIBRARY MENU---");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    System.out.println("Enter book name:");
                    String addBook = sc.nextLine();
                    centralLibrary.addBook(addBook);
                    break;

                case 2:
                    centralLibrary.showAvailableBooks();
                    break;

                case 3:
                    System.out.println("Enter book to issue:");
                    String issueBook = sc.nextLine();
                    centralLibrary.issueBook(issueBook);
                    break;
                case  4:
                    System.out.println("Enter book to return:");
                    String returnBook = sc.nextLine();
                    centralLibrary.returnBook(returnBook);
                    break;
                case 5:
                    System.out.println("Exiting....Thnak you!"); 
                    return;

                    default:
                        System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
