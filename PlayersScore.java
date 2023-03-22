import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PlayersScore
{
    private static boolean cycle;
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn)
    {
        SelectPlayers(conn);

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
                            PlayersScore.main(conn);
                            System.out.println("");
                            System.out.println("If you want to reload write r if you want to go back write b!");
                            cycle = false;
                            break;
                        }
                        else if(ans.equals("b")){
                            Cleaner.cleaner();
                            MenuAdmin.main(conn);
                            ans = "";
                            cycle= false;
                            break;
                        }
                    }
                }
            }
            catch(Exception e) 
            {
                System.out.println("If you want to reload write r if you want to go back write b!");
            }
        }
    } 

    private static void SelectPlayers(Connection conn)
    {
        try
        {
            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            
            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT players.name, players.score FROM players");
            
            Cleaner.cleaner();
            String value= "| ";
            System.out.println("| Player Name | | Player Score |");
            
            // Loop through the result set and prints it
            while(rs.next()){
                System.out.print(value + rs.getString(1)+" | "+"| "+rs.getString(2)+"/7"+" | ");
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
