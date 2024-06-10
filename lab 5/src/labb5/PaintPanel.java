package labb5;

	import java.awt.Graphics;
	import javax.swing.JPanel;
	

	public class PaintPanel extends JPanel {
	 private int type; // Название переменной с маленькой буквы в соответствии с конвенцией
	 private int depth; // Глубина рекурсии
	

	public PaintPanel() {
		 type = 0; // Инициализируем значения по умолчанию
	     depth = 0; // Инициализируем значения по умолчанию
	}
	
	public void setFigureDepth(int depth) {
		this.depth = depth; // Устанавливаем значение depth в текущем объекте PaintPanel
	    repaint();
	}
	
	public void setFigureType(int newFigureType) {
	 type = newFigureType;
		repaint();
	}
	
	public int getFigureType() {
		return type;
		}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(type==0) {
			facstar4(g,250,200,100, depth);
			repaint();
		}
		if (type==1) {
			facstar5(g,250,200,100, depth);
			repaint();
		}
		if (type==2) {
			recurFigure1(g,250,200,100, depth);
			repaint();
		}
		if (type==3) {
			recurFigure(g,250,200,100, depth);
			repaint();
		}
	}

    	private void drawStar5(Graphics g, int x, int y, int size) {
    	g.drawLine(x-size, y, x - size / 4, y);
        g.drawLine(x - size / 4, y, x, y - size);
        g.drawLine(x, y - size, x + size / 4, y);
        g.drawLine(x + size / 4, y, x + size, y);
        g.drawLine(x + size, y, x + size / 4, y + size / 4);
        g.drawLine(x + size / 4, y + size / 4, x + size / 2, y + size);
        g.drawLine(x + size / 2, y + size, x, y + size / 2);
        g.drawLine(x, y + size / 2, x - size / 2, y + size);
        g.drawLine(x - size / 2, y + size, x - size / 4, y + size / 4);
        g.drawLine(x - size / 4, y + size / 4, x-size, y);
    	}  
    	
    	private void drawStar4(Graphics g, int x, int y, int size) {
  	  	g.drawLine(x - size, y, x - size / 4, y - size / 4); 
        g.drawLine(x - size / 4, y - size / 4, x, y - size); 
        g.drawLine(x, y - size, x + size / 4, y - size / 4); 
        g.drawLine(x + size / 4, y - size / 4, x + size, y); 
        g.drawLine(x + size, y, x + size / 4, y + size / 4); 
        g.drawLine(x + size / 4, y + size / 4, x, y + size); 
        g.drawLine(x, y + size, x - size / 4, y + size / 4); 
        g.drawLine(x - size / 4, y + size / 4, x - size, y); 
    	}   
    	
        public void drawSquare (Graphics g, int x, int y, int size ) {
            g.drawRect(x - size, y - size, 2 * size, 2 * size);
        }
        
        public void drawOval(Graphics g, int x, int y, int size) {//овал 
    		g.drawOval(x - size, y - size, 2*size, 2*size);
    	}
        
        
	private void facstar5(Graphics g,int x, int y, int size, int depth) {
		drawStar5(g,x,y,size);
			if (depth<=0)
			return; 
		facstar4(g, x - size, y, size / 2, depth - 1); 
		facstar4(g, x + size, y, size / 2, depth - 1); 
		facstar4(g, x, y - size, size / 2, depth - 1); 
		facstar4(g, x - size / 2, y + size, size / 2, depth - 1); 
		facstar4(g, x + size / 2, y + size, size / 2, depth - 1); 
		}

	private void facstar4(Graphics g,int x, int y, int size, int depth) {
		drawStar4(g,x,y,size);
		if (depth<=0)
			return; 
		facstar5(g, x, y - size, size / 2,depth-1);
	    facstar5(g, x - size, y, size / 2,depth-1);
	    facstar5(g, x, y + size, size / 2,depth-1);
	    facstar5(g, x + size, y, size / 2,depth-1);
		}
	
	private void recurFigure1(Graphics g, int x, int y, int size, int depth) {
		drawSquare(g, x, y, size); 
		if (depth<=0)
			return; 
		recurFigure1(g, x - size, y-size, size/2, depth-1);
		recurFigure1(g, x + size, y+size, size/2, depth-1);
		recurFigure1(g, x - size, y+size, size/2, depth-1);
		recurFigure1(g, x + size, y-size, size/2, depth-1);
		}
	
	private void recurFigure(Graphics g, int x, int y, int size, int depth) {
		drawOval(g, x, y, size); 
		if (depth<=0)
			return; 
		recurFigure(g, x - size, y-size, size/2, depth-1);
		recurFigure(g, x + size, y+size, size/2, depth-1);
		recurFigure(g, x - size, y+size, size/2, depth-1);
		recurFigure(g, x + size, y-size, size/2, depth-1);
		}

}
