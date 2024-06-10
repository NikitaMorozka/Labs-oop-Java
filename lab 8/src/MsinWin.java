import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Сохранить как ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(); 
				if(jfc.showSaveDialog(frame)!=	JFileChooser.APPROVE_OPTION) {
					return; 
				}
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(jfc.getSelectedFile().getAbsolutePath()));
					bw.write(textArea.getText()); 
					
					bw.close(); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Правка");
		menuBar.add(mnNewMenu_1);
//		обработать 
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Обработать ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder(textArea.getText()); 
				//String replacedText = sb.toString().replaceAll("AA", "*"); 
			   // String replacedText = sb.toString().replaceAll("(.)\\1", "");
		//	    String replacedText = sb.toString().replaceAll("\\b\\w*A\\w*\\b", "*");
		//	    String replacedText = sb.toString().replaceAll("\\b\\w*A\\w*\\b", "<$0>");

		//	    String replacedText = sb.toString().replaceAll("\\b(?=\\w*([aeiouyAEIOUY]\\w*){2,})\\w+\\b", ""); // Удаляем слова с меньшим числом согласных, чем гласных
			   
				String replacedText = sb.toString().replaceAll("\\b (\\w*(\\w)\\w*\\2\\w*)\\b", "");

				sb.replace(0, sb.length(), replacedText);
				textArea.setText(sb.toString());
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
	}

}
