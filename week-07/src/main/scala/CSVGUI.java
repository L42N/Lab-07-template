import scala.collection.immutable.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CSVGUI {
    private JPanel mainPanel;
    private JTable lecturerTable;
    private JScrollPane scrollPane;
    private JButton loadButton;

    private JTextField pathEntryField;

    public CSVGUI() {

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                var result = csv_persistence.getLecturers(pathEntryField.getText());
                List<Lecturer> lecturerList =
                        csv_persistence.getLecturers(pathEntryField.getText());
                System.out.println(lecturerList);
                for (int i = lecturerList.length() - 1; i >= 0; i--) {
                    Object[] par = new Object[] {
                            lecturerList.apply(i).id(),
                            lecturerList.apply(i).name(),
                            lecturerList.apply(i).age(),
                            lecturerList.apply(i).module(),
                            lecturerList.apply(i).status(),
                            lecturerList.apply(i).wage(),
                            lecturerList.apply(i).gender()
                    };
                    ((DefaultTableModel) lecturerTable.getModel()).addRow(par);
                }
            }
        });
    }


    private void createUIComponents() {
        Object[] cols = {"id", "name", "age", "module", "status", "wage", "gender"};
        lecturerTable = new JTable(new DefaultTableModel(cols, 0));
        scrollPane = new JScrollPane(lecturerTable);

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
