import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class DeleteQuestions
{
    private static boolean cycle;
    private static boolean cycleB;
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn)
    {
        cycleB = true;
        delete(conn);

        System.out.println("");
        System.out.println("If you want to reload write r if you want to go back write b!");
        while(cycleB)
        {
            ans = input.nextLine();
            try 
            {
                if(ans.equals("r") || ans.equals("b")){
                    while(ans.equals("r")|| ans.equals("b"))
                    {
                        if(ans.equals("r")){
                            DeleteQuestions.main(conn);
                            System.out.println("");
                            System.out.println("If you want to reload write r if you want to go back write b!");
                            cycleB = false;
                            break;
                        }
                        else if(ans.equals("b")){
                            Cleaner.cleaner();
                            MenuAdmin.main(conn);
                            ans = "";
                            cycleB = false;
                            break;
                        }
                        ans = input.nextLine();
                    }
                }
            } 
            catch(Exception e) 
            {
                System.out.println("If you want to reload write r if you want to go back write b!");
            }
        }
    }

    private static void delete(Connection conn)
    {
        cycle = true;
        int questionID = 0;
        try
        {
            Cleaner.cleaner();
            SelectQuestions.main(conn);

            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            Scanner input = new Scanner(System.in);

            System.out.println("");
            System.out.println("Select the id of the question that you want to delete!");
            while(cycle)
            {
                String in = input.next();
                try 
                {
                    questionID = Integer.parseInt(in);

                    // Execute the query
                    PreparedStatement prepared_statement = conn.prepareStatement("DELETE FROM questions WHERE question_id=?;");
                    prepared_statement.setInt(1, questionID);
                    int result_set = prepared_statement.executeUpdate();
                    Cleaner.cleaner();
                    if (result_set > 0)
                    {
                        cycle = false;
                        System.out.println("Question deleted!");
                    }
                    else
                    {
                        Cleaner.cleaner();
                        cycle = false;
                        System.out.println("Unable to delete the selected question");
                    }

                    // Close the result set, statement and the connection
                    stmt.close();
                    conn.close();
                }
                catch(NumberFormatException e) {
                    System.out.println("Number out of limits please insert a valid number!");
                }
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

