package ba.unsa.etf.rpr.tutorijal04;
import java.util.ArrayList;
import java.util.Date;

public class PodaciOSemestru {
    private int odsjekID;
    private Date datumUpisa;
    private Date datumOvjere;
    private int brojSemestra;
    private ArrayList<Predmet> predmetiKojePohadja;

    public PodaciOSemestru(Date datum_upisa, int broj_semestra) {
        this.datumUpisa = datum_upisa;
        this.brojSemestra = broj_semestra;
    }

    public ArrayList<Predmet> getPredmetiKojePohadja() {
        return predmetiKojePohadja;
    }

    public int getOdsjekID() {
        return odsjekID;
    }

    public void setOdsjekID(int broj) {
        this.odsjekID = broj;
    }
}