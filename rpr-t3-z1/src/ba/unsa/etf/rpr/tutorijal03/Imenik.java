package ba.unsa.etf.rpr.tutorijal03;
import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> popis = new HashMap<>();

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
    
    public Set<String> izGrada(FiksniBroj.Grad g){
        TreeSet<String> s = new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj>  x : popis.entrySet()){
            if(x.getValue() instanceof FiksniBroj && ((FiksniBroj) x.getValue()).getPozivni().equals(g)) s.add(x.getKey());
        }
        return s;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        TreeSet<TelefonskiBroj> s = new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj>  x : popis.entrySet()){
            if(x.getValue() instanceof FiksniBroj && ((FiksniBroj) x.getValue()).getPozivni().equals(g)) s.add(x.getValue());
        }
        return s;
    }
}
