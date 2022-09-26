import java.util.*;

public class CODE_4_CONCOURS {

    static Scanner scanner = new Scanner(System.in);

    static int[] read_int_line() {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++)
            out[i] = Integer.parseInt(s[i]);
        return out;
    }

    static class route {
        public int x;
        public int y;
        public int l;
    }

    static int distance_entre(int point1, int point2, int m, route[] routes) {

        int distance=0;
        int i=0,j=0;

        do {
            if (point1==point2) {
                distance = routes[point2].l + distance;
                break;
            }
            else {
                if (point1 < point2) {
                    distance = routes[point2].l + distance;
                    point2 = routes[point2].x-1;
                    i++;
                    if ((i<1 || j<1) && point1==point2 && point2>-1) {
                        distance = routes[point2].l + distance;
                        break;
                    }
                }
                if (point1 > point2) {
                    distance = routes[point1].l + distance;
                    point1 = routes[point1].x-1;
                    j++;
                    if ((i<1 || j<1) && point1==point2 && point1>-1) {
                        distance = routes[point1].l + distance;
                        break;
                    }
                }
                if (point1==point2) break;
            }
        }

        while (point1!=-1 && point2!=-1);
        return distance;
    }
    static int restauration_rapide0(int m, route[] routes) {
        double n_p = ((1.0+m)/2.0)*m;
        int dis_tot=0;
        int soluce;
        int r=0;

        for (int i = 0; i <= m - 1; i++) {
            if (routes[i].x==0) {
                routes[i].x=-1;
            }
        }

        for (int i = 0; i <= m - 1; i++) {
            for (int y = i; y <= m - 1; y++) {
                dis_tot=distance_entre(i,y,m,routes)+dis_tot;
                r++;
            }
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
        System.out.print(restauration_rapide0(m, routes));
    }

}