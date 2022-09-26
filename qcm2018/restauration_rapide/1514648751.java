import java.util.*;

public class CODE_4_CONCOURS_2 {

    static Scanner scanner = new Scanner(System.in);

    static int[] read_int_line() {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            out[i] = Integer.parseInt(s[i]);
        }
        return out;
    }

    static class route {
        public int x;
        public int y;
        public int l;
    }

    static int restauration_rapide0(int m, route[] routes) {
        double n_p = ((1.0 + m) / 2.0) * m;
        double dis_tot = 0;
        int soluce;
        int liaisons[] = new int[m + 1];
        int liaisons_sav[] = new int[m + 1];
        int extremite = 0, c = 0;
        long overflow;

        for (int i = 0; i < m; i++) {
            liaisons[routes[i].x] = liaisons[routes[i].x] + 1;
        }

        for (int i = 0; i <= m; i++) liaisons_sav[i] = liaisons[i];

        for (int i = 0; i <= m; i++) {
            if (liaisons[i] == 0) {
                extremite++;
            }
        }
        int extremites[] = new int[extremite];

        for (int i = 0; i <= m; i++) {
            if (liaisons[i] == 0) {
                extremites[c] = i - 1;
                c++;
            }
        }

        while (liaisons[0]!=m) {
            for (int i = 0; i < c; i++) {
                if (extremites[i]!=-1) {
                    if (liaisons_sav[extremites[i]+1]>1) {
                        liaisons_sav[extremites[i]+1]=liaisons_sav[extremites[i]+1]-1;
                        extremites[i] = -1;
                    }
                    else {
                        liaisons[routes[extremites[i]].x] = liaisons[extremites[i] + 1] + liaisons[routes[extremites[i]].x];
                        if (routes[extremites[i]].x == 0) extremites[i] = -1;
                        else extremites[i] = routes[extremites[i]].x - 1;
                    }
                }
                if (liaisons[0]==m) break;
            }
        }

        for (int i = 1; i <= m; i++) {
            overflow=m-1;
            overflow=overflow-liaisons[i];
            overflow=overflow*liaisons[i];
            overflow=overflow+m;
            overflow=overflow*routes[i-1].l;
            dis_tot=dis_tot+overflow;
        }
        
        soluce = (int) Math.floor((dis_tot)/n_p);
        return (soluce);
    }

    public static void main(String args[]) {
        int m = Integer.parseInt(scanner.nextLine());
        route[] routes = new route[m];
        for (int i = 0; i < m; i++) {
            int[] v = read_int_line();
            int x = v[0];
            int y = v[1];
            int l = v[2];
            route w = new route();
            w.x = x;
            w.y = y;
            w.l = l;
            routes[i] = w;
        }
        System.out.println(restauration_rapide0(m, routes));
    }

}