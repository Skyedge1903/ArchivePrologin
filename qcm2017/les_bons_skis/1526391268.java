import java.util.*;

public class Main
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

    static void les_bons_skis(int nbSkis, int taillePersonne, int[] skis)
    {
        int diffmin = 0;
        int i = 0;
        for (i = 0 ; i<tainbSkis ; i++) {
            if (Math.abs(skis[i]-taillePersonne)<Math.abs(skis[diffmin]-taillePersonne)) {
                diffmin = i;
            }
            else if (Math.abs(skis[i]-taillePersonne)=Math.abs(skis[diffmin]-taillePersonne)) {
                if (skis[i]<skis[diffmin]) {
                    diffmin = i;
                }
            }
        }
        System.out.print(skis[diffmin]);
    }

    public static void main(String args[])
    {
        int nbSkis = Integer.parseInt(scanner.nextLine());
        int taillePersonne = Integer.parseInt(scanner.nextLine());
        int[] skis = read_int_line();
        les_bons_skis(nbSkis, taillePersonne, skis);
    }
}