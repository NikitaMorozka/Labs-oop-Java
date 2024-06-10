import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
	
	public class MyPanel extends JPanel {
		
		public Game game = new Game();
		private int lvl = 1;
		private	int status;
		private boolean flag = false;
		
		public void keyAction(KeyEvent e) {
			status = game.move(e);
			if (status == 3) {
				winAction();
			}
			else {
				repaint();
			}
			repaint();

		}
		public void winAction() {
			lvl++;
			if(game.nextLvl(lvl)) {
				flag = true;
			}
			repaint();
		}
		
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			game.draw(g);
			
			if(game.getlvl() == 1) {
				g.setColor(new Color(0,0,0));
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.drawString("Level 1 ",400, 25);
			}
			if(game.getlvl() == 2) {
				g.setColor(new Color(0,0,0));
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.drawString("Level 2 ",400, 25);
			}
			
			if (flag) {
				super.paint(g);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
				g.drawString("Победа !",350, 300);
			}		
		}

		
	}
