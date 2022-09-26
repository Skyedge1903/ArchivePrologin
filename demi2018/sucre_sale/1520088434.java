import java.util.*;

public class Exo
{
  static Scanner scanner = new Scanner(System.in);


  public static void sucre_sale0(int n, int p, int m, int[] d)
  {
  	int a=0;
  	int b=0;
  	int c=0;
    for (int i = 0; i<m ; i++) {
    	if (d[i]==0) a++;
    	if (d[i]==1) b++;
    	if (d[i]==2) c++;
    }
    n=n-a;
    p=p-b;
    if (n>0) c=c-n;
    if (p>0) c=c-p;
    if (c<0) c=0;
    
    if (n<0) c=c-n;
    if (p<0) c=c-p;
    System.out.println(c);
  }
  public static void main(String args[])
  {
    int n = scanner.nextInt();
    int p = scanner.nextInt();
    int m = scanner.nextInt();
    int[] d = new int[m];

    for(int i = 0; i < m; ++i)
      d[i] = scanner.nextInt();
    sucre_sale0(n, p, m, d);
  }
  
}