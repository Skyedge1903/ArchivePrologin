import java.util.*;

public class CODE_3_CONCOURS_2019
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

    public static void quicksort(int [] tableau, int début, int fin) {
        if (début < fin) {
            int indicePivot = partition(tableau, début, fin);
            quicksort(tableau, début, indicePivot-1);
            quicksort(tableau, indicePivot+1, fin);
        }
    }

    public static int partition (int [] t, int début, int fin) {
        int valeurPivot = t[début];
        int d = début+1;
        int f = fin;
        while (d < f) {
            while(d < f && t[f] >= valeurPivot) f--;
            while(d < f && t[d] <= valeurPivot) d++;
            int temp = t[d];
            t[d]= t[f];
            t[f] = temp;
        }
        if (t[d] > valeurPivot) d--;
        t[début] = t[d];
        t[d] = valeurPivot;
        return d;
    }

    static void manhattan_maboul0(int m, int [] jours, int n) {
        quicksort(jours, 0, n-1);
        int y=0;
        int max=0;
        for (int i = 0; i<n ; i++) {
            while (i+y<n && jours[i+y]<=jours[i]+m) {
                y++;
            }
            max = Math.max(y,max);
        }
        System.out.print(max);
    }
    public static void main(String args[])
    {
        int[] t = read_int_line();
        int n = t[0];
        int m = t[1];
        int[] jours = read_int_line();
        manhattan_maboul0(m, jours, n);
    }

}