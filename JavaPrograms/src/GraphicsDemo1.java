import java.awt.*;
import javax.swing.JFrame;

public class GraphicsDemo1 extends Canvas {
	public void paint(Graphics g){
		//Rectangle and Oval
		g.setColor(Color.blue);
		g.drawRect(10, 50, 100, 200);
		g.setColor(Color.yellow);
		g.fillOval(70, 120, 30, 30);
		
		//Hex color and Rounded Rectangle
		g.setColor(Color.decode("#000000"));
		g.fillRoundRect(200, 150, 60, 20, 3, 5);
		
		//On screen text
		g.setColor(Color.black);
		g.drawString("Hello, world!", 200, 190);
	}
	
	public static void main(String[] args){
		JFrame window = new JFrame("Just your average JFrame");
		window.setSize(400,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDemo1 canvas = new GraphicsDemo1();
		window.add(canvas);
		window.setVisible(true);
	}
}
