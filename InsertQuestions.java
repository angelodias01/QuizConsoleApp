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

public class InsertQuestions
{
    private static boolean cycle;
    private static boolean cycleT;
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn)
    {
        insert(conn);
        cycle = true;
        
        System.out.println("");
        System.out.println("If you want to reload write r if you want to go back write b!");
        while(cycle)
        {
            ans = input.nextLine();
            try 
            {
                if(ans.equals("r") || ans.equals("b")){
                    while(ans.equals("r")|| ans.equals("b"))
                    {
                        if(ans.equals("r")){
                            InsertQuestions.main(conn);
                            System.out.println("");
                            System.out.println("If you want to reload write r if you want to go back write b!");
                            cycle = false;
                            break;
                        }
                        else if(ans.equals("b")){
                            Cleaner.cleaner();
                            MenuAdmin.main(conn);
                            ans = "";
                            cycle = false;
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

    private static void theme(Connection conn)
    {
        try
        {
            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");

            Cleaner.cleaner();

            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM themes ORDER BY theme_id");

            int coluns = 3;
            String value= "|";

            System.out.println("|ID| |Theme|");
            System.out.println("");

            // Loop through the result set and prints it
            while(rs.next()){
                for(int i = 1; i < coluns; i++)
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

    private static void insert(Connection conn)
    {
        try
        {
            String theme_ID = "";
            int theme = 0;
            cycleT = true;
            
            Statement stmt = conn.createStatement();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            Scanner scanner = new Scanner(System.in);

            theme(conn);

            System.out.println("Select a theme!");
            while(cycleT)
            {
                theme_ID = scanner.nextLine();
                try 
                {
                    theme = Integer.parseInt(theme_ID);
                    if(theme >= 1 && theme <= 3)
                    {
                        Cleaner.cleaner();
                        cycleT = false;
                    }
                    else
                    {
                        System.out.println("The selected theme does not exist!");
                    }
                }
                catch(NumberFormatException e) {
                    System.out.println("The selected theme does not exist!");
                }
            }

            System.out.println("Insert the question text:");
            String question_Text = scanner.nextLine();

            System.out.println("Insert the correct option:");
            String correct_Option = scanner.nextLine();

            System.out.println("Insert the first wrong option:");
            String first_Option = scanner.nextLine();

            System.out.println("Insert the second wrong option:");
            String second_Option = scanner.nextLine();

            System.out.println("Insert the third wrong option:");
            String third_Option = scanner.nextLine();

            PreparedStatement prepared_statement = conn.prepareStatement("INSERT INTO questions (theme_id, question_text, correct_option, first_option, second_option, third_option) VALUES(?,?,?,?,?,?)", 
                    Statement.RETURN_GENERATED_KEYS);

            prepared_statement.setInt(1, theme);
            prepared_statement.setString(2, question_Text);
            prepared_statement.setString(3, correct_Option);
            prepared_statement.setString(4, first_Option);
            prepared_statement.setString(5, second_Option);
            prepared_statement.setString(6, third_Option);
            int result_set = prepared_statement.executeUpdate();

            ResultSet tableKeys = prepared_statement.getGeneratedKeys();
            tableKeys.next();
            int autoGeneratedID = tableKeys.getInt(1);

            if (result_set > 0)
            {
                Cleaner.cleaner();
                System.out.println("Question inserted!");
            }
            else
            {
                Cleaner.cleaner();
                System.out.println("Unable insert the question!");
            }

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
