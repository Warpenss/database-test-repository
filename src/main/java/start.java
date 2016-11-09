import java.sql.*;

public class start {
    public static void main(String[] arg){
        Connection conn;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ttipopu");

            Statement sqlState = conn.createStatement();

            String selectStuff = "SELECT login, email, password FROM accounts";

            ResultSet rows = sqlState.executeQuery(selectStuff);

            while(rows.next()){
                System.out.println("Login: " + rows.getString("login") + "    Email: " + rows.getString("email") +
                        "    Password: " + rows.getString("password"));
            }

            sqlState.executeUpdate("INSERT INTO accounts "+ "VALUES ('gafer', 'gafer@ya.ru', 'chashpasw', '0933994443', 'Huge', 'Mangus', 'Duglas', 'Krakow', '1996-04-23', 'M', null)");
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
