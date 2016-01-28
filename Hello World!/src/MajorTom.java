class MajorTom extends Singer{
	String listener;
	public MajorTom(String who){
		listener = who;
	}
	
	public void establishConnection(){
		System.out.println(this.listener + " to Major Tom");
	}
	
	public static void main(String[] args){
		MajorTom theOne = new MajorTom("Ground Control");
		theOne.establishConnection();
		theOne.sing();
	}
}