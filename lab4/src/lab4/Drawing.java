package lab4;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Drawing {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing window = new Drawing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drawing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Лабораторная работа 4");
		frame.setBounds(100, 100, 846, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		MyPanel panel = new MyPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(6, 6, 648, 469);
		frame.getContentPane().add(panel);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		spinner.setBounds(710, 59, 76, 26);
		frame.getContentPane().add(spinner);

		JButton btnNewButton = new JButton("Применить ");
		btnNewButton.addActionListener(new ActionListener() {


		public void actionPerformed(ActionEvent e) {
			int z = (int) spinner.getValue();
			 panel.setZ(z);
			 panel.repaint();
			}
		});
		
		
		btnNewButton.setBounds(690, 97, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Выберите элемент ");
		lblNewLabel.setBounds(687, 31, 120, 16);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
