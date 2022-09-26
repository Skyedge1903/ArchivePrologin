import java.util.Scanner;
public class CODE_5_CONCOURS_2019_BIS1
{
    static Scanner scanner = new Scanner(System.in);
    static int[] read_int_line()
    {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++) out[i] = Integer.parseInt(s[i]);
        return out;
    }
    static int[] permutations(int[] motif , int n)
    {
        int[] resultat = new int[n];
        for (int i = 1 ; i<=n ;i++) resultat[motif[i-1]-1]=i;
        return resultat;
    }
    static void statuettes0(int[] motif, int n, int[] tailles, int m) {
        boolean[] bytes_motif = new boolean[n - 1];
        boolean[] bytes_chaine = new boolean[m - 1];
        int[] motif_bis = motif;
        int[] resultat_final = new int[m];
        int e = 0;
        motif = permutations(motif, n);


        for (int i = 0; i < n - 1; i++) {
            bytes_motif[i] = motif[i] >= motif[i + 1];
        }

        for (int i = 0; i < m - 1; i++) {
            bytes_chaine[i] = tailles[i] >= tailles[i + 1];
        }

        int jonction=n-1;
        int[] failure = computeFailure(bytes_motif,(n-1));
        for (int u =0 ; u<failure.length ; u++) {
            if (failure[u]!=0) {
                jonction=u;
                break;
            }
        }

        boolean verif;
        int fromIndex = 1-jonction;
        while (fromIndex <= (m - 1) - (n - 1)) {
            fromIndex = indexOf(bytes_chaine, (m - 1), bytes_motif, (n - 1), fromIndex-1+jonction , failure) + 1;
            if (fromIndex == 0) break;
            verif = true;
            for (int i = 0; i < n -1; i++) {
                if (!(tailles[(fromIndex - 1 + motif_bis[i] - 1)] < tailles[(fromIndex - 1 + motif_bis[i + 1] - 1)])) {
                    verif = false;
                    break;
                }
            }
            if (verif) {
                resultat_final[e] = fromIndex;
                e++;
            }
        }
        System.out.println(e);
        for (int i = 0; i < e; i++) System.out.print(resultat_final[i] + " ");
    }
    private static int indexOf(boolean[] data, int source_lengt, boolean[] pattern, int search_lengt, int fromIndex, int[] failure) {

        int j = 0;
        if (source_lengt == 0) return -1;

        for (int i = fromIndex; i < source_lengt; i++) {
            while (j > 0 && pattern[j] != data[i]) {
                j = failure[j - 1];
            }
            if (pattern[j] == data[i]) { j++; }
            if (j == search_lengt) {
                return i - search_lengt + 1;
            }
        }
        return -1;
    }
    private static int[] computeFailure(boolean[] pattern, int pattern_length) {
        int[] failure = new int[pattern_length];

        int j = 0;
        for (int i = 1; i < pattern_length; i++) {
            while (j > 0 && pattern[j] != pattern[i]) {
                j = failure[j - 1];
            }
            if (pattern[j] == pattern[i]) {
                j++;
            }
            failure[i] = j;
        }
        return failure;
    }
    public static void main(String args[])
    {
        int[] be = read_int_line();
        int n = be[0];
        int m = be[1];
        int[] motif = read_int_line();
        int[] tailles = read_int_line();
        statuettes0(motif, n, tailles, m);
    }
}