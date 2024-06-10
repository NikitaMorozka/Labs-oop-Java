
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class lab11 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab11 window = new lab11();
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
	public lab11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyList list = new MyList();
		MyDblList dbllist = new MyDblList();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setTitle("Лабораторная работа №11");
		frame.setBounds(100, 100, 770, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 562, 452);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 13));
		panel.add(textArea, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.PLAIN, 13));
		textField.setBounds(582, 11, 162, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Добавить");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.add(textField.getText());
				textArea.setText(list.toString());
			}
		});
		btnNewButton.setBounds(582, 55, 94, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Очистить");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.clear();
				textArea.setText(list.toString());
			}
		});
		btnNewButton_1.setBounds(582, 89, 162, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Поиск");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.search(textField.getText()))
					textArea.setText(list.toString() + "\n" + "Строка найдена");
				else
					textArea.setText(list.toString() + "\n" + "Строка  НЕ найдена");
			}
		});
		btnNewButton_2.setBounds(675, 55, 69, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Удалить");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.delete(textField.getText())) {
					textArea.setText(list.toString() + "\n" + "Удалить удалось");
				}
				else
					textArea.setText(list.toString() + "\n" + "Удалить НЕ удалось");
				
			}
		});
		btnNewButton_3.setBounds(582, 123, 162, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(582, 244, 162, 33);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_4 = new JButton("Добавить в голову");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbllist.addToHead(textField_1.getText());
				textArea.setText(dbllist.toString());
			}
		});
		btnNewButton_4.setBounds(582, 288, 162, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_2_1 = new JButton("Поиск");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dbllist.search(textField_1.getText()))
					textArea.setText(dbllist.toString() + "\n" + "Строка найдена");
				else
					textArea.setText(dbllist.toString() + "\n" + "Строка  НЕ найдена");
			}
		});
		btnNewButton_2_1.setBounds(582, 357, 162, 23);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Очистить");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbllist.clear();
				textArea.setText(dbllist.toString());
			}
		});
		btnNewButton_1_1.setBounds(582, 391, 162, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_3_1 = new JButton("Удалить");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dbllist.deleteElem(textField_1.getText())) {
					textArea.setText(dbllist.toString() + "\n" + "Удалить удалось");
				}
				else
					textArea.setText(dbllist.toString() + "\n" + "Удалить НЕ удалось");
				
			}
		});
		btnNewButton_3_1.setBounds(582, 425, 162, 23);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("Добавить в хвост");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbllist.addToTail(textField_1.getText());
				textArea.setText(dbllist.toString());
			}
		});
		btnNewButton_4_1.setBounds(582, 322, 162, 23);
		frame.getContentPane().add(btnNewButton_4_1);
	}
}
