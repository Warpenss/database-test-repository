import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class start {
    public static void main(String[] arg) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            //Entering user data

            System.out.print("Enter login: ");
            String login = reader.readLine();

            System.out.print("Enter email: ");
            String email = reader.readLine();

            System.out.print("Enter password: ");
            String pass = reader.readLine();

            System.out.print("Enter phone number: ");
            String phone = reader.readLine();

            System.out.print("Enter First Name: ");
            String firstName = reader.readLine();

            System.out.print("Enter Last Name: ");
            String lastName = reader.readLine();

            System.out.print("Enter Street: ");
            String street = reader.readLine();

            System.out.print("Enter City: ");
            String city = reader.readLine();

            System.out.print("Enter day of birth (YYYY-MM-DD): ");
            String dob = reader.readLine();

            System.out.print("Enter sex (M or F): ");
            String gender = reader.readLine();

            System.out.println("");
            System.out.println("");

            //Method for printing accounts table

            insertMethod(login, email, pass, phone, firstName, lastName, street, city, dob, gender);

            System.out.println("");
            System.out.println("");

            //Exit or continuing registration

            System.out.print("To exit the program type: Exit ");
            if(reader.readLine().toLowerCase().equals("exit"))
                break;

        }
    }

    private static void insertMethod(String login, String email, String pass, String phone, String firstName, String lastName,
                      String street, String city, String dob, String gender) {
        try{
            //Conection to MySQL

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false", "root", "ttipopu");
            Statement sqlState = conn.createStatement();

            //Inserting data into accounts table

            sqlState.executeUpdate("INSERT INTO accounts " + "VALUES ('"+ login +"', '"+ email +"', '"+ pass +"'," +
                    " '"+ phone +"', '"+ firstName +"', '"+ lastName +"', '"+ street +"', '"+ city +"'," +
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
