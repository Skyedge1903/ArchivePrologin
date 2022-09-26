import java.util.*;

public class CODE_3_CONCOURS {

    static Scanner scanner = new Scanner(System.in);
    static int[] read_int_line()
    {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++)
            out[i] = Integer.parseInt(s[i]);
        return out;
    }

    static class inter {
        public int d;
        public int f;
        public int c;
    }

    static void echanger(inter intervalles[], int a, int b)
    {
        int temp = intervalles[a].d;
        intervalles[a].d = intervalles[b].d;
        intervalles[b].d = temp;
        temp = intervalles[a].f;
        intervalles[a].f = intervalles[b].f;
        intervalles[b].f = temp;
        temp = intervalles[a].c;
        intervalles[a].c = intervalles[b].c;
        intervalles[b].c = temp;
    }

    static void quickSort(inter intervalles[], int debut, int fin)
    {
        int gauche = debut-1;
        int droite = fin+1;
        int pivot = intervalles[debut].c;

        if(debut >= fin)
            return;

        while(true)
        {
            do droite--; while(intervalles[droite].c > pivot);
            do gauche++; while(intervalles[gauche].c < pivot);

            if(gauche < droite)
                echanger(intervalles, gauche, droite);
            else break;
        }

        quickSort(intervalles, debut, droite);
        quickSort(intervalles, droite+1, fin);
    }

    static int organisation_des_vacances0(int n, inter[] intervalles) {
        int i, y, cout_tot = 100000000;

        quickSort(intervalles, 0, n-1);

        for (i = 0; i <= (n - 1)/2; i++) {
            for (y = i; y <= n - 1; y++) {
                if (intervalles[i].f - intervalles[y].d <= 0 || intervalles[i].d - intervalles[y].f >= 0) {
                    cout_tot = Math.min(intervalles[i].c + intervalles[y].c, cout_tot);
                    y = n - 1;
                }
            }
        }

        if (cout_tot == 100000000) cout_tot = -1;
        return (cout_tot);
    }
    public static void main(String args[])
    {
        int n = Integer.parseInt(scanner.nextLine());
        inter[] intervalles = new inter[n];
        for (int i = 0; i < n; i++)
        {
            int[] v = read_int_line();
            int d = v[0];
            int f = v[1];
            int c = v[2];
            inter w = new inter();
            w.d = d;
            w.f = f;
            w.c = c;
            intervalles[i] = w;
        }
        System.out.print(organisation_des_vacances0(n, intervalles));
    }

}