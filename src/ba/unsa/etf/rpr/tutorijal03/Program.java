package ba.unsa.etf.rpr.tutorijal03;
import java.util.*;

public class Program {
    public MobilniBroj unesiMobilni() {
        System.out.println("Unesite mobilni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s = ulaz.nextLine();
        System.out.println("Unesite redni broj mobilne mreze:\n");
        int n = ulaz.nextInt();
        MobilniBroj m = new MobilniBroj(n, s);
        return m;
    }
    public MedunarodniBroj unesiMedunarodni() {
        System.out.println("Unesite medjunarodni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s1 = ulaz.nextLine();
        System.out.println("Unesite drzavu;\n");
        String s2 = ulaz.nextLine();
        MedunarodniBroj m = new MedunarodniBroj(s2, s1);
        return m;
    }
    public FiksniBroj unesiFiksni() {
        System.out.println("Unesite fiksni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s = ulaz.nextLine();
        System.out.println("Unesite redni broj grada:\n");
        int redni = ulaz.nextInt();
        FiksniBroj f = new FiksniBroj(FiksniBroj.Grad.valueOf(redni), s);
        return f;
    }
    
    public static void main(String[] args) {
        int izbor = -1;
        Imenik imenik = new Imenik();
        System.out.println("Izaberite opciju (-1 za kraj): \n" +
                "1. Unesite mobilni broj: \n" +
                "2. Unesite medunarodni broj: \n" +
                "3. Unesite fiksni broj: \n" +
                "4. Dodavanje broja u imenik: \n" +
                           
        );
        switch(izbor) {
            case -1:
                System.exit(0);
            case 1:
                MobilniBroj mobilni = new MobilniBroj(unesiMobilni());
                System.out.println("Uneseni broj: " + mobilni.ispisi());
                break;
            case 2:
                MedunarodniBroj medunarodni = new MedunarodniBroj(unesiMedunarodni());
                System.out.println("Uneseni broj: " + medunarodni.ispisi());
                break;
            case 3:
                FiksniBroj f = new FiksniBroj(unesiFiksni());
                System.out.println("Uneseni broj: " + fiksni.ispisi());
                break;
            case 4:
                Scanner ulaz = new Scanner(System.in);
                System.out.println("Unesite ime osobe:\n");
                String s = ulaz.nextLine();
                System.out.println("1. (mobilni broj), 2. (medjunarodni broj), 3. (fiksni broj)\n");
                int broj = ulaz.nextInt();
                if (broj == 1) imenik.dodaj(s, unesiMobilni());
                else if (broj == 2) imenik.dodaj(s, unesiMedunarodni());
                else if (broj == 3) imenik.dodaj(s, unesiFiksni());
                break;
        }
}
