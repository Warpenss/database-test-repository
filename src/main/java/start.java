import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;

import java.sql.*;

public class start {
    //Creating
    private static Object[][] databaseInfo = null;

    private static Object[] columns = {"Login", "Email", "Password", "Phone Number", "First Name", "Last Name", "Street", "City", "Day of Birth", "Sex", "AccountID"};


    private static DefaultTableModel defaultTableModel = new DefaultTableModel(databaseInfo, columns){
        public Class getColumnClass(int column){
            Class returnValue;
            if((column >= 0) && (column < getColumnCount())){
                returnValue = getValueAt(0, column).getClass();
            }
            else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    public static void main(String[] arg) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Connection conn;

        ResultSet rows;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ttipopu");

            Statement sqlState = conn.createStatement();

            String selectStuff = "SELECT * FROM accounts";

            rows = sqlState.executeQuery(selectStuff);

            Object[] tempRow;

            while (rows.next()) {
                tempRow = new Object[]{rows.getString(1), rows.getString(2), rows.getString(3), rows.getString(4), rows.getString(5), rows.getString(6), rows.getString(7), rows.getString(8), rows.getDate(9), rows.getString(10), rows.getInt(11)};
                defaultTableModel.addRow(tempRow);
            }
        }

        catch (SQLException sqlEx){
            System.out.printf(sqlEx.getMessage());
        }
        catch (ClassNotFoundException cnfEx){
            System.out.println(cnfEx.getMessage());
        }

        JTable table = new JTable(defaultTableModel);

        table.setRowHeight(table.getRowHeight() + 10);

        table.setFont(new Font("PT Sans", Font.PLAIN, 20));

        table.setAutoCreateRowSorter(true);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.LINE_START);

        JTextField textField = new JTextField("Heeeelo");
        frame.add(textField, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

    }
}

class CenterTableCellRenderer extends DefaultTableCellRenderer{
    CenterTableCellRenderer(){
        setHorizontalAlignment(JLabel.CENTER);
    }
}