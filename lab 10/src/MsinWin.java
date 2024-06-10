import java.awt.EventQueue;
import java.util.*; 

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;

public class MsinWin {

	private JFrame frame;

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
					MsinWin window = new MsinWin();
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
	public MsinWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setTabSize(15);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Файл");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Открыть меню");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(); 
				if(jfc.showOpenDialog(frame)!=	JFileChooser.APPROVE_OPTION) {
					return; 
				}
				
				
				try {
				Scanner sc = new Scanner(new File(jfc.getSelectedFile().getAbsolutePath()));
				String res = ""; 
				while(sc.hasNext()) {
					res += sc.nextLine() + "\n"; 
				}
				sc.close(); 
				textArea.setText(res); 
				}catch (FileNotFoundException e1) {
					e1.printStackTrace(); 
				}
				
			
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Сохранить");

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser(); 
				
				if(jfc.showSaveDialog(frame)!=	JFileChooser.APPROVE_OPTION) {
					return; 
				}
				
				String fileName = jfc.getSelectedFile().getAbsolutePath();
		        if (!fileName.toLowerCase().endsWith(".txt")) {
		            fileName += ".txt";
		        }
		        
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
					  bw.write(textArea.getText()); // Записываем содержимое textArea
					bw.close(); 
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		
		
		
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Правка");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Обработать ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String text = textArea.getText();
		        String[] words = text.split("\\s+");
		        List<String> wordList = new ArrayList<>(Arrays.asList(words));
		        
		        for (int i = 0; i < wordList.size() - 1; i++) {
		            for (int j = 0; j < wordList.size() - i - 1; j++) {
		                if (wordList.get(j).compareTo(wordList.get(j + 1)) > 0) {
		                    Collections.swap(wordList, j, j + 1);
		                }
		            }
                    textArea.append("\nПромежуточное состояние после итерации " + (i+1) + ":\n" + String.join(" ", wordList) + "\n");
		        }
		        
		    }
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
	}

}


