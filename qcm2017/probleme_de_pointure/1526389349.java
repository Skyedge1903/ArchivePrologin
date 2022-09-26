import java.util.*;

public class Main
{
    static Scanner scanner = new Scanner(System.in);

    static void difference_de_pointure(int a, int b)
    {
       System.out.print(Math.abs(a-b));
    }

    public static void main(String args[])
    {
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        difference_de_pointure(a, b);
    }
}