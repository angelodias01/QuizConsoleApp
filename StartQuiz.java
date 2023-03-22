/**
 * @author (Ângelo Dias, Martim Dias)
 * @version (Beta 1)
 */
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.SQLException;

public class StartQuiz
{
    private static int num = 0;
    private static boolean cycle;
    public static void main()
    {
        
        try
        {
            // Load the database driver class, which enables the java application to interact with the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database using JDBC url, database username and password
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");

            for(SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning())
            {
                System.out.println("SQL Warning:");
                System.out.println("State  : " + warn.getSQLState());
                System.out.println("Message: " + warn.getMessage());
                System.out.println("Error  : " + warn.getErrorCode());
            }
            cycle = true;
            
            timer();

            Scanner input = new Scanner(System.in);
            while(cycle)
            {
                String in = input.next();
                try 
                {
                    num = Integer.parseInt(in);
                    if(num == 1)
                    {
                        //Thread.sleep(2000);
                        Cleaner.cleaner();
                        
                        cycle = false;
                        FirstMenu.main(conn);
                    }
                    else
                    {
                        Cleaner.cleaner();
                        cycle = false;
                        exit();
                    }
                }
                catch(NumberFormatException e) {
                    Cleaner.cleaner();
                    cycle = false;
                    exit();
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

    private static void timer()
    {
        //method to print the inicial message
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("                                                 ░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗");
                    System.out.println("                                                 ░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝");
                    System.out.println("                                                 ░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░");
                    System.out.println("                                                 ░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░");
                    System.out.println("                                                 ░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗");
                    System.out.println("                                                 ░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝");

                }
            },  500);      
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                                                                           ████████╗░█████╗░");
                    System.out.println("                                                                           ╚══██╔══╝██╔══██╗");
                    System.out.println("                                                                           ░░░██║░░░██║░░██║");
                    System.out.println("                                                                           ░░░██║░░░██║░░██║");
                    System.out.println("                                                                           ░░░██║░░░╚█████╔╝");
                    System.out.println("                                                                           ░░░╚═╝░░░░╚════╝░");
                }
            },  1000);
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                                                                       ████████╗██╗░░██╗███████╗");
                    System.out.println("                                                                       ╚══██╔══╝██║░░██║██╔════╝");
                    System.out.println("                                                                       ░░░██║░░░███████║█████╗░░");
                    System.out.println("                                                                       ░░░██║░░░██╔══██║██╔══╝░░");
                    System.out.println("                                                                       ░░░██║░░░██║░░██║███████╗");
                    System.out.println("                                                                       ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝");
                }
            },  1500);
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" "); 
                    System.out.println("                                                                    ░██████╗░██╗░░░██╗██╗███████╗██╗");
                    System.out.println("                                                                    ██╔═══██╗██║░░░██║██║╚════██║██║");
                    System.out.println("                                                                    ██║██╗██║██║░░░██║██║░░███╔═╝██║");
                    System.out.println("                                                                    ╚██████╔╝██║░░░██║██║██╔══╝░░╚═╝");
                    System.out.println("                                                                    ░╚═██╔═╝░╚██████╔╝██║███████╗██╗");
                    System.out.println("                                                                    ░░░╚═╝░░░░╚═════╝░╚═╝╚══════╝╚═╝");
                }
            },  2000);
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                         ██████████████████████████████████████████████████████████████████████████████████████████████████████ ███");
                    System.out.println("                         █▄─▄▄─█▄─▄▄▀█▄─▄▄─█─▄▄▄▄█─▄▄▄▄███▀─████─▄─▄─█─▄▄─███─▄▄▄─█─▄▄─█▄─▀█▄─▄█─▄─▄─█▄─▄█▄─▀█▄─▄█▄─██─▄█▄─▄▄─█ █─█");
                    System.out.println("                         ██─▄▄▄██─▄─▄██─▄█▀█▄▄▄▄─█▄▄▄▄─████─██████─███─██─███─███▀█─██─██─█▄▀─████─████─███─█▄▀─███─██─███─▄█▀█ █▄█");
                    System.out.println("                         ▀▄▄▄▀▀▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▀▀▄▄▄▀▀▀▀▄▄▄▀▀▄▄▄▄▀▀▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▀▀▄▄▀▀▄▄▄▀▀▄▄▄▀▄▄▄▀▀▄▄▀▀▄▄▄▄▀▀▄▄▄▄▄▀ ▀▄▀");
                }
            },  2500);
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println(" ████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████ ███");
                    System.out.println(" █▄─▄▄─█▄─▄▄▀█▄─▄▄─█─▄▄▄▄█─▄▄▄▄███─▄▄▄▄█─▄▄─█▄─▀█▀─▄█▄─▄▄─█─▄─▄─█─█─█▄─▄█▄─▀█▄─▄█─▄▄▄▄███▄─▄▄─█▄─▄███─▄▄▄▄█▄─▄▄─██─▄─▄─█─▄▄─███▄─▄▄─█▄─▀─▄█▄─▄█─▄─▄─█ █─█");
                    System.out.println(" ██─▄▄▄██─▄─▄██─▄█▀█▄▄▄▄─█▄▄▄▄─███▄▄▄▄─█─██─██─█▄█─███─▄█▀███─███─▄─██─███─█▄▀─██─██▄─████─▄█▀██─██▀█▄▄▄▄─██─▄█▀████─███─██─████─▄█▀██▀─▀███─████─███ █▄█");
                    System.out.println(" ▀▄▄▄▀▀▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▀▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▀▄▄▄▀▄▄▄▄▄▀▀▄▄▄▀▀▄▀▄▀▄▄▄▀▄▄▄▀▀▄▄▀▄▄▄▄▄▀▀▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▀▀▄▄▄▀▀▄▄▄▄▀▀▀▄▄▄▄▄▀▄▄█▄▄▀▄▄▄▀▀▄▄▄▀▀ ▀▄▀");
                }
            }, 3000);
        System.out.println(" ");   
    }

    private static void exit()
    {
        //method to print the exit message
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                                                                     ████████╗██╗░░██╗░█████╗░███╗░░██╗██╗░░██╗");
                    System.out.println("                                                                     ╚══██╔══╝██║░░██║██╔══██╗████╗░██║██║░██╔╝");
                    System.out.println("                                                                     ░░░██║░░░███████║███████║██╔██╗██║█████═╝░");
                    System.out.println("                                                                     ░░░██║░░░██╔══██║██╔══██║██║╚████║██╔═██╗░");
                    System.out.println("                                                                     ░░░██║░░░██║░░██║██║░░██║██║░╚███║██║░╚██╗");
                    System.out.println("                                                                     ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝");

                }
            },  500);      
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                                                                                ██╗░░░██╗░█████╗░██╗░░░██╗");
                    System.out.println("                                                                                ╚██╗░██╔╝██╔══██╗██║░░░██║");
                    System.out.println("                                                                                ░╚████╔╝░██║░░██║██║░░░██║");
                    System.out.println("                                                                                ░░╚██╔╝░░██║░░██║██║░░░██║");
                    System.out.println("                                                                                ░░░██║░░░╚█████╔╝╚██████╔╝");
                    System.out.println("                                                                                ░░░╚═╝░░░░╚════╝░░╚═════╝░");
                }
            },  1000);
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                                                                                  ███████╗░█████╗░██████╗░");
                    System.out.println("                                                                                  ██╔════╝██╔══██╗██╔══██╗");
                    System.out.println("                                                                                  █████╗░░██║░░██║██████╔╝");
                    System.out.println("                                                                                  ██╔══╝░░██║░░██║██╔══██╗");
                    System.out.println("                                                                                  ██║░░░░░╚█████╔╝██║░░██║");
                    System.out.println("                                                                                  ╚═╝░░░░░░╚════╝░╚═╝░░╚═╝");
                }
            },  1500);
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" ");
                    System.out.println("                                                                ██████╗░██╗░░░░░░█████╗░██╗░░░██╗██╗███╗░░██╗░██████╗░");
                    System.out.println("                                                                ██╔══██╗██║░░░░░██╔══██╗╚██╗░██╔╝██║████╗░██║██╔════╝░");
                    System.out.println("                                                                ██████╔╝██║░░░░░███████║░╚████╔╝░██║██╔██╗██║██║░░██╗░");
                    System.out.println("                                                                ██╔═══╝░██║░░░░░██╔══██║░░╚██╔╝░░██║██║╚████║██║░░╚██╗");
                    System.out.println("                                                                ██║░░░░░███████╗██║░░██║░░░██║░░░██║██║░╚███║╚██████╔╝");
                    System.out.println("                                                                ╚═╝░░░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░");
                }
            },  2000);
    }
}
