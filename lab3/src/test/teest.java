package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class teest {

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
					teest window = new teest();
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
	public teest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setTitle("Лабораторная работа 3");
		frame.setBounds(100, 100, 865, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 6, 728, 551);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, BorderLayout.CENTER);
		textArea.setTabSize(4);
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		spinner.setBounds(756, 117, 84, 49);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("Размер фигуры ");
		lblNewLabel.setForeground(new Color(254, 255, 255));
		lblNewLabel.setBounds(746, 78, 114, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		spinner_1.setForeground(new Color(81, 255, 90));
		spinner_1.setBackground(new Color(81, 255, 90));
		spinner_1.setBounds(756, 232, 84, 49);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_1 = new JLabel("Номер фигуры");
		lblNewLabel_1.setForeground(new Color(254, 255, 255));
		lblNewLabel_1.setBounds(746, 194, 94, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Изобразить");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //хочу сделать в отдельном файле 
				int z = (int)spinner_1.getValue();
				if (z>8) {
					textArea.setText("Ошибка");

				}
				else {
				if (z==1){
				int n = (int)spinner.getValue();
				String s = ""; 
				int j = 0; 
				int i = 1; 
				int num = 1;
				do {
				j=1;
				num=1;
				num*=i;
				do {
					s+=num+"\t"; 
					num = num+2; 
					j++;
				}while(j <= n);
				s +="\n";
				 i++;
			}while (i <= n ); 
				textArea.setText(s);
				
				
			}
				if (z==2){
					int n = (int)spinner.getValue();
					String s = ""; 
					int j; 
					int i = 1; 
					do {
						j = 1; 
				
						do {
							s+=j+"  "; 

							j++; 
							
						}while(j <= i);
						
						s +="\n";
						i++;
						
					}while(i <= n);
					textArea.setText(s);
				}
				
				if (z==3){
					int n = (int)spinner.getValue();
					String s = ""; 
					
					int j;
					int i = 1; 
					
					do {
					j = 1; 
					
					do {
						s+=j+"  ";
						j++;
					}while(j <= n);
					s+="\n";
					 i++;
					 n=n-1;
				}while (1 <= n ); 
					textArea.setText(s);
				}
				
				if (z==4){
					int n = (int)spinner.getValue();
					String s = ""; 
					int j=0;
					int i = 1; 
					int k = n; 
					do {
					j++; 

					do {
						s+=n+"  ";
						n--;
					}while(j <= n);
					s+="\n";
					n = k;
					i++;
					 
				}while (i <= n); 	
					textArea.setText(s);
				}
				
				if (z==5){
					int n = (int)spinner.getValue();
					String s = ""; 
					int i = 1; 
					int j = 1; 
					int M = n;
					int Q = n;
					do {
						j = 1; 	
						do {
							s+=M+"\t"; //исправить 
							M = M+n;
							j++;
							
						}while(j<=Q);
						s+="\n";
						n--; 
						M=n;
						i++;
					}while(i<=Q); 
					textArea.setText(s);
				}
				if (z==6){
					int N = (int)spinner.getValue();
					String s = ""; 
					int i = 1; 
					int j = 1; 
					int w = 1; 
					
					int R = 0; 
					int y = 1;
					int n = 1; 
			
					do {	
						if (i<=n){
						j=1;
						w=1; 
						do {
							R = R+y;  
							j++; 							
							s+=R+"\t";//исправить
						}while(j<=N);
						i++;
						}
						s+="\n";						
						n++; 
						y++;
						R = n * N; 
					if (i<=N){
						do {
							s+=R+"\t";
							R = R-y;  
							w++;
						}while(w<=N);
						i++;
					}
					s+="\n";						
						n++;
						y++; 
					}while(i<=N); 
					
					textArea.setText(s);
				}
				
				if (z==7){
					int N = (int)spinner.getValue();
					if (N>100) {
						textArea.setText("Ошибка"); 
					}
					else {
					String s = ""; 
					int j = 1; 
			        int i = 1;
			        int K = 2; 
			        int M = N;
			  
			        do {     
			        
			        	j=1;
			            do {
			                if (j >= M){
			                    s+=" "+j; 
			                } else {
			                    s+="  "; 
			                }
			                j++;
			            } while (j <= N);
			            M--;
			            s+="\n"; 
			            i++;   
			        } while (i <= N);  
			        	
			        	i = 1;
			        	M = N; 
			        	j=1; 
			        do {     
			        	j=1;
			            do {
			                if (j >= K){
			                    s+=" "+j; 
			                } else {
			                    s +="  ";
			                }
			                j++;
			            } while (j <= N);
			            s += "\n"; 
			            i++;   
			        	K++;
			        } while (i <= N);   
					textArea.setText(s);
					}
					}
					
				if (z==8){
					int N = (int)spinner.getValue();
					
					if (N>10) {
						textArea.setText("Ошибка"); 
					}
					
					else {
					String s = ""; 
					int j = 1; 
			        int i = 1;
			        int K = 2; 
			        int M = N;
			  
			        do {     
			        
			        	j=1;
			            do {
			                if (j >= M){
			                    s+=j+ " "; 
			                } else {
			                    s+=" "; 
			                }
			                j++;
			            } while (j <= N);
			            M--;
			            s+="\n"; 
			            i++;   
			        } while (i <= N);  
			        	
			        	i = 1;
			        	M = N; 
			        	j=1; 
			        do {     
			        	j=1;
			            do {
			                if (j >= K){
			                    s+=j+" "; 
			                } else {
			                    s += " ";
			                }
			                j++;
			            } while (j <= N);
			            s += "\n"; 
			            i++;   
			        	K++;
			        } while (i <= N);   
					textArea.setText(s);
					}
					}
			}
			}
		});
		
		btnNewButton.setBounds(746, 337, 117, 29);
		frame.getContentPane().add(btnNewButton);
		

		


	}
}

