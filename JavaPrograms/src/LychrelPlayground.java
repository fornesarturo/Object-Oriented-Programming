import java.util.Scanner;

public class LychrelPlayground {
	private static Scanner scan;
	
	public static void main(String[] args){
		scan = new Scanner(System.in);
		
		System.out.println("Enter lower bound: ");
		int lowerBound = scan.nextInt();
		
		System.out.println("Enter upper bound: ");
		int upperBound = scan.nextInt();
		
		Lychrel yourRange = new Lychrel(lowerBound,upperBound);
		
		yourRange.lychrelment();
		
	}

}
