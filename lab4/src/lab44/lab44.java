package lab44;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lab44 extends JPanel {
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
	
	private void apple (Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(10, 10, 10, 40); 
		g.fillRect(20, 20, 10, 40); 
		g.fillRect(30, 20, 10, 40); 
		g.fillRect(40, 20, 10, 40); 
		g.fillRect(50, 40, 10, 20); 
		g.fillRect(60, 50, 10, 10); 
        g.setColor(new Color(128, 64, 48)); 
		g.fillRect(70, 50, 10, 30); 
		g.fillRect(80, 30, 10, 40); 
        g.setColor(new Color(255,0, 0)); 
		g.fillRect(80, 60, 20, 10); 
		g.fillRect(90, 50, 30, 10); 
		g.fillRect(120, 60, 20, 10); 
		g.fillRect(140, 70, 10, 50); 
		g.fillRect(130, 120, 10, 20); 
		g.fillRect(120, 140, 10, 10); 
		g.fillRect(80, 150, 40, 10); 
		g.fillRect(70, 140, 10, 10);
		g.fillRect(30, 150, 40, 10); 
		g.fillRect(20, 140, 10, 10); 
		g.fillRect(10, 120, 10, 20); 
		g.fillRect(0, 70, 10, 50); 
		g.fillRect(10, 60, 20, 10); 
		g.fillRect(30, 50, 20, 10); 
		g.fillRect(40, 60, 30, 10); 
		g.setColor(new Color(92, 64, 51)); 
		g.fillRect(80, 120, 10, 10); 
		g.fillRect(90, 90, 10, 30); 
		g.fillRect(80, 90, 20, 10); 
		g.fillRect(60, 120, 10, 10); 
		g.fillRect(50, 90, 10, 30); 
		g.fillRect(60, 90, 10, 10);
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
		if (z == 0) {
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
		if(z==7) {
			apple(g);
		}
	}
}