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

public class EditQuestions
{ 
    private static boolean cycle;
    private static boolean cycleB;
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn)
    {
        update(conn);
        cycleB = true;

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
                            EditQuestions.main(conn);
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

    public static void update(Connection conn)
    {
        cycle = true;
        int id_num = 0;
        try
        {
            SelectQuestions.main(conn);

            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("Select a id to update");

            Scanner input = new Scanner(System.in);

            while(cycle)
            {
                String in = input.next();
                try 
                {
                    id_num = Integer.parseInt(in);
                    if(id_num > 0)
                    {
                        System.out.println("Insert question text");
                        String question_text = scanner.nextLine();

                        System.out.println("Insert correct option");
                        String correct_option= scanner.nextLine();

                        System.out.println("Insert first option");
                        String first_option = scanner.nextLine();

                        System.out.println("Insert second option");
                        String second_option = scanner.nextLine();

                        System.out.println("Insert third option");
                        String third_option = scanner.nextLine();

                        // Execute the query
                        PreparedStatement prepared_statement = conn.prepareStatement("UPDATE questions SET question_text ='"+question_text+"',  correct_option= '"+correct_option+"', first_option='"+first_option+"', second_option='"+second_option+"', third_option='"+third_option+"' where question_id='"+id_num+"'");
                        int result_set = prepared_statement.executeUpdate();

                        if (result_set > 0)
                        {
                            Cleaner.cleaner();
                            cycle = false;
                            System.out.println("Question updated!");
                        }
                        else{
                            Cleaner.cleaner();
                            cycle = false;
                            System.out.println("Unable to update the question!");
                        }
                    }
                }
                catch(NumberFormatException e) {
                    System.out.println("Number out of limits please insert a valid number!");
                }
            }
            // Close the result set, statement and the connection
            //rs.close();
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
