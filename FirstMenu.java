import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Timer;
import java.util.TimerTask;

public class FirstMenu {
    private static boolean cycle;
    public static void main(Connection conn) {
        Cleaner.cleaner();
        Timer timer = new Timer();

        timer.schedule(new TimerTask() 
            {
                @Override

                public void run() {
                    System.out.println(" ");
                    System.out.println("        █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ ");
                    System.out.println("        █             █████████████████████████████             █ ");
                    System.out.println("        █             █▄─▀█▀─▄█▄─▄▄─█▄─▀█▄─▄█▄─██─█             █ ");
                    System.out.println("        █             ██─█▄█─███─▄█▀██─█▄▀─███─██─█             █ ");
                    System.out.println("        █             ▀▄▄▄▀▄▄▄▀▄▄▄▄▄▀▄▄▄▀▀▄▄▀▀▄▄▄▄▀             █ ");
                    System.out.println("        █             █████████████████████████████             █ ");
                    System.out.println("        █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█ ");
                    System.out.println(" ");

                }
            }, 150);
        choose(conn);
    }

    private static void choose(Connection conn){
        Timer timer1 = new Timer();

        timer1.schedule(new TimerTask() 
            {
                @Override

                public void run() {
                    System.out.println(" ");
                    System.out.println("        ╔════════════════════════•💻•════════════════════════╗ ");
                    System.out.println("                                |𝗖𝗵𝗼𝗼𝘀𝗲 𝗮𝗻 𝗼𝗽𝘁𝗶𝗼𝗻|  ");
                    System.out.println(" ");
                }
            }, 450);

        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟭| - |𝗦𝘁𝗮𝗿𝘁 𝗤𝘂𝗶𝘇|");
                    System.out.println(" ");
                }
            }, 550);

        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟮| - |𝗛𝗼𝘄 𝗧𝗼 𝗣𝗹𝗮𝘆|");
                    System.out.println(" ");
                }
            }, 650);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟯| - |𝗣𝗹𝗮𝘆𝗲𝗿𝘀 𝗦𝗰𝗼𝗿𝗲|");
                    System.out.println(" ");
                }
            }, 750);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟰| - |𝗔𝗱𝗺𝗶𝗻𝗶𝘀𝘁𝗿𝗮𝘁𝗼𝗿|");
                    System.out.println(" ");
                }
            }, 850);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟱| - |𝗕𝗮𝗰𝗸|");
                    System.out.println(" ");
                    System.out.println(" ");
                }
            }, 950);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("        ╚════════════════════════•💻•════════════════════════╝ ");
                    System.out.println(" ");
                }
            }, 1050);

        cycle = true;
        int num = 0;

        Scanner input = new Scanner(System.in);
        while(cycle)
        {
            String in = input.next();
            try 
            {
                num = Integer.parseInt(in);
                if(num <1 || num >5)
                {
                    System.out.println("Number out of limits please insert a valid number!");
                }
                else{
                    switch (num) {
                        case 1 :
                            Cleaner.cleaner();
                            cycle = false;
                            Themes.main(conn);
                            break;
                        case 2 :
                            Cleaner.cleaner();
                            cycle = false;
                            HowToPlay.main(conn);
                            break;
                        case 3 :
                            Cleaner.cleaner();
                            cycle = false;
                            AllScore.main(conn);
                            break;
                        case 4 :
                            Cleaner.cleaner();
                            cycle = false;
                            LoginAdmin.main(conn);
                            break;
                        case 5 :
                            Cleaner.cleaner();
                            cycle = false;
                            StartQuiz.main();
                            break;
                    }
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Number out of limits please insert a valid number!");
            }
        }
    }
}
