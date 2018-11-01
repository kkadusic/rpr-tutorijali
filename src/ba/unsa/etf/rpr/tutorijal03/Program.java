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
    public MedunarodniBroj unesiMedunarodni() {
        System.out.println("Unesite broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s1 = ulaz.nextLine();
        System.out.println("Unesite drzavu;\n");
        String s2 = ulaz.nextLine();
        MedunarodniBroj medunarodni = new MedunarodniBroj(s2, s1);
        return medunarodni;
    }
    public static void main(String[] args) {
        int izbor = -1;
        Imenik imenik = new Imenik();
        System.out.println("Izaberite opciju (-1 za kraj): \n" +
                "1. Unesite mobilni broj: \n" +
                "2. Unesite medunarodni broj: \n" +
                "3. Unesite fiksni broj: \n" +
        );
        switch(izbor) {
            case -1:
                System.exit(0);
            case 1:
                MobilniBroj mobilni = new MobilniBroj(unesiMobilni());
                System.out.println("Unijeli ste broj: " + mobilni.ispisi() = "\n");
                break;
            case 2:
                MedunarodniBroj medunarodni = new MedunarodniBroj(unesiMedunarodni());
                System.out.println("Unijeli ste broj: " + medunarodni.ispisi() = "\n");
                break;

        }
}
