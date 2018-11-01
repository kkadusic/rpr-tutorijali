package ba.unsa.etf.rpr.tutorijal03;
import java.util.*;

public class Program {
    public MobilniBroj unesiMobilni() {
        System.out.println("Unesite mobilni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s = ulaz.nextLine();
        System.out.println("Unesite redni broj mobilne mreze:\n");
        int n = ulaz.nextInt();
        MobilniBroj mobilni = new MobilniBroj(n, s);
        return mobilni;
    }
}
