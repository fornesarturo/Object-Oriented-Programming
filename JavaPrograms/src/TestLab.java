import java.util.Scanner;

public class TestLab {
	private static Scanner scan;
	
	
	public static void main(String[] args){
		scan = new Scanner(System.in);
		for(int i = 0; i <= 10; i++){
			System.out.println(i);
		}
		String ans = "yes";
		while(ans.equals("yes")){
			System.out.println(ans);
			ans = scan.nextLine();
			System.out.println(ans);
			
		}
	}
}
