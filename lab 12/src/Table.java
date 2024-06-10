import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Table {
    private static JTextField textField;
    private static JTextField textField_1;
    private static JTextField textField_2;
    private static JTextField textField_3;
    private static JTable table;
    private static DefaultTableModel model;
    private static LinkedList<String[]> dataList; // Используем LinkedList для хранения данных

    public static void main(String[] args) {
        JFrame frame = new JFrame("WINDOW");
        frame.setTitle("Лабораторная работа 12");
        frame.getContentPane().setBackground(new Color(106, 90, 205));
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 644, 584);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        Object[] columns = {"Имя", "Фамилия", "Должность", "Номер телефона"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(10, 58, 604, 355);
        frame.getContentPane().add(pane);

        textField = new JTextField();
        textField.setBounds(141, 424, 291, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(141, 455, 291, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(141, 486, 291, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(141, 517, 291, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel = new JLabel("Имя");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 424, 37, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Номер телефона ");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 511, 118, 27);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Фамилия");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(10, 452, 70, 20);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_1_1 = new JLabel("Место работы ");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 483, 118, 20);
        frame.getContentPane().add(lblNewLabel_1_1);

        JButton btnAdd = new JButton("Добавить");
        btnAdd.setBounds(442, 424, 170, 27);
        frame.getContentPane().add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] row = {textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText()};
                dataList.add(row);
                model.addRow(row);
            }
        });

        JButton btnDelete = new JButton("Удалить");
        btnDelete.setBounds(494, 15, 120, 32);
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lastNameToRemove = textField_1.getText();
                ListIterator<String[]> iterator = dataList.listIterator();
                while (iterator.hasNext()) {
                    String[] row = iterator.next();
                    if (row[1].equals(lastNameToRemove)) {
                        iterator.remove();
                        model.removeRow(iterator.nextIndex());
                        break;
                    }
                }
            }
        });

        JButton searchButton = new JButton("Поиск");
        searchButton.setBounds(364, 15, 120, 33);
        frame.getContentPane().add(searchButton);
        JTextField searchField = new JTextField();
        searchField.setBounds(10, 15, 344, 33);
        frame.getContentPane().add(searchField);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lastNameToSearch = searchField.getText();
                searchByLastName(lastNameToSearch);
            }
        });
        
        JButton btnSortAlphabetically = new JButton("По Алфавиту");
        btnSortAlphabetically.setBounds(444, 462, 170, 27);
        frame.getContentPane().add(btnSortAlphabetically);
        btnSortAlphabetically.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(dataList, new Comparator<String[]>() {
                    public int compare(String[] O1, String[] O2) {
                        return O1[0].compareTo(O2[0]);    // Сравниваем по фамилии, индекс 1 в массиве
                    }
                });
                refreshTable();
            }
        });
        
        JButton btnSortByLastName = new JButton("С начал/С конца");
        btnSortByLastName.setBounds(444, 507, 170, 27);
        frame.getContentPane().add(btnSortByLastName);
        btnSortByLastName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(dataList, new Comparator<String[]>() {
                    public int compare(String[] O1, String[] O2) {
                        return O1[1].compareTo(O2[0]);    // Сравниваем по фамилии, индекс 1 в массиве
                    }
                });
                refreshTable();
            }
        });

        frame.setVisible(true);
        dataList = new LinkedList<>(); // Инициализация списка данных
    }

    private static void searchByLastName(String lastName) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        if (lastName.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + lastName, 0));
        }
    }
    
    private static void refreshTable() {
        model.setRowCount(0);
        for (String[] row : dataList) {
            model.addRow(row);
        }
    }
}
