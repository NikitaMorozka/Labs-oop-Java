import java.awt.EventQueue;
import java.awt.FlowLayout;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

	        JPanel panel = new JPanel();
	       JScrollPane scroll = new JScrollPane(textArea,
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	      panel.setLayout(new FlowLayout());
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        panel.add(scroll);

		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("Файл");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Открыть меню");
		mntmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser jfc = new JFileChooser(); 
		        if(jfc.showOpenDialog(frame) != JFileChooser.APPROVE_OPTION) {
		            return; 
		        }
		        try {
		            // Открываем файл для чтения
		            FileInputStream fis = new FileInputStream(jfc.getSelectedFile());
		            InputStreamReader isr = new InputStreamReader(fis);
		            BufferedReader br = new BufferedReader(isr);
		            
		            StringBuilder res = new StringBuilder(); // Используем StringBuilder для сохранения считанного текста
		            char[] buffer = new char[1024]; // Размер буфера для чтения (1 КБ)
		            int bytesRead;
		            while ((bytesRead = br.read(buffer)) != -1) {
		                res.append(buffer, 0, bytesRead); // Добавляем считанные данные к StringBuilder
		            }
		            br.close();
		            isr.close();
		            fis.close();
		            
		            textArea.setText(res.toString()); // Устанавливаем текст из StringBuilder в JTextArea
		        } catch (IOException e1) {
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
				
				String fileName = jfc.getSelectedFile().getAbsolutePath(); // абсолютный путь выбронного файла
		        if (!fileName.toLowerCase().endsWith(".html")) { //Если выбранный файл не заканчивается на ".html"
		            fileName += ".html";
		        }
		        
				try { // для работы с исключениями 
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
					bw.write("<p align=\"center\"><b>Лабораторная работа №9</b></p><br>"
						      + "<p align=\"center\">Вариант Б </p><br>"
						      + "<p align=\"left\">Выполнил студент группы <i>ИВТИИбд-12</i> <b>Морозов Н.В.</b></p><br>"
						      + "<p align=\"left\">Файл: <b>" + fileName + "</b></p><br>"
						        + "<p align=\"left\">" + textArea.getText() + "</b></p>");
		            
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
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Обработать ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 String text = new String (textArea.getText());

			        String[] words = text.split("\\s+"); // регулярное выражение в виде пробело или нескольких пробелов 
			        
			        // Если в тексте нет слов, выходим
			        if (words.length == 0) {
			            textArea.setText("Количество слов, начинающихся с указанного: 0");
			            return;
			        }
			        
			        // Берем первое введенное слово как искомое
			        String searchTerm = words[0].replaceAll("[^а-яА-Яa-zA-Z]", ""); // удаляет все, кроме кириллицы и латиницы 
			        
			        // Счетчик слов, начинающихся с искомого слова
			        int wordCount = 0;
			        // Проверяем каждое слово на соответствие искомому слову
			        for (String word : words) {
			            if (word.replaceAll("[^а-яА-Яa-zA-Z]", "").startsWith(searchTerm)) {// проверяет начинается ли подстрока с данного индекса,После удаления всех символов, не являющихся буквами, вызов этого метода проверяет, начинается ли получившаяся строка с термина searchTerm. 
			                wordCount++; 
			            }
			        }
			        wordCount = wordCount - 1; 
			        
			        // Выводим результат в JTextArea
			        textArea.setText("Количество слов, начинающихся с \"" + searchTerm + "\": " + wordCount);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
	}

}





















































//JMenuItem mntmNewMenuItem_2 = new JMenuItem("Обработать ");
//mntmNewMenuItem_2.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		StringBuilder sb = new StringBuilder(textArea.getText()); 
//		String replacedText = sb.toString().replaceAll("AA", "*"); 
////	   String replacedText = sb.toString().replaceAll("(.)\\1", "");
////	    String replacedText = sb.toString().replaceAll("\\b\\w*A\\w*\\b", "*");
////	    String replacedText = sb.toString().replaceAll("\\b\\w*A\\w*\\b", "<$0>");
//
////	    String replacedText = sb.toString().replaceAll("\\b(?=\\w*([aeiouyAEIOUY]\\w*){2,})\\w+\\b", ""); // Удаляем слова с меньшим числом согласных, чем гласных
//	   
//	//	String replacedText = sb.toString().replaceAll("\\b (\\w*(\\w)\\w*\\2\\w*)\\b", "");
//
//		sb.replace(0, sb.length(), replacedText);
//		textArea.setText(sb.toString());
//	}
//});
//mnNewMenu_1.add(mntmNewMenuItem_2);