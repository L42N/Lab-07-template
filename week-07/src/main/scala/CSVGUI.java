import scala.collection.immutable.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CSVGUI {
    private JPanel mainPanel;

    private JTable BookTable;
    private JScrollPane scrollPane;
    private JButton loadButton;

    private JTextField pathEntryField;
    private JTextField searchField;
    private JButton searchButton;
    private JButton sortButton;
    private JButton addNewEntryButton;
    private JRadioButton bookRadioButton;
    private JRadioButton authorRadioButton;
    private JRadioButton publisherRadioButton;
    private JButton editButton;
    private JComboBox comboBox1;

    public CSVGUI() {

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                var result = csv_persistence.getLecturers(pathEntryField.getText());
                List<Book> BookList =
                        csv_persistence.getBooks(pathEntryField.getText());
                System.out.println(BookList);
                for (int i = BookList.length() - 1; i >= 0; i--) {
                    Object[] par = new Object[] {
                            BookList.apply(i).id(),
                            BookList.apply(i).booktitle(),
                            BookList.apply(i).author(),
                            BookList.apply(i).year(),
                            BookList.apply(i).publish(),
                            BookList.apply(i).genre()

                    };
                    ((DefaultTableModel) BookTable.getModel()).addRow(par);
                }
            }
        });
    }


    private void createUIComponents() {
        Object[] cols = {"ID", "Title", "Author" ,"Year", "Publisher", "Subject", };
        BookTable = new JTable(new DefaultTableModel(cols, 0));
        scrollPane = new JScrollPane(BookTable);

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("DDBBGUI");
        frame.setContentPane(new CSVGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }




}
