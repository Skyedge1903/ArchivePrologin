import java.util.*;


public class CODE_1_CONCOURS
{
    static Scanner scanner = new Scanner(System.in);
    static int bataille_de_crepe0(int n, int marchand1, int marchand2)
    {
        if (n>1000000 || n<1) System.exit(1);
        if ((marchand1+marchand2)/2==n/2) {
            return (0);
        } else {
            if ((marchand1 + marchand2) / 2 > n / 2) {
                return (1);
            } else {
                return (2);
            }
        }
    }
    public static void main(String args[])
    {
        int n = Integer.parseInt(scanner.nextLine());
        int marchand1 = Integer.parseInt(scanner.nextLine());
        int marchand2 = Integer.parseInt(scanner.nextLine());
        System.out.print(bataille_de_crepe0(n, marchand1, marchand2));
    }

}