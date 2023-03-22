import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
public class SelectQuestions
{
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn)
    {
        try
        {
            Scanner input = new Scanner(System.in);
            
            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            
            Cleaner.cleaner();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT questions.question_id, themes.theme, questions.question_text, questions.correct_option, questions.first_option,questions.second_option,questions.third_option  FROM questions, themes WHERE themes.theme_id = questions.theme_id ORDER BY question_id");
            
            ResultSetMetaData rsmd = rs.getMetaData();//method to get mysql columns number.
            int coluns = rsmd.getColumnCount();//method to get mysql columns number.
            
            String value= "|";
            // Loop through the result set
            System.out.println("|ID| |Theme| |Question Text| |Correct Option| |First Option| |Second Option| |Third Option|");
            System.out.println("");
            
            // Loop through the result set and prints it
            while(rs.next()){
                for(int i = 1; i <= coluns; i++)
                {
                    System.out.print(value + rs.getString(i)+ value );
                }
                System.out.println("");
            }  
            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
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
