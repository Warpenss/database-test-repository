import java.sql.*;

public class start {
    public static void main(String[] arg){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ttipopu");

            Statement sqlState = conn.createStatement();

            String selectStuff = "Select login from accounts";

            ResultSet rows = sqlState.executeQuery(selectStuff);

            while(rows.next()){
                System.out.println(rows.getString("login"));
            }
        }

        catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
            System.out.println("VendorError: " + sqlEx.getErrorCode()  );
        }

        catch (ClassNotFoundException classEx){
            classEx.printStackTrace();
        }
    }
}
