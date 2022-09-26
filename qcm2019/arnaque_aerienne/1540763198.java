import java.util.*;

public class CODE_1_CONCOURS_2019
{
    static Scanner scanner = new Scanner(System.in);
    static int[] read_int_line()
    {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++)
            out[i] = Integer.parseInt(s[i]);
        return out;
    }

    static void arnaque_aerienne0(int prix_initial, int[] billets, int n)
    {
        int e = 0;
        for (int i =0 ; i < n ; i++) {
            if (billets[i]<prix_initial) e++;
        }
        if (e>=3) System.out.print("ARNAQUE !");
        else System.out.println("Ok bon voyage, bisous, n'oublie pas de m'envoyer des photos !");
    }
    public static void main(String args[])
    {
        int prix_initial = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int[] billets = read_int_line();
        arnaque_aerienne0(prix_initial, billets, n);
    }

}