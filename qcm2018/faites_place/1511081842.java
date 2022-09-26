import java.util.Scanner;

public class CODE_2_CONCOURS {
    static int[] read_int_line()
    {
        String[] s = scanner.nextLine().split(" ");
        int[] out = new int[s.length];
        for (int i = 0; i < s.length; i++)
            out[i] = Integer.parseInt(s[i]);
        return out;
    }
    static Scanner scanner = new Scanner(System.in);

    static int faites_place0(int n, int m, int[] emplacements)
    {
        int i=0; int d_max=0;
        if (Math.floor(emplacements[i]-0.5)>d_max) d_max=(int)Math.floor(emplacements[i]-0.5);
        for (i=0;i<=m-2;i++) {
            if (Math.floor((emplacements[i+1]-emplacements[i])/2)>d_max) d_max=(int)Math.floor((emplacements[i+1]-emplacements[i])/2);
        }
        if (Math.floor(n-emplacements[i]-0.5)>d_max) d_max=(int)Math.floor(n-emplacements[i]-0.5);
        return(d_max);
    }
    public static void main(String args[])
    {
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int[] emplacements = read_int_line();
        System.out.println(faites_place0(n, m, emplacements));
    }
}