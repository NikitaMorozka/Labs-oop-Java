package lab4;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class MyPanel extends JPanel {
	private int z;
	
    public void setZ(int z) {
        this.z = z;
    }
    
	private void drawSquare(Graphics g, int x, int y, int size ) {
		g.drawRect(x - size, y - size, 2* size, 2* size);
	}
	
	private void recureSquare(Graphics g, int x, int y, int size, int depth) {
		if(depth<=0)
		return; 
		drawSquare(g,x,y,size);
		recureSquare(g,x-size,y-size, size/2, depth-1); 
		recureSquare(g,x+size,y+size, size/2, depth-1); 
		recureSquare(g,x-size,y+size, size/2, depth-1); 
		recureSquare(g,x+size,y-size, size/2, depth-1); 
	}
	
	private void house (Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(200, 200, 200, 150);
		g.drawLine(150, 200, 300, 100);
		g.drawLine(450, 200, 300, 100);
		g.drawLine(150, 200, 450, 200);
		g.drawLine(350, 100, 350, 132);
		g.drawLine(350, 100, 370, 100);
		g.drawLine(370, 100, 370, 146);
	}
	
	private void rec1 (Graphics g, int x1, int y1, int x2, int y2 ) {
		while (y2 < 600) {
			g.drawLine(x1, y1, x2, y2);
			y2 = y2 + 10;
			y1 = y1 - 5;
		}
	}
	
    @Override
	public void paint(Graphics g) {
		super.paint(g);
		if (z == 1) {
		g.setColor(Color.RED);
		
		g.drawOval(10, 10, 100, 100);
		}
		if(z == 2 ) {
			drawSquare(g, 200,200,80);
		}
		if(z == 3) {
			recureSquare(g, 200,200,80, 5);
		}	
		if (z == 4 ){
			house(g);
		}
		if(z==5) {
			rec1 (g, 10, 50, 200, 100);
		}
	}
}
