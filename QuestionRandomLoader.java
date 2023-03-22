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
import java.util.Random;
public class QuestionRandomLoader
{
    private static boolean cycle;
    private static boolean cycleQ;
    private static int score = 0;
    static int num = 0;
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn) 
    {
        play(conn);
        
        cycle = true;

        System.out.println("");
        System.out.println("Write b to go back!");
        while(cycle)
        {
            ans = input.nextLine();
            try 
            {
                if(ans.equals("b")){
                    while(ans.equals("b"))
                    {
                        if(ans.equals("b")){
                            Cleaner.cleaner();
                            Themes.main(conn);
                            ans = "";
                            break;
                        } 
                    }
                }
                else
                {
                    System.out.println("Write b to go back!");
                }
            }
            catch(Exception e) 
            {
                System.out.println("Write b to go back!");
            }
        }
    }

    private static void play(Connection conn)
    {
        System.out.println("Insert your name!");
        String name = input.nextLine();

        try {
            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            
            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * from questions where theme_id = 3 ORDER by Rand() limit 7");

            // Loop through each question and check user's answer
            while (rs.next()) {
                String[] arr = {rs.getString("correct_option"), rs.getString("first_option"), rs.getString("second_option"),rs.getString("third_option")};
                shuffleArray(arr);

                Cleaner.cleaner();
                System.out.println("╔═════════════════════════════════════════════════════•?•═════════════════════════════════════════════════════╗ ");
                System.out.println("");
                System.out.println("                                                Write the correct answer!");
                System.out.println("");
                System.out.println("");

                System.out.println("    "+rs.getString("question_text"));
                System.out.println("");

                System.out.println("        1 -> " + arr[0]);
                System.out.println("");

                System.out.println("        2 -> " + arr[1]);
                System.out.println("");

                System.out.println("        3 -> " + arr[2]);
                System.out.println("");

                System.out.println("        4 -> " + arr[3]);
                System.out.println("");
                System.out.println("");
                System.out.println("╚═════════════════════════════════════════════════════•?•═════════════════════════════════════════════════════╝ ");
                cycleQ = true;

                Scanner inputQ = new Scanner(System.in);
                while(cycleQ)
                {
                    String inQ = inputQ.next();
                    try 
                    {
                        num = Integer.parseInt(inQ);
                        if(num >= 1 && num <=4)
                        {
                            if(num == 1)
                            {
                                if(arr[0].equals(rs.getString("correct_option"))) {
                                    score++;
                                    
                                }
                            }
                            else if(num== 2)
                            {
                                if(arr[1].equals(rs.getString("correct_option"))) {
                                    score++;
                                    
                                }
                            }
                            else if(num == 3)
                            {
                                if(arr[2].equals(rs.getString("correct_option"))) {
                                    score++;
                                    
                                }
                            }
                            else if (num == 4)
                            {
                                if(arr[3].equals(rs.getString("correct_option"))) {
                                    score++;
                                    
                                } 
                            }
                            cycleQ = false;
                        }
                        else
                        {
                            System.out.println("Number out of limits please insert a valid number!");
                        }
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Number out of limits please insert a valid number!");
                    }
                }

            }
            Cleaner.cleaner();
            System.out.println("Quiz Complete! Your score is: " + score + " out of 7. Well done "+ name+ "!");

            // Execute the query
            PreparedStatement prepared_statement = conn.prepareStatement("INSERT INTO players (name, score) VALUES(?,?)", 
                    Statement.RETURN_GENERATED_KEYS);

            prepared_statement.setString(1, name);
            prepared_statement.setInt(2, score);
            int result_set = prepared_statement.executeUpdate();

            ResultSet tableKeys = prepared_statement.getGeneratedKeys();
            tableKeys.next();
            int autoGeneratedID = tableKeys.getInt(1);
            score = 0;
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void shuffleArray(String[] arr) {
        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            String temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
} 
