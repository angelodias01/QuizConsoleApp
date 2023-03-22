import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LoginAdmin
{
    private static boolean log;
    public static void main(Connection conn)
    {
        log = true;
        Cleaner.cleaner();
        while(log)
        {
            try
            {
                System.out.print("\n");

                Scanner login= new Scanner(System.in);
                System.out.print("Username: ");
                String user = login.next();
                System.out.print("\nPassword: ");
                String pass = login.next();

                // Get a connection to the database
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
                for(SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning())
                {
                    System.out.println("SQL Warning:");
                    System.out.println("State  : " + warn.getSQLState());
                    System.out.println("Message: " + warn.getMessage());
                    System.out.println("Error  : " + warn.getErrorCode());
                }
                // Get a statement from the connection
                Statement stmt = conn.createStatement();
                // Query to do the login
                String sql = "SELECT * FROM admin WHERE admin_name = '"+user+"' AND admin_password = '"+pass+"'";
                // Execute the query
                ResultSet rs = stmt.executeQuery(sql);

                //if rs gets any data it will be able to enter to the admin menu else it will restart the loop!
                if(rs.next())
                {
                    System.out.println("Login successful!");
                    System.out.print('\u000C');
                    
                    log = false;
                    MenuAdmin.main(conn);
    
                    rs.close();
                    stmt.close();
                    conn.close();
                }
                else
                {
                    log = true;
                    System.out.println("Username or password incorrect!");
                }
            }
            catch(SQLException se)
            {
                System.out.println("SQL Exception:");

                // Loop through the SQL Exceptions
                while(se != null)
                {
                    System.out.println("State  : " + se.getSQLState());
                    System.out.println("Message: " + se.getMessage());
                    System.out.println("Error  : " + se.getErrorCode());

                    se = se.getNextException();
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
