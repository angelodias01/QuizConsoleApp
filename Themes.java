import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class Themes {
    private static boolean cycle;
    public static void main(Connection conn) {
        choose();

        cycle = true;
        int num = 0;

        Scanner input = new Scanner(System.in);

        while(cycle)
        {
            String in = input.next();
            try 
            {
                num = Integer.parseInt(in);
                switch(num)
                {
                    case 1 : 
                        Cleaner.cleaner();
                        cycle = false;
                        QuestionSpaceLoader.main(conn);
                        break;
                    case 2 :
                        Cleaner.cleaner();
                        cycle = false;
                        QuestionTecnologyLoader.main(conn);
                        break;
                    case 3 :
                        Cleaner.cleaner();
                        cycle = false;
                        QuestionRandomLoader.main(conn);
                        break;
                    case 4 : 
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

    public static void choose(){
        Timer timer1 = new Timer();

        timer1.schedule(new TimerTask() 
            {
                @Override

                public void run() {
                    System.out.println(" ");
                    System.out.println("        ╔════════════════════════•💻•════════════════════════╗ ");
                    System.out.println("                                𝗖𝗵𝗼𝗼𝘀𝗲 𝗮 𝘁𝗵𝗲𝗺𝗲   ");
                    System.out.println(" ");
                }
            }, 250);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            𝟭 - 𝗦𝗽𝗮𝗰𝗲");
                    System.out.println(" ");
                }
            }, 300);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            𝟮 - 𝗧𝗲𝗰𝗻𝗼𝗹𝗼𝗴𝘆");
                    System.out.println(" ");
                }
            }, 350);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            𝟯 - 𝗥𝗮𝗻𝗱𝗼𝗺");
                    System.out.println(" ");
                }
            }, 400);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("            𝟰 - 𝗕𝗮𝗰𝗸");
                    System.out.println(" ");
                    System.out.println(" ");
                }
            }, 450);
        timer1.schedule(new TimerTask() {
                @Override

                public void run() {
                    System.out.println("        ╚════════════════════════•💻•════════════════════════╝ ");
                    System.out.println(" ");
                }
            }, 500);
    }
}
