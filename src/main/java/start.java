import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class start {
    public static void main(String[] arg) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter login: ");
            String log = reader.readLine();

            System.out.print("Enter email: ");
            String emai = reader.readLine();

            System.out.print("Enter password: ");
            String pass = reader.readLine();

            System.out.print("Enter phone number: ");
            String phone = reader.readLine();

            System.out.print("Enter First Name: ");
            String firstName = reader.readLine();

            System.out.print("Enter Last Name: ");
            String lastName = reader.readLine();

            System.out.print("Enter Street: ");
            String stree = reader.readLine();

            System.out.print("Enter City: ");
            String cit = reader.readLine();

            System.out.print("Enter day of birth (YYYY-MM-DD): ");
            String dob = reader.readLine();

            System.out.print("Enter sex (M or F): ");
            String gender = reader.readLine();

            insertMethod(log, emai, pass, phone, firstName, lastName, stree, cit, dob, gender);

            System.out.print("To exit the program type: Exit ");
            if(reader.readLine().equals("Exit"))
                break;


        }
    }

    private static void insertMethod(String log, String emai, String pass, String phone, String firstName, String lastName,
                      String stree, String cit, String dob, String gender)
    {
        try{
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false", "root", "ttipopu");
            Statement sqlState = conn.createStatement();

            sqlState.executeUpdate("INSERT INTO accounts " + "VALUES ('"+ log +"', '"+ emai +"', '"+ pass +"'," +
                    " '"+ phone +"', '"+ firstName +"', '"+ lastName +"', '"+ stree +"', '"+ cit +"'," +
                    " '"+ dob +"', '"+ gender +"', null)");

            String selectStuff = "SELECT login, email, password FROM accounts";
            ResultSet rows = sqlState.executeQuery(selectStuff);
            while(rows.next()){
                System.out.println("Login: " + rows.getString("login") + "    Email: " + rows.getString("email") +
                        "    Password: " + rows.getString("password"));
            }

        }

        catch (SQLException sqlEx) {
            System.out.println("Error. Incorrectly entered data!");
            System.out.println("SQLException: " + sqlEx.getMessage());
            System.out.println("VendorError: " + sqlEx.getErrorCode()  );
        }

        catch (ClassNotFoundException classEx){
            classEx.printStackTrace();
        }

    }
}
