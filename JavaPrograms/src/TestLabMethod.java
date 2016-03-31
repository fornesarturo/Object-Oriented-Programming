import javax.swing.JOptionPane;

public class TestLabMethod {
	
	public void inputOutput(){
		String numero1;
		String numero2;
		int intNumero1;
		int intNumero2;
		int suma;
		
		numero1 = JOptionPane.showInputDialog("Numero 1");
		numero2 = JOptionPane.showInputDialog("Numero 2");
		
		intNumero1 = Integer.parseInt(numero1);
		intNumero2 = Integer.parseInt(numero2);
		
		suma = intNumero1 - intNumero2;
			
		JOptionPane.showMessageDialog(
				null,"La suma es"+ suma,"Resultado, ",JOptionPane.PLAIN_MESSAGE);
	}
}