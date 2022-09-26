import java.util.*;

public class CODE_2_CONCOURS_2019
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

    static class lieu {
        public int id;
        public int decalage;
    }
    static class etape {
        public int voyageur;
        public int destination;
    }
    static void meli_melo_temporel0(lieu lieux[], int n, etape etapes[], int v)
    {
        int decalage_tot_harui = 0;
        int decalage_tot_joseph = 0;
        for (int i = 0 ; i < v ; i++) {
            if (etapes[i].voyageur==1) decalage_tot_harui=lieux[etapes[i].destination-1].decalage;
            if (etapes[i].voyageur==2) decalage_tot_joseph=lieux[etapes[i].destination-1].decalage;
            System.out.println(Math.abs(decalage_tot_harui-decalage_tot_joseph));
        }
    }
    public static void main(String args[])
    {
        int n = Integer.parseInt(scanner.nextLine());
        lieu[] liste_p = new lieu[n];
        for (int i = 0; i < n; i++)
        {
            int[] o = read_int_line();
            int id = o[0];
            int decalage = o[1];
            lieu lieux_i = new lieu();
            lieux_i.id = id;
            lieux_i.decalage = decalage;
            liste_p[i] = lieux_i;
        }
        int v = Integer.parseInt(scanner.nextLine());
        etape[] liste_e = new etape[v];
        for (int j = 0; j < v; j++)
        {
            int[] p = read_int_line();
            int voyageur = p[0];
            int destination = p[1];
            etape etape_i = new etape();
            etape_i.voyageur = voyageur;
            etape_i.destination = destination;
            liste_e[j] = etape_i;
        }
        meli_melo_temporel0(liste_p, n, liste_e, v);
    }

}