public class SuNumber{
	private int value;
	
	public SuNumber(int num){
		this.value = num;
	}
	
	public int valor(){
		return this.value;
	}
	
	public void yeOlEuclidSelector(SuNumber a){
		if (a.valor() == 0){
			System.out.println(this.value);
		}
		else{
			switch(this.value % a.valor()){
			case 0: System.out.println(a.valor());
					break;
			default: if (this.value > a.valor()){
				System.out.println(euclids(this.value, a.valor()));
				}
					 else{
				System.out.println(euclids(a.valor(), this.value));
			}	
			break;
			}
		}
	}
	
	private int euclids(int a, int b){
		switch(a % b){
		case 0: return b;
		default: int remainder = a%b;
				return euclids(b, remainder);
		}
	}
	
	public float babylonianMethod(){
		float guess, limitGuess, divided;
		
		if (this.value == 0){
			return (float) 0.0;
		}
		
		guess = this.value / (float)2.0;
		limitGuess = guess + 1;
		while (guess != limitGuess){
			divided = this.value / guess;
			limitGuess = guess;
			guess = (guess + divided) / 2;
		}
		return guess;
	}
	
	
	
	
	
}