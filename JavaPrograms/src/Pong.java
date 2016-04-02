import java.awt.*;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.util.Timer;

@SuppressWarnings("serial")
public class Pong extends Canvas
{
	Point delta;
	Ellipse2D.Double ball;
	Rectangle paddle1;
	Rectangle paddle2;
	int score1 = 0;
	int score2 = 0;
	
	Font splash = new Font("Times", Font.BOLD, 60);
	
	public static void main( String[] args )
	{
		JFrame win = new JFrame("Pong");
		win.setSize(1010,735);
		win.getContentPane().setBackground( Color.BLACK );
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		win.add( new Pong() );
		win.setVisible(true);
	}

	public Pong()
	{
		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
		requestFocus();
		
		ball = new Ellipse2D.Double(500,350,20,20);
		delta = new Point(-5,5);
		paddle1 = new Rectangle(50, 250, 20, 200);
		paddle2 = new Rectangle(940, 250, 20, 200);
		
		Timer t = new Timer(true);
		t.schedule( new java.util.TimerTask(){
			public void run()
			{
				doStuff();
				repaint();
			}
		}, 10, 10);
	}

	public void paint( Graphics g )
	{
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fill(ball);
		
		g2.setColor(Color.white);
		g2.fill(paddle1);
		g2.fill(paddle2);
		
		g.setFont(splash);
		g.drawString("-", 510, 100);
		g.drawString(Integer.toString(score1), 350, 100);
		g.drawString(Integer.toString(score2), 640, 100);
	}

	public void processKeyEvent(KeyEvent e)
	{
		if ( e.getID() == KeyEvent.KEY_PRESSED )
		{
			if ( e.getKeyCode() == KeyEvent.VK_W )
			{
				paddle1.y -= 15; 
			}
			if ( e.getKeyCode() == KeyEvent.VK_S )
			{
				paddle1.y += 15;
			}
			if ( e.getKeyCode() == KeyEvent.VK_UP )
			{
				paddle2.y -= 15; 
			}
			if ( e.getKeyCode() == KeyEvent.VK_DOWN )
			{
				paddle2.y += 15;
			}
			if ( e.getKeyCode() == KeyEvent.VK_R )
			{
				score1 = 0;
				score2 = 0;
			}
		}
	}
	
	public void doStuff()
	{
		ball.x += delta.x;
		ball.y += delta.y;

		// hit a wall
		if ( ball.y < 0 || ball.y+20 > 700 )
			delta.y = -delta.y;
		if ( ball.x < 0 )
			delta.x = -delta.x;
			
		// hitting the paddle
		if ( ball.intersects(paddle1) ){
			
			delta.x = -delta.x;
		}
		else if (ball.intersects(paddle2) ){
			
			delta.x = -delta.x;
		}
			
		// Score
		if ( ball.x > 1000 ){
			score1++;
			ball.x = 500;
			ball.y = 350;
			delta = new Point(-5,5);
		}
		else if ( ball.x < 10){
			score2++;
			ball.x = 500;
			ball.y = 350;
			delta = new Point(-5,5);
		}
	}
	
	public boolean isFocusable() { return true;	}
}
