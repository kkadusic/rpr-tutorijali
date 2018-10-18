package etf.unsa.ba;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);
        System.out.print("Unesite n: ");
        int n = unos.nextInt();

        for(int i = 1; i <= n; i++) {
            int suma = sumaCifara(i);
            if(i % suma == 0) {
                System.out.println(i + " je djeljiv sa " + suma);
            }
        }
    }
    public static int sumaCifara(int n) {
        int suma = 0;
        while(n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }
}