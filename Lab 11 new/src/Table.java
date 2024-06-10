import java.awt.Color;
import java.util.Collections;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Vector;

class Node {
    String[] data;
    Node prev;
    Node next;

    Node(String[] data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Table {
    private static JTextField textField;
    private static JTextField textField_1;
    private static JTextField textField_2;
    private static JTextField textField_3;
    private static JTable table;
    private static DefaultTableModel model;
    private static Node head; // Голова списка
        private static LinkedList<String[]> dataList; // И

    public static void main(String[] args) {
        JFrame frame = new JFrame("WINDOW");
        frame.setTitle("Лабораторная работа 11");
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
                addNode(row);
                model.addRow(row);
            }
        });

        JButton btnDelete = new JButton("Удалить");
        btnDelete.setBounds(494, 15, 120, 32);
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    deleteNode(selectedRow);
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Delete Error");
                }
            }
        });

        JButton searchButton = new JButton("Поиск");
        searchButton.setBounds(364, 15, 120, 33);
        frame.getContentPane().add(searchButton);
        
        JTextField searchField = new JTextField();
        searchField.setBounds(10, 15, 344, 33);
        frame.getContentPane().add(searchField);
        
        JButton btnSortAlphabetically = new JButton("По Алфавиту");
        btnSortAlphabetically.setBounds(442, 462, 170, 27);
        frame.getContentPane().add(btnSortAlphabetically);
        btnSortAlphabetically.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortAlphabetically();
            }
        });
        
        JButton btnSortByLastName = new JButton("С начал/С конца");
        btnSortByLastName.setBounds(442, 500, 170, 27);
        frame.getContentPane().add(btnSortByLastName);
        btnSortByLastName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortByLastName();
            }
        });

        frame.setVisible(true);
    }

    private static void addNode(String[] data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    private static void deleteNode(int index) {
        if (head == null)
            return;

        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null)
                return;
            current = current.next;
        }

        if (current.prev != null)
            current.prev.next = current.next;
        if (current.next != null)
            current.next.prev = current.prev;
        if (current == head)
            head = current.next;
    }
    
    private static void sortAlphabetically() {
        Comparator<String[]> comparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        };
        Collections.sort(dataList, comparator);
        refreshTable();
    }

    private static void sortByLastName() {
        Comparator<String[]> comparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        };
        Collections.sort(dataList, comparator);
        refreshTable();
    }

    private static void refreshTable() {
        model.setRowCount(0);
        for (String[] row : dataList) {
            model.addRow(row);
        }
    }

}
