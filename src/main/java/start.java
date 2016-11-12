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

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root", "ttipopu");

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

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(100);

        TableColumn col2 = table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(200);

        TableColumn col3 = table.getColumnModel().getColumn(2);
        col3.setPreferredWidth(150);

        TableColumn col4 = table.getColumnModel().getColumn(3);
        col4.setPreferredWidth(150);

        TableColumn col5 = table.getColumnModel().getColumn(4);
        col5.setPreferredWidth(100);

        TableColumn col6 = table.getColumnModel().getColumn(5);
        col6.setPreferredWidth(100);

        TableColumn col7 = table.getColumnModel().getColumn(6);
        col7.setPreferredWidth(100);

        TableColumn col8 = table.getColumnModel().getColumn(7);
        col8.setPreferredWidth(100);

        TableColumn col9 = table.getColumnModel().getColumn(8);
        col9.setPreferredWidth(100);

        TableColumn col10 = table.getColumnModel().getColumn(9);
        col10.setPreferredWidth(50);

        TableColumn col11 = table.getColumnModel().getColumn(10);
        col11.setPreferredWidth(100);

        TableColumn tc = table.getColumn("Sex");
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        tc = table.getColumn("AccountID");
        centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(1270,900);
        frame.setVisible(true);
    }
}

class CenterTableCellRenderer extends DefaultTableCellRenderer{
    CenterTableCellRenderer(){
        setHorizontalAlignment(JLabel.CENTER);
    }
}