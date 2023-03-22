import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MenuAdmin {
    private static boolean cycle;
    public static void main(Connection conn) {
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
                    System.out.println("            |𝟭| - |𝗖𝗵𝗲𝗰𝗸 𝗣𝗹𝗮𝘆𝗲𝗿𝘀 𝗦𝗰𝗼𝗿𝗲|");
                    System.out.println(" ");
                }
            }, 550);

        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟮| - |𝗜𝗻𝘀𝗲𝗿𝘁 𝗤𝘂𝗲𝘀𝘁𝗶𝗼𝗻|");
                    System.out.println(" ");
                }
            }, 650);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟯| - |𝗨𝗽𝗱𝗮𝘁𝗲 𝗤𝘂𝗲𝘀𝘁𝗶𝗼𝗻|");
                    System.out.println(" ");
                }
            }, 750);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            |𝟰| - |𝗗𝗲𝗹𝗲𝘁𝗲 𝗤𝘂𝗲𝘀𝘁𝗶𝗼𝗻|");
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
            }, 900);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("        ╚════════════════════════•💻•════════════════════════╝ ");
                    System.out.println(" ");
                }
            }, 950);

        cycle = true;
        int num = 0;

        Scanner input = new Scanner(System.in);

        while(cycle)
        {
            String in = input.next();
            try 
            {
                num = Integer.parseInt(in);
                switch (num) {
                    case 1 :
                        Cleaner.cleaner();
                        cycle = false;
                        PlayersScore.main(conn);
                        break;
                    case 2 :
                        Cleaner.cleaner();
                        cycle = false;
                        InsertQuestions.main(conn);
                        break;
                    case 3 :
                        Cleaner.cleaner();
                        cycle = false;
                        EditQuestions.main(conn);
                        break;
                    case 4 :
                        Cleaner.cleaner();
                        cycle = false;
                        DeleteQuestions.main(conn);
                        break;
                    case 5 :
                        Cleaner.cleaner();
                        cycle = false;
                        FirstMenu.main(conn);
                        break;
                }
            }

            catch(NumberFormatException e) {
                System.out.println("Number out of limits please insert a valid number!");
            }
        }
    }
}

