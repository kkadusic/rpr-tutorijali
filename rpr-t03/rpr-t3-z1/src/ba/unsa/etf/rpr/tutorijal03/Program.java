package ba.unsa.etf.rpr.tutorijal03;
import java.util.*;

public class Program {
    public static MobilniBroj unesiMobilni() {
        System.out.println("Unesite mobilni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s = ulaz.nextLine();
        System.out.println("Unesite redni broj mobilne mreze:\n");
        int n = ulaz.nextInt();
        MobilniBroj m = new MobilniBroj(n, s);
        return m;
    }
    
    public static MedunarodniBroj unesiMedunarodni() {
        System.out.println("Unesite medjunarodni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s1 = ulaz.nextLine();
        System.out.println("Unesite drzavu;\n");
        String s2 = ulaz.nextLine();
        MedunarodniBroj m = new MedunarodniBroj(s2, s1);
        return m;
    }
    
    public static FiksniBroj unesiFiksni() {
        System.out.println("Unesite fiksni broj:\n");
        Scanner ulaz = new Scanner(System.in);
        String s = ulaz.nextLine();
        System.out.println("Unesite redni broj grada:\n");
        String redni = ulaz.nextLine();
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
                "5. Nadji broj osobe: \n" +
                "6. Nadjite brojeve imena koji pocinju sa slovom: \n" +
                "7. Imena osoba iz grada: \n"
                           
        );
        switch(izbor) {
            case -1:
                System.exit(0);
            case 1:
                MobilniBroj mobilni = unesiMobilni();
                break;
            case 2:
                MedunarodniBroj medunarodni = unesiMedunarodni();
                break;
            case 3:
                FiksniBroj f = unesiFiksni();
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
            case 5:
                System.out.println("Unesite ime osobe ciji broj trazite:\n");
                break;
            case 6:
                System.out.println("Unesite pocetno slovo imena:\n");
                break;
            case 7:
                System.out.println("Unesite redni broj grada: \n");
                break;
        }
    }
}
