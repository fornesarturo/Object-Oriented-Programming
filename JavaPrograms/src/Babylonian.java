
public class Babylonian {

	public static void main (String[] args){
		SuNumber heron = new SuNumber(64);
		SuNumber notHeron = new SuNumber(5);
		
		System.out.println(heron.babylonianMethod());
		System.out.println(notHeron.babylonianMethod());
	}
}