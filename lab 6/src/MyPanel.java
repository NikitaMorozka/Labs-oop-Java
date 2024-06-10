import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private Massiv A = new Massiv(); 
	
	public void paint(Graphics g ) {
		super.paint(g);
		A.draw(g);
		}
}
