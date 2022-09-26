import java.util.*;

public class Exo {
  static Scanner scanner = new Scanner(System.in);
	
	static void le_juste_prix0(int n, int[] p)
  {
	int e=0;
    for (int i=0 ; i<n ; i++) {
    	e = p [i] +e;
    }
    e=e/n;
    e= (int) Math.floor(e);
    
    System.out.println(e);
  }

	public static void main(String []args)
	{    
		int n = scanner.nextInt();
		int[] p = new int[n];
		for(int i = 0; i < n; ++i)
			p[i] = scanner.nextInt();
    	le_juste_prix0(n, p);
	}
}