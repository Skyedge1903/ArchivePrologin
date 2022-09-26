import java.util.*;

public class CODE_5_CONCOURS {
    static Scanner scanner = new Scanner(System.in);

    static int[] read_int_line()

    {

        String[] s = scanner.nextLine().split(" ");

        int[] out = new int[s.length];

        for (int i = 0; i < s.length; i++)

            out[i] = Integer.parseInt(s[i]);

        return out;

    }

    static class direction {
        public int x;
        public int y;
    }

    static int parite(int x) {
        x ^= (x >> 16);
        x ^= (x >> 8);
        x ^= (x >> 4);
        x ^= (x >> 2);
        x ^= (x >> 1);
        return (x & 1);
    }

    static long crepes_parfaites0(int duree, int nbDisques, direction[] directions) {
        
        int noDisque = 0;
        long nb_crepes = 0;
        int e = 0 , a , b;
        int[] posZero = new int[duree];
        byte[] valStand = new byte[duree];

        for (int i = 0; i <= duree; i++) {
            if (i != 0) {
                if (noDisque == 0) {
                    posZero[e] = i -1;
                    e++;
                    valStand[i-1]=1;
                }
                else valStand[i-1]=0;
            }
            if (parite(i) == 0) {
                noDisque = directions[noDisque].x;
            } else {
                noDisque = directions[noDisque].y;
            }
        }
        
       if (e==duree) System.out.println("stop");

        for (int i=0; i<e-2 ;i++) {
            a=posZero[i];
            if (-a+posZero[i+1]*2<duree) {
                for (int j = i + 1; j < e; j++) {
                    try {
                        nb_crepes = valStand[posZero[j] * 2 - a] + nb_crepes;
                    } catch (Exception u) {
                        break;
                    }
                }
            }
        }
        return nb_crepes;

    }
    public static void main(String args[])
    {
        int[] u = read_int_line();
        int duree = u[0];
        int nbDisques = u[1];
        direction[] directions = new direction[nbDisques];
        for (int i = 0; i < nbDisques; i++)
        {
            int[] v = read_int_line();
            int x = v[0];
            int y = v[1];
            direction w = new direction();
            w.x = x;
            w.y = y;
            directions[i] = w;
        }
        System.out.println(crepes_parfaites0(duree, nbDisques, directions));
    }
}