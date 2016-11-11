import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ObjectView;
import java.sql.*;

public class start {

    static Object[][] databaseInfo;

    static Object[] columns = {"Login", "Email", "Password", "Phone Number", "First Name", "Last Name", "Street", "City", "Day of Birth", "Sex", "AccountID"}

    static ResultSet rows;

    static ResultSetMetaData metaData;

    static DefaultTableModel defaultTableModel = new DefaultTableModel(databaseInfo, columns){
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
    }
    public static void main(String[] arg) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ttipopu");

            Statement sqlState = conn.createStatement();

            String selectStuff = "SELECT * FROM accounts";

            rows = sqlState.executeQuery(selectStuff);

            Object[] tempRow;

            while (rows.next()){
                tempRow = new Object[]{rows.getString(1), rows.getString(2), rows.getString(3), rows.getString(4), rows.getString(5), rows.getString(6), rows.getString(7), rows.getString(8), rows.getString(9), rows.getString(10), rows.getString(11)};
                defaultTableModel.addRow(tempRow);

            }
        }


    }
}

