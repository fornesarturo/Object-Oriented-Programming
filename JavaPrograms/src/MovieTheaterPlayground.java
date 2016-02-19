import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieTheaterPlayground {
	private static Scanner reader;
	private static String again;
	private static String movies;
	private static String actor;
	
	public static void main(String[] args) throws FileNotFoundException{
		reader = new Scanner(System.in);
		MovieTheater cinemex = new MovieTheater("C:\\Users\\Arturo\\git\\JavaPrograms\\src\\movies.txt");
		cinemex.fileToMap();
		again = "yes";
		while(again.equals("yes")){
			System.out.println("Choose: a - Give us two movies separated by &, | or ^, precious.");
			System.out.println("b - Give us an actor's name. YIS, an actor's name.");
			switch(reader.nextLine()){
			case("a"):
					System.out.println("YIIISS. Give us two movies separated by & (intersection), | (union) or ^ (difference), precious.");
					movies = reader.nextLine();
					cinemex.commonActors(movies);
					break;
			case("b"):
					System.out.println("Name yer sacrifice. YIS, an actor's name.");
					actor = reader.nextLine();
					cinemex.coActors(actor);
					break;
			default: System.out.println("That's not an option");
					continue;
			}
			System.out.println("Again? (yes/no)");
			again = reader.nextLine();
		}
	}
}