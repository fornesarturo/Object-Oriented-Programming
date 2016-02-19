import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class MovieTheater {
	private HashMap<String,ArrayList<String>> listings;
	private Scanner bookWorm;
	private File moviesTxt;

	public MovieTheater(String file){
		this.moviesTxt = new File(file);
		this.listings = new HashMap<String,ArrayList<String>>();
	}
	public void fileToMap() throws FileNotFoundException{
		bookWorm = new Scanner(this.moviesTxt);
		
		while(bookWorm.hasNextLine()){
			String currentLine = bookWorm.nextLine();
			ArrayList<String> lineArray = new ArrayList<String>(Arrays.asList(currentLine.split(",")));
			
			for(int i = 1; i < lineArray.size(); i++){ //Still not a fan of 'for' working as a 'while'.
				String movie = lineArray.get(i).substring(1);
				String actor = lineArray.get(0);
				
				if(this.listings.containsKey(movie)){
					this.listings.get(movie).add(actor);
				}
				else{
					this.listings.put(movie, new ArrayList<String>());
					this.listings.get(movie).add(actor);
				}
			}
		}
		System.out.println(this.listings);
	}
	public void coActors(String givenActor){
		ArrayList<String> coActorsArray = new ArrayList<String>();
		
		for(Object key:this.listings.keySet()){ //'Object' works for any type that's in the container, in this case, Keys.
			if (this.listings.get(key).contains(givenActor)){
				for(String selectedActor:this.listings.get(key)){
					if(!(selectedActor.equals(givenActor)) && !(coActorsArray.contains(key))){
						coActorsArray.add(selectedActor);
					}
				}
			}
		}
		for(String coActor:coActorsArray){
			System.out.print(coActor+", ");
		}
	}
	
	public void commonActors(String moviesInput){
		if(moviesInput.contains("&")){
			String firstMovie = moviesInput.split("\\&")[0];
			String secondMovie = moviesInput.split("\\&")[1];
			
			ArrayList<String> sharedActors = new ArrayList<String>(this.listings.get(firstMovie));
			sharedActors.retainAll(this.listings.get(secondMovie));
			System.out.println(sharedActors);
		}
		else if (moviesInput.contains("|")){
			String firstMovie = moviesInput.split("\\|")[0];
			String secondMovie = moviesInput.split("\\|")[1];
			
			ArrayList<String> allActors = new ArrayList<String>(this.listings.get(firstMovie));
			allActors.addAll(this.listings.get(secondMovie));
			
			System.out.println(allActors);
		}
		else if (moviesInput.contains("^")){
			String firstMovie = moviesInput.split("\\^")[0];
			String secondMovie = moviesInput.split("\\^")[1];
			
			ArrayList<String> differentActors1 = new ArrayList<String>(this.listings.get(firstMovie));
			differentActors1.removeAll(this.listings.get(secondMovie));
			
			ArrayList<String> differentActors2 = new ArrayList<String>(this.listings.get(secondMovie));
			differentActors2.removeAll(this.listings.get(firstMovie));
			
			System.out.println(firstMovie+differentActors1);
			System.out.println(secondMovie+differentActors2);
		}
		else{
			    throw new IllegalArgumentException("String " + moviesInput + " is not separated");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		MovieTheater cinemex = new MovieTheater("C:\\Users\\Arturo\\git\\JavaPrograms\\src\\movies.txt");
		
		cinemex.fileToMap();
		cinemex.coActors("Brad Pitt");
	}
}