package ba.unsa.etf.rpr.tutorijal03;
import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> popis;

    public Imenik() {
        popis = new HashMap<>();
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        popis.put(ime, broj);
    }

    public String dajBroj(String ime) {
        return popis.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> x : popis.entrySet()) {
            if (x.getValue().equals(broj)) return x.getKey();
        }
        return "";
    }
    public String naSlovo(char z) {
        String novi = "";
        int i = 1;
        for (Map.Entry<String, TelefonskiBroj> a : popis.entrySet()) {
            if (a.getKey().charAt(0) == z) {
                novi += i +". "+ a.getKey() +" - "+ a.getValue().ispisi() + "\n";
                i++;
            }
        }
        return novi;
    }
}
