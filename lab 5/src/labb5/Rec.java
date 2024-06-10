package labb5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rec {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rec window = new Rec();
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
	public Rec() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setTitle("Лабораторная работа 5");
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PaintPanel panel = new PaintPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
		panel.setBounds(6, 6, 586, 441);
		frame.getContentPane().add(panel);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				panel.setFigureDepth((int)spinner.getValue());
			}
		});
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		spinner.setBounds(595, 114, 134, 65);
		frame.getContentPane().add(spinner);
		
		
		JLabel lblNewLabel = new JLabel("Глубина рекурсии ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(595, 36, 135, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("star 4 in 5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panel.setFigureType(1);
			}
		});
		btnNewButton.setBounds(605, 190, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("star 5 in 4 ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setFigureType(0);

			}
		});
		btnNewButton_1.setBounds(605, 230, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Квадрат");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setFigureType(2);

			}
		});
		btnNewButton_2.setBounds(605, 270, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Круг");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setFigureType(3);

			}
		});
		btnNewButton_3.setBounds(605, 310, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		
	
	}
}
