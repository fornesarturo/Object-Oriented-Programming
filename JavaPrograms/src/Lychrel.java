public class Lychrel{
	private int first;
	private int last;
	private int iterations;
	private int nayLychrel;
	private int yayLychrel;
	private int naturalPalindromes;
	private int original;
	
	
	public Lychrel(int start, int end){
		this.first = start;
		this.last = end;
		this.iterations = 0;
		this.nayLychrel = 0;
		this.yayLychrel = 0;
		this.naturalPalindromes = 0;
		this.original = 0;
	}
	
	private void lychrelNum(int numberInput){
		int number = numberInput;
		int savedRev = reverseNum(number);
		
		if (number == savedRev){
			System.out.println(this.original + " refused being a Lychrel number after " 
					+ this.iterations + " iterations");
			if (this.iterations == 0){
				this.naturalPalindromes += 1;
			}
			this.iterations = 0;
			this.nayLychrel += 1;
		}
		else if(this.iterations == 30){
			System.out.println("YO SOY 196! ay no que teto suena eso, Ken. "
					+ "Your number " + this.original + " has resisted Lychrelmindoctrination "
					+ "after 30 iterations, it is thus a Lychrel number");
			this.iterations = 0;
			this.yayLychrel += 1;
		}
		else{
			number = number + savedRev;
			this.iterations += 1;
			this.lychrelNum(number);
		}
	}
	
	public void lychrelment(){
		for(int i = this.first; i <= this.last; i+= 1){
			this.original = i;
			this.lychrelNum(i);
		}
		
		System.out.println("The range was from " + this.first + " to " + this.last + ". The"
				+ " number of natural palindromes was " + this.naturalPalindromes + ". The"
				+ " number of non-Lychrel numbers was " + this.nayLychrel + ". The"
				+ " number of Lychrel numbers was " + this.yayLychrel + ".");
	}
	
	private int reverseNum(int number){
		int reversedNum = 0;
		int leftOver = number;
		
		while(leftOver != 0){
			reversedNum = reversedNum * 10 + leftOver % 10;
			leftOver = leftOver / 10;
		}
		
		return reversedNum;
	}
}