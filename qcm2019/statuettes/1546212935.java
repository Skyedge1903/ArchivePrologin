import java.util.Scanner;

public class CODE_5_CONCOURS_2019_FINAL_FINAL {
    static Scanner scanner = new Scanner(System.in);

    static int[] read_int_line() {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++) out[i] = Integer.parseInt(s[i]);
        return out;
    }

    static int[] permutations(int[] motif, int n) {
        int[] resultat = new int[n];
        for (int i = 1; i <= n; i++) resultat[motif[i - 1] - 1] = i;
        return resultat;
    }

    static int[] glisser_tableau(int[] motif_permuté, int n) {
        System.arraycopy(motif_permuté, 0, motif_permuté, 1, n - 1);
        return motif_permuté;
    }

    static int[] saut(int[] motif_permuté, int n, int[][] etapes) {
        int[] resultat = new int[n + 1];
        motif_permuté = glisser_tableau(motif_permuté,n);
        motif_permuté[0]=0;
        int[] reset = new int[n];
        System.arraycopy(motif_permuté, 0, reset, 0, n);
        int i= 0;

        while (true) {
            if (motif_permuté[etapes[0][0] - 1] == 0 || motif_permuté[etapes[2][0] - 1] == 0 || motif_permuté[etapes[0][0]-1] >= motif_permuté[etapes[2][0] - 1]) {
                resultat[0] = i + 1;
                break;
            } else {
                System.arraycopy(glisser_tableau(motif_permuté,n), 0, motif_permuté, 0, n);
                i++;
            }
        }
        System.arraycopy(reset, 0, motif_permuté , 0, n);
        i=0;

        for (int o =1 ; o<n+1 ; o++) {
            while (true) {
                if (motif_permuté[etapes[0][o] - 1] == 0 || motif_permuté[etapes[2][o] - 1] == 0 || motif_permuté[etapes[0][o] - 1] <= motif_permuté[etapes[2][o] - 1]) {
                    resultat[o] = i + 1;
                    break;
                } else {
                    System.arraycopy(glisser_tableau(motif_permuté,n), 0, motif_permuté, 0, n);
                    i++;
                }
            }
        }

        return resultat;
    }

    static int[][] chasles(int[] motif, int n, int[] motif_permuté) {
        int[][] etapes = new int[3][n + 1];
        for (int i = n; i >= 0; i--) {
            if (i == n) {
                etapes[0][0] = n;
                etapes[1][0] = 1;
                if (motif_permuté[n-1] >= n) etapes[2][0] = n;
                else etapes[2][0] = motif[motif_permuté[n-1]];
            } else {
                etapes[0][n - i] = i + 1;
                etapes[1][n - i] = 0;
                if (motif_permuté[i] >= n) etapes[2][n - i] = i+1;
                else etapes[2][n - i] = motif[motif_permuté[i]];
            }
        }
        return etapes;
    }

    static void statuettes0(int[] motif, int n, int[] tailles, int m) {

        int motif_permuté[] = permutations(motif, n);
        int etapes[][] = chasles(motif, n, motif_permuté);
        int sauter[] = saut(motif_permuté, n, etapes);
        int ok, e = 0;
        int[] resultat = new int[m];

        for (int fromIndex = 0; fromIndex < m - n + 1; fromIndex = fromIndex + sauter[ok]) {
            ok=0;
            for (int n_etape = 0; n_etape < n + 1; n_etape++) {
                if ((tailles[etapes[0][n_etape] - 1 + fromIndex] <= tailles[etapes[2][n_etape] - 1 + fromIndex])) {
                    ok = n_etape;
                }
                else break;
            }
            if (ok == n) {
                resultat[e] = fromIndex;
                e++;
            }
        }
        System.out.println(e);
        for (int i = 0; i < e; i++) {
            System.out.print(resultat[i] + 1 + " ");
        }
    }

    public static void main(String args[]) {
        int[] be = read_int_line();
        int n = be[0];
        int m = be[1];
        int[] motif = read_int_line();
        int[] tailles = read_int_line();
        if (n <= m) {
            statuettes0(motif, n, tailles, m);
        } else System.out.print(0);
    }
}