import java.util.*;

public class Exo
{
  static Scanner scanner = new Scanner(System.in);
  static void tete_en_lair0(int n)
  {
    int t = 0;
    for (int i =0; i<=n ; i++) {
      for (int j =0 ; j<=n ; j++) {
        for (int k =0 ; k<=n ; k++) {
          t= i*100+j*10+k;
          if (t%2!=0 && t%5!=0 && t%11!=0 && t!=0 && (i+j+k)%2!=0 && (i*j*k)%2==0) {
            System.out.print(i);
            System.out.print(j);
            System.out.print(k);
            System.out.println();
          }

    }
    }
    }
  }
  public static void main(String args[])
  {
    int n = scanner.nextInt();
    tete_en_lair0(n);
  }
  
}