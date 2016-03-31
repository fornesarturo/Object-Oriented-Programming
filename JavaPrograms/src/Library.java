import java.util.ArrayList;

public class Library {
	String address;
	ArrayList<Book> catalogue = new ArrayList<Book>();

	public Library(String street){
		this.address = street;
	}
	
	public void addBook(Book elLibro){
		this.catalogue.add(elLibro);
	}
	
	public void printAvailableBooks(){
		if(catalogue.isEmpty()){
			System.out.println("No book in catalog");
		}
		for(Book elLibro:this.catalogue){
			System.out.println(elLibro.getTitle());
		}
	}
	
	public void borrowBook(String title){
		for(Book elLibro: this.catalogue){
			if(title.equals(elLibro.getTitle())){
				if(elLibro.isBorrowed()){
					System.out.println("Sorry, this book is already borrowed.");
					return;
				}
				else{
					elLibro.rented();
					System.out.println("You successfully borrowed "+title);
					return;
				}
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	public void returnBook(String title){
		for(Book elLibro: this.catalogue){
			if(title.equals(elLibro.getTitle())){
				elLibro.returned();
				System.out.println("You successfully returned "+title);
			}
		}
	}
	
	public void printAddress(){
		System.out.println(address);
	}
	
	public static void printOpeningHours(){
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		
		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		
		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		
		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}
} 