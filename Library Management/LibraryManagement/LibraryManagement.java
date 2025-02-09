package LibraryManagement;

public class LibraryManagement {
	public static void main(String[] args) {
        Library library = new Library();

        
        library.addBook(new Book("Java ", "James Gosling", "1123433"));
        library.addBook(new Book("Python Basics", "Guido van Rossum", "123322"));
        library.addUser(new User("Arshad", "U0010"));
        library.addUser(new User("Manikandan", "U0020"));

        
        library.borrowBook("1123433", "U0010");
        library.borrowBook("654321", "U0020");
        library.returnBook("1123433", "U0010");

        
        Book foundBook = library.findBook("1123433");
        if (foundBook != null) System.out.println("Book Found: " + foundBook);
        else System.out.println("Book Not Found.");
    }
}