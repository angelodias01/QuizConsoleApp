import java.util.Scanner;
import java.sql.Connection;
public class HowToPlay
{
    private static boolean cycle;
    static String ans;
    static Scanner input = new Scanner(System.in);
    public static void main(Connection conn){
        cycle = true;

        rules();

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
                            cycle = false;
                            FirstMenu.main(conn);
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

    private static void rules()
    {
        System.out.println("");
        System.out.println("╔════════════════════════════════•💻•════════════════════════════════╗");
        System.out.println("");
        System.out.println("");
        System.out.println("                                   𝗛𝗼𝘄 𝗧𝗼 𝗣𝗹𝗮𝘆!");
        System.out.println("");
        System.out.println("");
        System.out.println("        𝗧𝗵𝗲𝘀𝗲 𝗮𝗿𝗲 𝘁𝗵𝗲 𝗿𝘂𝗹𝗲𝘀 𝗼𝗳 𝗼𝘂𝗿 𝗾𝘂𝗶𝘇:");
        System.out.println("");
        System.out.println("");
        System.out.println("        -> 𝗧𝗼 𝘀𝘂𝗯𝗺𝗶𝘁 𝗮𝗻 𝗮𝗻𝘀𝘄𝗲𝗿, 𝘆𝗼𝘂 𝗻𝗲𝗲𝗱 𝘁𝗼 𝘄𝗿𝗶𝘁𝗲 𝘁𝗵𝗲 𝗿𝗲𝘀𝗽𝗲𝗰𝘁𝗶𝘃𝗲 𝗮𝗻𝘀𝘄𝗲𝗿 𝗻𝘂𝗺𝗯𝗲𝗿");
        System.out.println("");
        System.out.println("        -> 𝗪𝗿𝗶𝘁𝗲 𝗲𝘃𝗲𝗿𝘆𝘁𝗵𝗶𝗻𝗴 𝗯𝗮𝘀𝗲𝗱 𝗼𝗻 𝘁𝗵𝗲 𝗶𝗻𝘀𝘁𝗿𝘂𝗰𝘁𝗶𝗼𝗻𝘀");
        System.out.println("");
        System.out.println("        -> 𝗧𝗵𝗲 𝘀𝗰𝗼𝗿𝗲 𝗮𝗽𝗽𝗲𝗮𝗿𝘀 𝗮𝗳𝘁𝗲𝗿 𝘁𝗵𝗲 𝗹𝗮𝘀𝘁 𝗮𝗻𝘀𝘄𝗲𝗿 𝗶𝘀 𝘀𝘂𝗯𝗺𝗶𝘁𝗲𝗱");
        System.out.println("");
        System.out.println("        -> 𝗧𝗵𝗲 𝗾𝘂𝗶𝘇 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝘀 𝟳 𝗾𝘂𝗲𝘀𝘁𝗶𝗼𝗻𝘀 𝗽𝗲𝗿 𝘁𝗲𝘀𝘁");
        System.out.println("");
        System.out.println("        -> 𝗛𝗮𝘃𝗲 𝗳𝘂𝗻!");
        System.out.println("");
        System.out.println("");    
        System.out.println("╚════════════════════════════════•💻•════════════════════════════════╝");
        System.out.println("");
    }
}
